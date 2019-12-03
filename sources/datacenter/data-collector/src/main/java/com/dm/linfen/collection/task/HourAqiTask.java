package com.dm.linfen.collection.task;

import com.dm.linfen.collection.dto.HourAqiFetchDto;
import com.dm.linfen.collection.dto.HourAqiFetchResult;
import com.dm.linfen.collection.dto.HourWeatherFetchDto;
import com.dm.linfen.collection.dto.HourWeatherFetchResult;
import com.dm.linfen.collection.entity.District;
import com.dm.linfen.collection.repository.DistrictRepository;
import com.dm.linfen.collection.service.HourAqiExtService;
import com.dm.linfen.collection.service.HourWeatherExtService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.List;
/**
    * @Author:         温东山
    * @Description:    定时抓取天气指标数据到数据库(常用指标和基础指标)
    * @CreateDate:     2019/9/5 0005 10:43
    * @UpdateUser:     温东山
    * @UpdateDate:     2019/9/5 0005 10:43
    * @history:   修改记录
    * @Version:        1.0
*/
@Component
@Slf4j
public class HourAqiTask{

	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper om;

	@Autowired
	private HourAqiExtService hourAqiService;

	@Autowired
	private HourWeatherExtService hourWeatherExtService;

	@Autowired
	private DistrictRepository dr;

	/**
	    * @Author:         温东山
	    * @Description:    方法说明
	    * @UpdateUser:     温东山
	    * @UpdateDate:
	    * @history:   修改内容0 15 0/1 * * ?
	*/
	@Scheduled(cron = "0 15 0/1 * * ?") // 每1个小时执行一次
	public void reptilePollutantIndex() {
		try {
			List<District> districts = dr.findAll();
			for (District district : districts) {
				this.fetchAndSave(district);
			}
		} catch (Exception e) {
			log.error("获取数据时出错", e);
		}
	}

	/**
	 * 获取数据并且分开保存
	 * @param district
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private void fetchAndSave(District district) throws JsonParseException, JsonMappingException, IOException {
		String text = getData(district.getDistrictId());
		List<HourAqiFetchDto> hourAqiFetchDtoList = om.readValue(text, HourAqiFetchResult.class).getData();
		ZonedDateTime zonedDateTime = ZonedDateTime.now().minusDays(1);
		hourAqiService.saveOrUpdate(hourAqiFetchDtoList, zonedDateTime, district);
		List<HourWeatherFetchDto> hourWeatherDtoList = om.readValue(text, HourWeatherFetchResult.class).getData();
		hourWeatherExtService.saveOrUpdate(hourWeatherDtoList,zonedDateTime,district);
	}


	private String getData(String id) {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Referer", "http://www.weather.com.cn");
		headers.add("User-Agent", "");
		ResponseEntity<String> res = restTemplate.exchange(
				"http://d1.weather.com.cn/aqi_all/{pointId}.html",
				HttpMethod.GET,
				new HttpEntity<Object>(headers),
				String.class,
				id);
		return res.getBody().split("\\(")[1].split("\\)")[0];
	}

}
