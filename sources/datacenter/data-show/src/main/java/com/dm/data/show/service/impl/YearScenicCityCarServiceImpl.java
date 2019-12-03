package com.dm.data.show.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearScenicCityCarConverter;
import com.dm.data.show.dto.YearScenicCityCarDto;
import com.dm.data.show.entity.QYearScenicCityCar;
import com.dm.data.show.entity.YearScenicCityCar;
import com.dm.data.show.repository.YearScenicCityCarRepository;
import com.dm.data.show.service.YearScenicCityCarService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearScenicCityCarServiceImpl extends BaseIndexServiceImpl<YearScenicCityCar, YearScenicCityCarDto> implements YearScenicCityCarService {

	@Autowired
	private YearScenicCityCarRepository yearScenicCityCarRepository;

	@Autowired
	private YearScenicCityCarConverter yearScenicCityCarConverter;
	
	private final QYearScenicCityCar qYearScenicCityCar = QYearScenicCityCar.yearScenicCityCar;

	@Override
	protected JpaRepository<YearScenicCityCar, Long> getRepository() {
		return yearScenicCityCarRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearScenicCityCar> getQuerydsl() {
		return yearScenicCityCarRepository;
	}

	@Override
	protected AbstractConverter<YearScenicCityCar, YearScenicCityCarDto> getConverter() {
		return yearScenicCityCarConverter;
	}

	@Override
	protected YearScenicCityCar newModel() {
		return new YearScenicCityCar();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearScenicCityCarDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearScenicCityCar.year.eq(dto.getYear()));
		}
		if(StringUtils.isNotBlank(dto.getName())) {
			booleanBuilder.and(qYearScenicCityCar.name.eq(dto.getName()));
		}
		return booleanBuilder;
	}

}
