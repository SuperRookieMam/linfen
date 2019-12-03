package com.dm.linfen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dm.linfen.constPackage.MonitorConst;
import com.dm.linfen.dto.MonitorManagerDto;
import com.dm.linfen.entity.MonitorManager;
import com.dm.linfen.service.MonitorManagerService;
import lombok.extern.slf4j.Slf4j;
import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.javacv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MonitorManagerServiceImpl extends AbstractCurrencyServiceImpl<MonitorManager>
		implements MonitorManagerService {
	@Autowired
	private com.dm.linfen.repository.MonitorManagerRepository monitorManagerRepository;

	@Autowired
	private TaskExecutor taskExecutor;

	@Autowired
	private com.dm.linfen.converter.MonitorManagerConverter monitorManagerConverter;
	@Value("${video.path}")
	private String localPath;
	@Value("${video.prefix}")
	private String lastPrix;
	@Value("${video.ffmpegPath}")
	private String ffmpegPath;
	// private QMonitorManager qMonitorManager = QMonitorManager.MonitorManager;

	@Override
	public Optional<MonitorManager> findById(Long id) {
		return monitorManagerRepository.findById(id);
	}

	@Override
	@Transactional
	public MonitorManager save(MonitorManagerDto data) {
		MonitorManager entity = new MonitorManager();
		monitorManagerConverter.copyProperties(entity, data);
		return monitorManagerRepository.save(entity);
	}

	@Override
	@Transactional
	public MonitorManager update(Long id, MonitorManagerDto data) {
		MonitorManager entity = monitorManagerRepository.getOne(id);
		monitorManagerConverter.copyProperties(entity, data);
		return entity;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		monitorManagerRepository.deleteById(id);
	}

	@Override
	public List<MonitorManagerDto>  findByRun(Boolean run) {
		return  monitorManagerConverter.toDto(monitorManagerRepository.findByRun(run));
	}


	@Override
	public Page<MonitorManager> find(MonitorManagerDto condition, String regionCode, Pageable pageable) {
		String name =condition.getMonitorName();
		if (StringUtils.isEmpty(name)){
			return monitorManagerRepository.findAll(pageable);
		}
		return monitorManagerRepository.findTop10ByRoomNumberLikeOrMonitorNameLike(name,name,pageable);
	}

	@Override
	@Transactional
	public JSONObject pushValidate(String roomNumber, String password) {
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isEmpty(roomNumber)) {
			jsonObject.put("code", "500");
			jsonObject.put("detail", "请输入房间号");
			return jsonObject;
		}
		MonitorManager monitorManager = monitorManagerRepository.findByRoomNumber(roomNumber);
		if (ObjectUtils.isEmpty(monitorManager)) {
			jsonObject.put("code", "500");
			jsonObject.put("detail", "房间号不存在");
			return jsonObject;
		}
		/**
		 * 如果密码为空字符串,则表示没有设置密码
		 */
		if (StringUtils.isEmpty(monitorManager.getPushPassword())) {
			jsonObject.put("code", "200");
			jsonObject.put("detail", "操作成功");
			return jsonObject;
		}

		if (!StringUtils.isEmpty(monitorManager.getPushPassword())
				&& monitorManager.getPushPassword().equals(password)) {
			jsonObject.put("code", "200");
			jsonObject.put("detail", "操作成功");
			return jsonObject;
		}
		jsonObject.put("code", "500");
		jsonObject.put("detail", "密码不正确");
		return jsonObject;
	}

	@Override
	public List<MonitorManagerDto> findAll() {
		return monitorManagerConverter.toDto(monitorManagerRepository.findAll());
	}

	/**
	 * 开始拉流，并推向流服务器
	 */
	@Override
	public void transferStream(Long id) {
		MonitorManager monitorManager = monitorManagerRepository.getOne(id);
		Assert.isTrue(!ObjectUtils.isEmpty(monitorManager), "请先设置摄像头信息.......");
		MonitorManagerDto monitorManagerDto = MonitorConst.SWITCH_MAP.get(id.toString());
		// 如果是后台启动后添加的管理信息，则初始化
		if (ObjectUtils.isEmpty(monitorManagerDto)) {
			monitorManagerDto = monitorManagerConverter.toDto(monitorManager);
			MonitorConst.SWITCH_MAP.put(id.toString(), monitorManagerDto);
		} else {
			// 同步全局信息
			monitorManagerConverter.refreshDto(monitorManagerDto, monitorManager);
		}
		try {
			monitorManagerDto.setRun(true);
			// 开关设置成为开启状态，同步后台管理监控信息
			monitorManagerRepository.save(monitorManagerConverter.copyProperties(monitorManager, monitorManagerDto));
			// recordByFrame(monitorManagerDto);
			packetRecord(monitorManagerDto);
		} catch (Exception e) {
			e.printStackTrace();
			monitorManagerDto.setRun(false);
			// 开关设置成为开启状态，同步后台管理监控信息
			monitorManagerRepository.save(monitorManagerConverter.copyProperties(monitorManager, monitorManagerDto));
		}
	}

	/**
	 * 开始拉流，并推向流服务器
	 */
	@Override
	@Async
	@Transactional
	public void transferStreamToLocal(Long id) {
		MonitorManager monitorManager = monitorManagerRepository.getOne(id);
		Assert.isTrue(!ObjectUtils.isEmpty(monitorManager), "请先设置摄像头信息.......");
		MonitorManagerDto monitorManagerDto = MonitorConst.SWITCH_MAP.get(id.toString());
		// 如果是后台启动后添加的管理信息，则初始化
		if (ObjectUtils.isEmpty(monitorManagerDto)) {
			monitorManagerDto = monitorManagerConverter.toDto(monitorManager);
			MonitorConst.SWITCH_MAP.put(id.toString(), monitorManagerDto);
		} else {
			if (MonitorConst.SWITCH_MAP.get(id.toString()).getRun()) {
				return;
			}
			// 同步全局信息
			monitorManagerConverter.refreshDto(monitorManagerDto, monitorManager);
		}
		try {
			monitorManagerDto.setRun(true);
			// 开关设置成为开启状态，同步后台管理监控信息
			monitorManagerRepository.save(monitorManagerConverter.copyProperties(monitorManager, monitorManagerDto));
			// recordByFrame(monitorManagerDto);
			if (monitorManagerDto.getTransformType().equals("copy")){
				  // localPacketRecord(monitorManagerDto);
				 recordByCmd(monitorManagerDto);
			}else {
				localRecordByFrame(monitorManagerDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
			monitorManagerDto.setRun(false);
			// 开关设置成为开启状态，同步后台管理监控信息
			monitorManagerRepository.save(monitorManagerConverter.copyProperties(monitorManager, monitorManagerDto));
		}
	}

	/**
	 * 关闭推流
	 */
	@Override
	public void turnOff(Long id) {
		MonitorManager monitorManager = monitorManagerRepository.getOne(id);
		Assert.isTrue(!ObjectUtils.isEmpty(monitorManager), "请先设置摄像头信息.......");
		MonitorManagerDto monitorManagerDto = MonitorConst.SWITCH_MAP.get(id.toString());
		Assert.isTrue(!ObjectUtils.isEmpty(monitorManagerDto), "请先设置摄像头信息.......");
		monitorManagerDto.setRun(false);
		monitorManager.setRun(false);
		monitorManagerRepository.save(monitorManager);
		clossProssess(id);
		log.info("关闭成功.....");
	}

	/**
	 * @param monitorManagerDto -监控管理实体
	 * @oauther 叶洪亮 根据monitorManagerDto 信息实现拉流，并向服务器转换推流
	 */
	private void recordByFrame(MonitorManagerDto monitorManagerDto) {
		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getMonitorPushUrl()), "推流地址不能为空");
		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getCameraUrl()), "流来源地址不能为空");
		// 创建一个推送流
		String pushUrl = monitorManagerDto.getMonitorPushUrl() + monitorManagerDto.getRoomNumber() + "?pushPassword="
				+ monitorManagerDto.getPullPassword();
		FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(monitorManagerDto.getCameraUrl());
		// 使用tcp的方式，不然会丢包很严重
		grabber.setOption("rtsp_transport", "tcp");
		// 创建一个拉流器，并且从新设置分辨率（长，高），是否录制音频（0:不录制/1:录制）
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(pushUrl, monitorManagerDto.getWidth(),
				monitorManagerDto.getHeight(), monitorManagerDto.getAudioSwitch());

		// 开启一个线程推流
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					grabber.start();
					recorder.setInterleaved(true);
					// 该参数用于降低延迟
					recorder.setVideoOption("tune", "zerolatency");
					recorder.setVideoOption("vcodec", "copy");
					// ultrafast(终极快)提供最少的压缩（低编码器CPU）和最大的视频流大小；
					// 参考以下命令: ffmpeg -i '' -crf 30 -preset ultrafast
					recorder.setVideoOption("preset", "ultrafast");
					// 提供输出流封装格式(rtmp协议只支持flv封装格式)
					recorder.setFormat("flv");
					// video的编码格式
