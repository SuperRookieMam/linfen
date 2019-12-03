package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.HourScenicParkingConverter;
import com.dm.data.show.dto.HourScenicParkingDto;
import com.dm.data.show.entity.HourScenicParking;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.HourScenicParkingService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("hourScenicParkings")
@Api(tags = {"每小时景区停车位"})
public class HourScenicParkingController extends BaseIndexController<HourScenicParking, HourScenicParkingDto> {

	@Autowired
	private HourScenicParkingConverter hourScenicParkingConverter;

	@Autowired
	private HourScenicParkingService hourScenicParkingService;

	@Override
	protected AbstractConverter<HourScenicParking, HourScenicParkingDto> getConverter() {
		return hourScenicParkingConverter;
	}

	@Override
	protected BaseIndexService<HourScenicParking, HourScenicParkingDto> getService() {
		return hourScenicParkingService;
	}

}