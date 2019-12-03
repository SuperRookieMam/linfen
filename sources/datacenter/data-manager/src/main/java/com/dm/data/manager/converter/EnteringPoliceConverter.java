package com.dm.data.manager.converter;

import com.dm.data.manager.dto.EnteringPoliceDto;
import com.dm.data.manager.entity.ConsumptionMsg;
import com.dm.data.manager.entity.EnteringPolice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EnteringPoliceConverter extends AbstractBaseConverter<EnteringPolice, EnteringPoliceDto> {
    @Autowired
    private ConsumptionMsgConverter consumptionMsgConverter;

    @Override
    protected EnteringPoliceDto toDtoActual(EnteringPolice model) {
        EnteringPoliceDto dto = super.toDtoActual(model);
        dto.setArea(model.getArea());
        dto.setAge(model.getAge());
        dto.setCity(model.getCity());
        dto.setConsumptionMsgs(consumptionMsgConverter.toDto(model.getConsumptionMsgs()));
        dto.setContry(model.getContry());
        dto.setDay(model.getDay());
        dto.setHoure(model.getHoure());
        dto.setId(model.getId());
        dto.setMonth(model.getMonth());
        dto.setNumber(model.getNumber());
        dto.setProvince(model.getProvince());
        dto.setScenic(model.getScenic());
        dto.setSex(model.getSex());
        dto.setStopTime(model.getStopTime());
        dto.setVisitNumber(model.getVisitNumber());
        dto.setYear(model.getYear());
        dto.setRegionCode(model.getRegionCode());
        return dto;
    }

    @Override
    public EnteringPolice copyProperties(EnteringPolice model, EnteringPoliceDto dto) {
        model = super.copyProperties(model, dto);
        model.setArea(dto.getArea());
        model.setAge(dto.getAge());
        model.setCity(dto.getCity());
        model.setConsumptionMsgs(dto.getConsumptionMsgs().stream()
                .map(ele -> consumptionMsgConverter.copyProperties(new ConsumptionMsg(), ele))
                .collect(Collectors.toList()));
        model.setContry(dto.getContry());
        model.setDay(dto.getDay());
        model.setHoure(dto.getHoure());
        model.setMonth(dto.getMonth());
        model.setNumber(dto.getNumber());
        model.setProvince(dto.getProvince());
        model.setScenic(dto.getScenic());
        model.setSex(dto.getSex());
        model.setStopTime(dto.getStopTime());
        model.setVisitNumber(dto.getVisitNumber());
        model.setYear(dto.getYear());
        model.setRegionCode(dto.getRegionCode());
        return model;
    }

    @Override
    protected EnteringPoliceDto getDto() {
        return new EnteringPoliceDto();
    }
}
