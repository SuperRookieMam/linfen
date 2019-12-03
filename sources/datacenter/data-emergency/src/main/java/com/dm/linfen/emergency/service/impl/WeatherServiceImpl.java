package com.dm.linfen.emergency.service.impl;

import com.dm.linfen.emergency.entity.EnvironmentHour;
import com.dm.linfen.emergency.entity.FutureWeather;
import com.dm.linfen.emergency.entity.HealthIndex;
import com.dm.linfen.emergency.entity.QEnvironmentHour;
import com.dm.linfen.emergency.repository.EnvironmentHourRepository;
import com.dm.linfen.emergency.repository.FutureWeatherRepository;
import com.dm.linfen.emergency.repository.HealthIndexRepository;
import com.dm.linfen.emergency.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 温东山
 * @create 2019-07-31 10:23
 **/
@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private HealthIndexRepository healthIndexRepository;

	@Autowired
	private FutureWeatherRepository futureWeatherRepository;

	@Autowired
	private EnvironmentHourRepository environmentHourRepository;

	final static QEnvironmentHour QENVIRONMENTHOUR = QEnvironmentHour.environmentHour;

	@Override
	public List<EnvironmentHour> findIndexTrend(Integer num, String districtId) {
		ZonedDateTime dataTime = ZonedDateTime.now().minusHours(num);
		String yyyyMMddHH = DateTimeFormatter.ofPattern("yyyyMMddHH").format(dataTime);
		return environmentHourRepository.findByDistrictIdAndGoeDate(yyyyMMddHH, districtId);
	}

	@Override
	public HealthIndex findTodayHealthIndex(LocalDate today, String districtId) {
		return healthIndexRepository.findByCollectTimeAndDistrictId(today, districtId);
	}

	@Override
	public FutureWeather findFutureWeather(LocalDate today, String districtId) {
		return futureWeatherRepository.findByDateAndDistrictId(today, districtId);
	}
}
