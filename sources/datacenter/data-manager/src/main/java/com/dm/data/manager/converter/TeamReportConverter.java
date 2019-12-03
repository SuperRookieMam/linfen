package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TeamReportDto;
import com.dm.data.manager.entity.TeamMember;
import com.dm.data.manager.entity.TeamReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeamReportConverter extends AbstractBaseConverter<TeamReport, TeamReportDto> {
    @Autowired
    private TourGuideConverter tourGuideConverter;

    @Autowired
    private TravelAgencyConverter travelAgencyConverter;

    @Autowired
    private TourBusConverter tourBusConverter;

    @Autowired
    private BusDriverConverter busDriverConverter;

    @Autowired
    private TeamMemberConverter teamMemberConverter;

    @Override
    protected TeamReportDto toDtoActual(TeamReport model) {
        TeamReportDto dto = super.toDtoActual(model);
        dto.setRegionCode(model.getRegionCode());
        dto.setDesc(model.getDesc());
        dto.setTeamName(model.getTeamName());
        dto.setTravelAgentcyName(model.getTravelAgentcyName());
        dto.setTravelAgentcyMobile(model.getTravelAgentcyMobile());
        dto.setGuidName(model.getGuidName());
        dto.setGuidMobile(model.getGuidMobile());
        dto.setCarnum(model.getCarnum());
        dto.setDriverMobile(model.getDriverMobile());
        dto.setDriverName(model.getDriverName());
        dto.setTeamNumbers(model.getTeamNumbers());
        dto.setStartTime(model.getStartTime());
        dto.setEndTime(model.getEndTime());
        dto.setState(model.getState());
        dto.setId(model.getId());
        dto.setScenic(model.getScenic());
        dto.setMembers(
                model.getMembers().stream().map(ele -> teamMemberConverter.toDto(ele)).collect(Collectors.toList()));
        return dto;
    }

    @Override
    public TeamReport copyProperties(TeamReport model, TeamReportDto dto) {
        model = super.copyProperties(model, dto);
        model.setRegionCode(dto.getRegionCode());
        model.setTeamName(dto.getTeamName());
        model.setTravelAgentcyName(dto.getTravelAgentcyName());
        model.setTravelAgentcyMobile(dto.getTravelAgentcyMobile());
        model.setDesc(dto.getDesc());
        model.setGuidName(dto.getGuidName());
        model.setGuidMobile(dto.getGuidMobile());
        model.setCarnum(dto.getCarnum());
        model.setDriverMobile(dto.getDriverMobile());
        model.setDriverName(dto.getDriverName());
        model.setTeamNumbers(dto.getTeamNumbers());
        model.setStartTime(dto.getStartTime());
        model.setEndTime(dto.getEndTime());
        model.setState(dto.getState());
        model.setScenic(dto.getScenic());
        model.setMembers(dto.getMembers().stream().map(ele -> teamMemberConverter.copyProperties(new TeamMember(), ele))
                .collect(Collectors.toList()));
//        model.setBusDriver(dto.getBusDriver()==null?null:busDriverConverter.copyProperties(new BusDriver(),dto.getBusDriver()));
//        model.setTourBus(dto.getTourBus()==null?null:tourBusConverter.copyProperties(new TourBus(),dto.getTourBus()));
//        model.setTravelAgentcy(dto.getTravelAgentcy()==null?null:travelAgencyConverter.copyProperties(new TravelAgentcy(),dto.getTravelAgentcy()));
//        model.setTourGuide(dto.getTourGuide()==null?null:tourGuideConverter.copyProperties(new TourGuide(),dto.getTourGuide()));
        return model;
    }

    @Override
    protected TeamReportDto getDto() {
        return new TeamReportDto();
    }
}
