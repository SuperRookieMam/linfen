package com.dm.data.show.service.temporary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.ParkingConverter;
import com.dm.data.show.dto.temporary.ParkingDto;
import com.dm.data.show.entity.temporary.Parking;
import com.dm.data.show.entity.temporary.QParking;
import com.dm.data.show.repository.temporary.ParkingRepository;
import com.dm.data.show.service.temporary.ParkingService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class ParkingServiceImpl extends BaseIndexServiceImpl<Parking, ParkingDto> implements ParkingService {

	@Autowired
	private ParkingRepository parkingRepository;

	@Autowired
	private ParkingConverter parkingConverter;

	private final QParking qParking = QParking.parking;

	@Override
	protected JpaRepository<Parking, Long> getRepository() {
		return parkingRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<Parking> getQuerydsl() {
		return parkingRepository;
	}

	@Override
	protected AbstractConverter<Parking, ParkingDto> getConverter() {
		return parkingConverter;
	} 

	@Override
	protected Parking newModel() {
		return new Parking();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, ParkingDto dto) {
		return null;
	}

}
