package com.dm.data.show.controller.temporary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.ParkingConverter;
import com.dm.data.show.dto.temporary.ParkingDto;
import com.dm.data.show.entity.temporary.Parking;
import com.dm.data.show.service.temporary.ParkingService;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("parkings")
@Api(tags = {"临时-停车场"})
public class ParkingController extends BaseIndexController<Parking, ParkingDto> {

	@Autowired
	private ParkingConverter parkingConverter;

	@Autowired
	private ParkingService parkingService;

	@Override
	protected AbstractConverter<Parking, ParkingDto> getConverter() {
		return parkingConverter;
	}

	@Override
	protected BaseIndexService<Parking, ParkingDto> getService() {
		return parkingService;
	}

}