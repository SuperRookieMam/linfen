package com.dm.kpi.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.converter.DayWeatherConverter;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.kpi.dto.DayWeatherDto;
import com.dm.kpi.entity.DayWeather;
import com.dm.kpi.repository.DayWeatherRepository;
import com.dm.kpi.service.DayWeatherService;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 温东山
 * @Description: 类作用描述
 * @CreateDate: 2019/9/5 0005$ 16:13$
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/9/5 0005$ 16:13$
 * @history: 修改记录
 * @Version: 1.0
 */
@Service
public class DayWeatherServiceImpl extends BaseIndexServiceImpl<DayWeather, DayWeatherDto> implements DayWeatherService {
    @Autowired
    private DayWeatherRepository futureWeatherRepository;
    
    @Autowired
    private DayWeatherConverter dayWeatherConverter;

	@Override
	protected JpaRepository<DayWeather, Long> getRepository() {
		return futureWeatherRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<DayWeather> getQuerydsl() {
		return futureWeatherRepository;
	}

	@Override
	protected AbstractConverter<DayWeather, DayWeatherDto> getConverter() {
		return dayWeatherConverter;
	}

	@Override
	protected DayWeather newModel() {
		return new DayWeather();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, DayWeatherDto dto) {
		return null;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteDistrictIdAndCurrentDate(String districtId, LocalDate date) {
		futureWeatherRepository.deleteByDistrictIdAndCurrentDate(districtId, date);
	}

	@Override
	public List<DayWeather> findByDistrictIdAndDate(String districtId, LocalDate localDate) {
		return futureWeatherRepository.findByDistrictIdAndCurrentDate(districtId, localDate);
	}

}