//                    recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
					recorder.setVideoOption("crf", "30");
					// 不可变(固定)音频比特率
					recorder.setAudioOption("crf", "0");
					// 2000 kb/s, 720P视频的合理比特率范围
					// recorder.setVideoBitrate(2000000);
					recorder.setVideoQuality(0);
					// 视频帧率(保证视频质量的情况下最低25，低于25会出现闪屏
					recorder.setFrameRate(25);
					// 关键帧间隔，一般与帧率相同或者是视频帧率的两倍
					recorder.setGopSize(25 * 2);
					recorder.setAudioQuality(0);
					// 音频比特率
					recorder.setAudioBitrate(192000);
					// 音频采样率
					recorder.setSampleRate(44100);
					// 双通道(立体声)
					recorder.setAudioChannels(2);
					// 音频编/解码器
//                    recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
					recorder.start();
					Frame frame = null;
					long startTime = System.currentTimeMillis(), videoTS = 0;
					// frame会自动回收?
					while (monitorManagerDto.getRun() && (frame = grabber.grabFrame()) != null) {
						// log.info("推流中.....");
						videoTS = 1000 * (System.currentTimeMillis() - startTime);
						recorder.setTimestamp(videoTS);
						recorder.record(frame);
					}
				} catch (org.bytedeco.javacv.FrameGrabber.Exception | org.bytedeco.javacv.FrameRecorder.Exception e) {
					e.printStackTrace();
				} finally {
					try {
						recorder.stop();
						recorder.close();
						grabber.stop();
						grabber.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	/**
	 * 类似ffmpeg 的copy模式，
	 */
	private void packetRecord(MonitorManagerDto monitorManagerDto) {
		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getMonitorPushUrl()), "推流地址不能为空");
		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getCameraUrl()), "流来源地址不能为空");
		// 创建一个推送流
		String pushUrl = monitorManagerDto.getMonitorPushUrl() + monitorManagerDto.getRoomNumber() + "?pushPassword="
				+ monitorManagerDto.getPullPassword();
		FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(monitorManagerDto.getCameraUrl());
		// 使用tcp的方式，不然会丢包很严重
		grabber.setOption("rtsp_transport", "tcp");
		// 创建一个拉流器，并且从新设置分辨率（长，高），是否录制音频（0:不录制/1:录制）
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(pushUrl, monitorManagerDto.getWidth(),
				monitorManagerDto.getHeight(), monitorManagerDto.getAudioSwitch());
		recorder.setFormat("flv");
		recorder.setVideoOption("tune", "zerolatency");
		// 开启一个线程推流
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					grabber.start();
					recorder.start(grabber.getFormatContext());
					AVPacket packet = null;
					long startTime = System.currentTimeMillis();
					while (monitorManagerDto.getRun() && (packet = grabber.grabPacket()) != null) {
						recorder.setTimestamp(1000 * (System.currentTimeMillis() - startTime));
						recorder.recordPacket(packet);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						recorder.stop();
						recorder.close();
						grabber.stop();
						grabber.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
		log.info("开启成功.....");
	}

	/**
	 * 直接使用javacv转码存储本都
	 *
	 * @param monitorManagerDto 根据
	 */
	private void localPacketRecord(MonitorManagerDto monitorManagerDto) {
//		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getMonitorPushUrl()), "推流地址不能为空");
		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getCameraUrl()), "流来源地址不能为空");
		// 创建一个视频源
		// 使用tcp的方式，不然会丢包很严重
		// 创建一个视频目的地
		String path = localPath + File.separator + monitorManagerDto.getRoomNumber() + lastPrix;
		try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(monitorManagerDto.getCameraUrl());
			 // 如果声音不设置为1的话，会导致复制模式，关闭出错
			FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(path, 1);) {
			grabber.setOption("rtsp_transport", "tcp");
			grabber.setOption("vcodec", "copy");
			grabber.start();
			recorder.setImageHeight(grabber.getImageHeight());
			recorder.setImageWidth(grabber.getImageWidth());
			recorder.setOption("hls_wrap", "5");
			recorder.setOption("hls_time", "10");
			recorder.setOption("start_number", "0");
			recorder.setOption("hls_list_size","2");
			recorder.start(grabber.getFormatContext());
			recordPacket(recorder, grabber, monitorManagerDto);
		} catch (FrameRecorder.Exception e) {
			e.printStackTrace();
		} catch (FrameGrabber.Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void localRecordByFrame(MonitorManagerDto monitorManagerDto) {
//		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getMonitorPushUrl()), "推流地址不能为空");
		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getCameraUrl()), "流来源地址不能为空");
		// 创建一个推送流
		String path = localPath + File.separator + monitorManagerDto.getRoomNumber() + lastPrix;
		try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(monitorManagerDto.getCameraUrl());
			 // 如果声音不设置为1的话，会导致复制模式，关闭出错
			 FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(path,1);) {
			grabber.setOption("rtsp_transport", "tcp");
			grabber.start();
			recorder.setImageWidth(monitorManagerDto.getWidth());
			recorder.setImageHeight(monitorManagerDto.getHeight());
			recorder.setOption("hls_wrap", "5");
			recorder.setOption("hls_time", "10");
			recorder.setOption("start_number", "0");
//			recorder.setFormat("hls");
//            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//			recorder.setVideoOption("crf", "30");
//			recorder.setAudioOption("crf", "0");
//			recorder.setVideoQuality(0);
//			recorder.setFrameRate(25);
//			recorder.setGopSize(25 * 2);
//			recorder.setAudioQuality(0);
//			recorder.setAudioBitrate(192000);
//			recorder.setSampleRate(44100);
//			recorder.setAudioChannels(2);
			recorder.start();
			Frame frame = null;
			long startTime = System.currentTimeMillis();
			// frame会自动回收?
			while ((frame = grabber.grabFrame()) != null) {
				if (!monitorManagerDto.getRun()) {
					return;
				}
				recorder.record(frame);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}


	private void recordPacket(FFmpegFrameRecorder recorder, FFmpegFrameGrabber grabber,
			MonitorManagerDto monitorManagerDto) throws FrameGrabber.Exception, FrameRecorder.Exception {
		AVPacket packet = null;
		Long vtd = System.currentTimeMillis();
		while (monitorManagerDto.getRun()) {
			packet =grabber.grabPacket();
			if(packet== null||packet.size()<=0||packet.data()==null) {
				continue;
			}
			recorder.recordPacket(packet);
		}
	}

	/**
	 * @param monitorManagerDto -监控管理实体
	 * @param grabber           -推流器
	 * @param recorder          拉流并重新设置分辨率
	 * @param monitorManagerDto 监控信息
	 * @oauther 叶洪亮 根据monitorManagerDto 信息实现拉流，并向服务器转换推流
	 */
	@Deprecated
	private void recordByFrame(FFmpegFrameGrabber grabber, FFmpegFrameRecorder recorder,
			MonitorManagerDto monitorManagerDto) {
		log.info("启动线程.....");
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					grabber.start();
					recorder.setInterleaved(true);
					// 该参数用于降低延迟
					recorder.setVideoOption("tune", "zerolatency");
					recorder.setVideoOption("vcodec", "copy");
					// ultrafast(终极快)提供最少的压缩（低编码器CPU）和最大的视频流大小；
					// 参考以下命令: ffmpeg -i '' -crf 30 -preset ultrafast
					recorder.setVideoOption("preset", "ultrafast");
					// 提供输出流封装格式(rtmp协议只支持flv封装格式)
					recorder.setFormat("flv");
					// video的编码格式
//                    recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
					recorder.setVideoOption("crf", "30");
					// 不可变(固定)音频比特率
					recorder.setAudioOption("crf", "0");
					// 2000 kb/s, 720P视频的合理比特率范围
					// recorder.setVideoBitrate(2000000);
					recorder.setVideoQuality(0);
					// 视频帧率(保证视频质量的情况下最低25，低于25会出现闪屏
					recorder.setFrameRate(25);
					// 关键帧间隔，一般与帧率相同或者是视频帧率的两倍
					recorder.setGopSize(25 * 2);
					recorder.setAudioQuality(0);
					// 音频比特率
					recorder.setAudioBitrate(192000);
					// 音频采样率
					recorder.setSampleRate(44100);
					// 双通道(立体声)
					recorder.setAudioChannels(2);
					// 音频编/解码器
//                    recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
					recorder.start();
					Frame frame = null;
					long startTime = 0, videoTS = 0;
					// frame会自动回收?
					while (monitorManagerDto.getRun() && (frame = grabber.grabFrame()) != null) {
						if (startTime == 0) {
							startTime = System.currentTimeMillis();
						}
						// log.info("推流中.....");
						videoTS = 1000 * (System.currentTimeMillis() - startTime);
						recorder.setTimestamp(videoTS);
						recorder.record(frame);
					}
					recorder.stop();
					grabber.stop();
				} catch (org.bytedeco.javacv.FrameGrabber.Exception | org.bytedeco.javacv.FrameRecorder.Exception e) {
					e.printStackTrace();
					if (grabber != null) {
						try {
							grabber.stop();
						} catch (org.bytedeco.javacv.FrameGrabber.Exception e1) {
							e1.printStackTrace();
						}
					}
				} finally {
					if (grabber != null) {
						try {
							grabber.stop();
						} catch (org.bytedeco.javacv.FrameGrabber.Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		thread.start();
	}


	// 留着，万一有用
	private void recordByCmd(MonitorManagerDto monitorManagerDto) {
		Assert.isTrue(!StringUtils.isEmpty(monitorManagerDto.getCameraUrl()), "流来源地址不能为空");
		String path = localPath + File.separator + monitorManagerDto.getRoomNumber() + lastPrix;
		removeFile(localPath,monitorManagerDto.getRoomNumber());
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				ProcessBuilder pb;
				List<String> commonds = new ArrayList<>();
				commonds.add(ffmpegPath);
				commonds.add("-y");
				commonds.add("-loglevel");
				commonds.add("quiet");
				commonds.add("-rtsp_transport");
				commonds.add("tcp");
				commonds.add("-i");
				commonds.add(monitorManagerDto.getCameraUrl());
				commonds.add("-vcodec");
				commonds.add("copy");
				commonds.add("-hls_time");
				commonds.add("15");
				commonds.add("-hls_wrap");
				commonds.add("5");
				commonds.add("-hls_list_size");
				commonds.add("2");
				// 这里要设置目标位置
				commonds.add(path);
				try {
					while (monitorManagerDto.getRun()){
						pb = new ProcessBuilder(commonds);
						// 如果重定向了输入流，输出流，缓冲区满了会导致线程阻塞
						// 所以这里吧日志关闭勒，不重定向输入流
						// pb.redirectErrorStream(true);
						MonitorConst.BUILDER_MAP.put(monitorManagerDto.getId().toString(),pb.inheritIO().start());
						MonitorConst.BUILDER_MAP.get(monitorManagerDto.getId().toString()).waitFor();
						log.info("尝试重启........");
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}


	private void clossProssess(Long id){
		if (!MonitorConst.BUILDER_MAP.containsKey(id.toString())) {
			return;
		}
		if (MonitorConst.BUILDER_MAP.get(id.toString()).isAlive()){
			MonitorConst.BUILDER_MAP.get(id.toString()).destroyForcibly();
			MonitorConst.BUILDER_MAP.remove(id.toString());
		}
	}


	private void  removeFile(String path,String roomNumber) {
		File file =new File(path);
		if (file.exists()&&file.isDirectory()) {
			File[] files =	file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().contains(roomNumber)) {
					files[i].delete();
				}
			}
		}

	}
}
