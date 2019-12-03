package com.dm.linfen.emergency.task;

import com.dm.linfen.emergency.entity.District;
import com.dm.linfen.emergency.entity.FutureWeather;
import com.dm.linfen.emergency.repository.DistinctRepository;
import com.dm.linfen.emergency.repository.FutureWeatherRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 温东山
 * @create 2019-07-30 09:14
 **/

/**
 * @Description: 未来天气抓取
 * @Author: 温东山
 * @CreateDate: 2019/7/30 0030 09:35
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/7/30 0030 09:35
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Component
public class FutureWeatherTask {

	@Autowired
	private DistinctRepository dr;
	@Autowired
	private FutureWeatherRepository futureWeatherRepository;

	/**
	 * 抓取未来天气
	 * 防止数据丢失,间隔时间在抓取一次数据 0 0 1,4,8,10 * * ?
	 */
	@Scheduled(cron = "0 0 1,4,8,10 * * ?") // 每1个小时执行一次
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
		StringBuilder sb = null;
		LocalDate now = LocalDate.now();
		FutureWeather futureWeather = futureWeatherRepository.findByDateAndDistrictId(now, dis.getDistrictId());
		if (futureWeather == null) {
			futureWeather = new FutureWeather();
			futureWeather.setDistrictId(dis.getDistrictId());
			futureWeather.setDistrictName(dis.getDistrictName());
			futureWeather.setDate(now);
		}
		for (int i = 0; i < lis.size(); i++) {
			sb = new StringBuilder();
			sb.append(lis.get(i).child(0).text()).append("|").append(lis.get(i).child(3).text()).append("|")
					.append(lis.get(i).child(4).text()).append("|")
					.append(lis.get(i).child(5).getElementsByClass("win").tagName("em").tagName("span").get(0).child(0)
							.tagName("span").child(0).attr("title"))
					.append("|")
					.append(lis.get(i).child(5).getElementsByClass("win").tagName("em").tagName("span").get(0).child(0)
							.tagName("span").child(1).attr("title"))
					.append("|").append(lis.get(i).child(5).getElementsByClass("win").tagName("i").text());
			if (i == 0) {
				futureWeather.setToday(sb.toString());
			} else if (i == 1) {
				futureWeather.setSecondDay(sb.toString());
			} else if (i == 2) {
				futureWeather.setThirdDay(sb.toString());
			} else if (i == 3) {
				futureWeather.setForthDay(sb.toString());
			} else if (i == 4) {
				futureWeather.setFifthDay(sb.toString());
			} else if (i == 5) {
				futureWeather.setSixthDay(sb.toString());
			} else if (i == 6) {
				futureWeather.setSeventhDay(sb.toString());
			}
		}
		futureWeatherRepository.save(futureWeather);
	}

}
