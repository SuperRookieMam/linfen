package com.dm.data.show.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.HourScenicParkingConverter;
import com.dm.data.show.dto.HourScenicParkingDto;
import com.dm.data.show.entity.HourScenicParking;
import com.dm.data.show.entity.QHourScenicParking;
import com.dm.data.show.repository.HourScenicParkingRepository;
import com.dm.data.show.service.HourScenicParkingService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class HourScenicParkingServiceImpl extends BaseIndexServiceImpl<HourScenicParking, HourScenicParkingDto> implements HourScenicParkingService {

	@Autowired
	private HourScenicParkingRepository hourScenicParkingRepository;

	@Autowired
	private HourScenicParkingConverter hourScenicParkingConverter;
	
	private final QHourScenicParking qHourScenicParking = QHourScenicParking.hourScenicParking;

	@Override
	protected JpaRepository<HourScenicParking, Long> getRepository() {
		return hourScenicParkingRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<HourScenicParking> getQuerydsl() {
		return hourScenicParkingRepository;
	}

	@Override
	protected AbstractConverter<HourScenicParking, HourScenicParkingDto> getConverter() {
		return hourScenicParkingConverter;
	}

	@Override
	protected HourScenicParking newModel() {
		return new HourScenicParking();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, HourScenicParkingDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getCurrentDate() != null) {
			booleanBuilder.and(qHourScenicParking.currentDate.eq(dto.getCurrentDate()));
		}
		if(StringUtils.isNotBlank(dto.getName())) {
			booleanBuilder.and(qHourScenicParking.name.eq(dto.getName()));
		}
		return booleanBuilder;
	}

}
