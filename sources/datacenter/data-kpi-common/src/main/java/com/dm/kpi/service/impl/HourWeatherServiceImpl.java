package com.dm.kpi.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.converter.HourWeatherConverter;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.kpi.dto.HourWeatherDto;
import com.dm.kpi.entity.HourWeather;
import com.dm.kpi.entity.QHourWeather;
import com.dm.kpi.repository.HourWeatherRepository;
import com.dm.kpi.service.HourWeatherService;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class HourWeatherServiceImpl extends BaseIndexServiceImpl<HourWeather, HourWeatherDto> implements HourWeatherService {

	@Autowired
	private HourWeatherConverter hwConverter;

	@Autowired
	private HourWeatherRepository hwReposotiry;

	private final QHourWeather qHourWeather = QHourWeather.hourWeather;
	
	@Override
	protected JpaRepository<HourWeather, Long> getRepository() {
		return hwReposotiry;
	}

	@Override
	protected QuerydslPredicateExecutor<HourWeather> getQuerydsl() {
		return hwReposotiry;
	}

	@Override
	protected AbstractConverter<HourWeather, HourWeatherDto> getConverter() {
		return hwConverter;
	}


	@Override
	protected HourWeather newModel() {
		return new HourWeather();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, HourWeatherDto dto) {
		BooleanBuilder query = new BooleanBuilder();
		if (!Objects.isNull(user)) {
			String regionCode = user.getRegionCode();
			if (StringUtils.isNotBlank(regionCode)) {
				query.and(qHourWeather.regionCode.startsWith(StringUtils.stripEnd(user.getRegionCode(), "0")));
			}
		}

		if (StringUtils.isNotBlank(keywords)) {
			query.and(qHourWeather.regionCode.containsIgnoreCase(keywords)
					.or(qHourWeather.regionName.contains(keywords))
					.or(qHourWeather.whether.containsIgnoreCase(keywords)));
		}
		return query;
	}

	@Override
	public List<HourWeather> findHourWeathers(Integer num, String districtId) {
		ZonedDateTime zonedDateTime = ZonedDateTime.now().withMinute(0).withSecond(0).withNano(0).minusHours(num);
		return hwReposotiry.findByDistrictIdAndCurrentDate(districtId,zonedDateTime);
	}

}
