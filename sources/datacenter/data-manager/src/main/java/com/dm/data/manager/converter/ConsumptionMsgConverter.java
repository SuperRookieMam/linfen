package com.dm.data.manager.converter;

import com.dm.data.manager.dto.ConsumptionMsgDto;
import com.dm.data.manager.entity.ConsumptionMsg;
import org.springframework.stereotype.Component;

@Component
public class ConsumptionMsgConverter extends AbstractBaseConverter<ConsumptionMsg, ConsumptionMsgDto> {

    @Override
    protected ConsumptionMsgDto toDtoActual(ConsumptionMsg model) {
        ConsumptionMsgDto dto = super.toDtoActual(model);
        dto.setBusiness(model.getBusiness());
        dto.setDay(model.getDay());
        dto.setHoure(model.getHoure());
        dto.setId(model.getId());
        dto.setMobile(model.getMobile());
        dto.setMoney(model.getMoney());
        dto.setMonth(model.getMonth());
        dto.setTime(model.getTime());
        dto.setType(model.getType());
        dto.setYear(model.getYear());
        dto.setRegionCode(model.getRegionCode());
        return dto;
    }

    @Override
    public ConsumptionMsg copyProperties(ConsumptionMsg model, ConsumptionMsgDto dto) {
        model = super.copyProperties(model, dto);
        model.setBusiness(dto.getBusiness());
        model.setDay(dto.getDay());
        model.setHoure(dto.getHoure());
        model.setMobile(dto.getMobile());
        model.setMoney(dto.getMoney());
        model.setMonth(dto.getMonth());
        model.setTime(dto.getTime());
        model.setType(dto.getType());
        model.setYear(dto.getYear());
        model.setRegionCode(dto.getRegionCode());
        return model;
    }

    @Override
    protected ConsumptionMsgDto getDto() {
        return new ConsumptionMsgDto();
    }
}
