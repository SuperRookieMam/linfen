package com.dm.linfen.collection.task;

import com.dm.kpi.dto.DayWeatherDto;
import com.dm.kpi.entity.DayHealthIndex;
import com.dm.kpi.service.DayWeatherService;
import com.dm.kpi.service.DayHealthIndexService;
import com.dm.linfen.collection.entity.District;
import com.dm.linfen.collection.repository.DistrictRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 温东山
 * @create 2019-07-30 09:14
 **/

/**
 * @Description: 未来天气抓取
 * 
 * @Author: 温东山
 * 
 * @CreateDate: 2019/7/30 0030 09:35
 * 
 * @UpdateUser: 温东山
 * 
 * @UpdateDate: 2019/7/30 0030 09:35
 * 
 * @UpdateRemark: 修改内容
 * 
 * @Version: 1.0
 */
@Slf4j
@Component
public class DayWeatherTask {

	@Autowired
	private DistrictRepository dr;
	@Autowired
	private DayWeatherService futureWeatherService;

	@Autowired
	private DayHealthIndexService healthIndexService;

	/**
	 * 抓取未来天气 防止数据丢失,间隔时间在抓取一次数据 0 0 1,4,8,10 * * ?
	 */
	@Scheduled(cron = "0 15 1,4,8,10 * * ?") // 每1个小时执行一次
	public void reptileWeatherHour() {
		try {
			log.info("数据抓取开始");
			List<District> districts = dr.findAll();
			for (District dis : districts) {
				Document document = null;
				try {
					document = Jsoup.connect("http://www.weather.com.cn/weather/" + dis.getDistrictId() + ".shtml")
							.ignoreContentType(true).timeout(30000)
							.header("User-Agent",
									" Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36")
							.get();
				} catch (Exception e) {
					log.error("jsoup抓取失败", e);
					continue;
				}
				/**
				 * 抓取未来天气
				 */
				Elements lis = document.select(".c7d").select(".clearfix").select("li").select(".sky");
				setAndSaveData(dis, lis);
				/**
				 * 每次抓取一个数据停顿0.5秒
				 */
				Thread.sleep(500);
			}

		} catch (InterruptedException e) {
			log.error("数据抓取失败{}", e);
		} catch (Exception e) {
			log.error("数据抓取失败{}", e);
		}
	}

	/**
	 * 设置并且保存数据
	 *
	 * @param dis
	 * @param lis
	 */
	private void setAndSaveData(District dis, Elements lis) {
		LocalDate now = LocalDate.now();
		/**
		 * 采集之前删除历史数据
		 */
		futureWeatherService.deleteDistrictIdAndCurrentDate(dis.getDistrictId(), now);
		List<DayWeatherDto> weathers = new ArrayList<>();
		for (int i = 0; i < lis.size(); i++) {
			DayWeatherDto futureWeather = new DayWeatherDto();
			futureWeather.setDistrictId(dis.getDistrictId());
			futureWeather.setRegionName(dis.getRegionName());
			futureWeather.setRegionCode(dis.getRegionCode());
			futureWeather.setCurrentDate(ZonedDateTime.now(ZoneId.systemDefault()));
			futureWeather.setFutureDate(now.plusDays(i));
			futureWeather.setWeather(lis.get(i).child(3).text());
			String[] split = lis.get(i).child(4).text().replace("℃", "").split("\\/");
			futureWeather.setTempMax(split[0]);
			futureWeather.setTempMin(split.length > 1 ? split[1] : null);
			futureWeather.setDayWindDirection(
					lis.get(i).child(5).getElementsByClass("win").tagName("em").tagName("span").get(0).child(0)
							.tagName("span").child(0).attr("title"));
			futureWeather.setNightWindDirection(
					lis.get(i).child(5).getElementsByClass("win").tagName("em").tagName("span").get(0).child(0)
							.tagName("span").child(0).attr("title"));
			futureWeather.setWindScale(lis.get(i).child(5).getElementsByClass("win").tagName("i").text());
			weathers.add(futureWeather);
		}
		futureWeatherService.saveAll(weathers);
	}

	/**
	 * 抓取指数信息 0 0 1,4,8,10,15 * * ?
	 */
	@Scheduled(cron = "0 0 1,4,8,10,15 * * ?")
	public void reptileHealthIndex() {
		log.info("数据抓取开始");
		try {
			List<District> districts = dr.findAll();
			for (District dis : districts) {
				Document document = null;
				try {
					document = Jsoup.connect("http://d1.weather.com.cn/weather_index/" + dis.getDistrictId() + ".html")
							.ignoreContentType(true)
							.timeout(30000)
							.header("Referer", "http://www.weather.com.cn/air/?city=" + dis.getDistrictId())
							.header("User-Agent",
									" Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36")
							.get();
				} catch (Exception e) {
					log.error("抓取数据失败{}", e);
					continue;
				}
				String data = null;
				try {
					data = document.body().text().split("\\(")[1].split("\\)")[1].split("=")[1].split(";")[0];
				} catch (ArrayIndexOutOfBoundsException e) {
					log.error("解析js数据失败={}", e);
					continue;
				}
				LocalDate now = LocalDate.now();
				DayHealthIndex healthIndex = healthIndexService.findByCurrentDateAndDistrictId(now,
						dis.getDistrictId());
				if (healthIndex == null) {
					healthIndex = new DayHealthIndex();
					healthIndex.setCurrentDate(now);
					healthIndex.setDistrictId(dis.getDistrictId());
					healthIndex.setRegionCode(dis.getRegionCode());
					healthIndex.setRegionName(dis.getRegionName());
				}
				healthIndex.setInfo(data);
				healthIndexService.save(healthIndex);
			}
		} catch (Exception e) {
			log.error("解析数据失败{}", e);
		}
	}
}
