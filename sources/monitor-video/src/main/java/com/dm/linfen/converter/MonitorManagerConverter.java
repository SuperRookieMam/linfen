package com.dm.linfen.converter;

import com.dm.linfen.dto.MonitorManagerDto;
import com.dm.linfen.entity.MonitorManager;
import org.springframework.stereotype.Component;

@Component
public class MonitorManagerConverter extends MAbstractBaseConverter<MonitorManager, MonitorManagerDto> {

	@Override
	protected MonitorManagerDto toDtoActual(MonitorManager model) {
		MonitorManagerDto dto = super.toDtoActual(model);
		dto.setCoverPhoto(model.getCoverPhoto());
		dto.setId(model.getId());
		dto.setLatitude(model.getLatitude());
		dto.setLongitude(model.getLongitude());
		dto.setMonitorName(model.getMonitorName());
		dto.setRoomNumber(model.getRoomNumber());
		dto.setMonitorPullUrl(model.getMonitorPullUrl());
		dto.setMonitorPushUrl(model.getMonitorPushUrl());
		dto.setNo(model.getNo());
		dto.setScenic(model.getScenic());
		dto.setRegionCode(model.getRegionCode());
		dto.setPullPassword(model.getPullPassword());
		dto.setPushPassword(model.getPushPassword());
		dto.setCameraUrl(model.getCameraUrl());
		dto.setWidth(model.getWidth());
		dto.setHeight(model.getHeight());
        dto.setAudioSwitch(model.getAudioSwitch());
		dto.setRun(model.getRun());
		dto.setTransformType(model.getTransformType());
		return dto;
	}

	@Override
	public MonitorManager copyProperties(MonitorManager model, MonitorManagerDto dto) {
		model = super.copyProperties(model, dto);
		model.setCoverPhoto(dto.getCoverPhoto());
		model.setLatitude(dto.getLatitude());
		model.setLongitude(dto.getLongitude());
		model.setMonitorName(dto.getMonitorName());
		model.setRoomNumber(dto.getRoomNumber());
		model.setMonitorPullUrl(dto.getMonitorPullUrl());
		model.setMonitorPushUrl(dto.getMonitorPushUrl());
		model.setNo(dto.getNo());
		model.setScenic(dto.getScenic());
		model.setRegionCode(dto.getRegionCode());
		model.setPullPassword(dto.getPullPassword());
		model.setPushPassword(dto.getPushPassword());
		model.setCameraUrl(dto.getCameraUrl());
		model.setWidth(dto.getWidth());
        model.setHeight(dto.getHeight());
        model.setAudioSwitch(dto.getAudioSwitch());
        model.setRun(dto.getRun());
		model.setTransformType(dto.getTransformType());
		return model;
	}
	public void refreshDto(MonitorManagerDto dto, MonitorManager model) {
		dto.setCoverPhoto(model.getCoverPhoto());
		dto.setId(model.getId());
		dto.setLatitude(model.getLatitude());
		dto.setLongitude(model.getLongitude());
		dto.setMonitorName(model.getMonitorName());
		dto.setRoomNumber(model.getRoomNumber());
		dto.setMonitorPullUrl(model.getMonitorPullUrl());
		dto.setMonitorPushUrl(model.getMonitorPushUrl());
		dto.setNo(model.getNo());
		dto.setScenic(model.getScenic());
		dto.setRegionCode(model.getRegionCode());
		dto.setPullPassword(model.getPullPassword());
		dto.setPushPassword(model.getPushPassword());
		dto.setCameraUrl(model.getCameraUrl());
		dto.setWidth(model.getWidth());
        dto.setHeight(model.getHeight());
        dto.setAudioSwitch(model.getAudioSwitch());
		dto.setRun(model.getRun());
		dto.setTransformType(model.getTransformType());
	}
	@Override
	protected MonitorManagerDto getDto() {
		return new MonitorManagerDto();
	}

}
