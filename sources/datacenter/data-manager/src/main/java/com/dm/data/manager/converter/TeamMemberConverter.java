package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TeamMemberDto;
import com.dm.data.manager.entity.TeamMember;
import org.springframework.stereotype.Component;

@Component
public class TeamMemberConverter extends AbstractBaseConverter<TeamMember, TeamMemberDto> {

    @Override
    protected TeamMemberDto toDtoActual(TeamMember model) {
        TeamMemberDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setMemberName(model.getMemberName());
        dto.setMobile(model.getMobile());
        dto.setCarNumber(model.getCarNumber());
        dto.setRegionCode(model.getRegionCode());
        return dto;
    }

    @Override
    public TeamMember copyProperties(TeamMember model, TeamMemberDto dto) {
        model = super.copyProperties(model, dto);
        model.setMemberName(dto.getMemberName());
        model.setMobile(dto.getMobile());
        model.setCarNumber(dto.getCarNumber());
        model.setRegionCode(dto.getRegionCode());
        return model;
    }

    @Override
    protected TeamMemberDto getDto() {
        return new TeamMemberDto();
    }
}
