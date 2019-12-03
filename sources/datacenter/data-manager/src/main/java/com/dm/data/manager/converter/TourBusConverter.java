package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TourBusDto;
import com.dm.data.manager.entity.TourBus;
import com.dm.data.manager.entity.TourBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TourBusConverter extends AbstractBaseConverter<TourBus, TourBusDto> {

    @Autowired
    private TourBusServiceConverter tourBusServiceConverter;

    @Override
    protected TourBusDto toDtoActual(TourBus model) {
        TourBusDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setRegionCode(model.getRegionCode());
        dto.setId(model.getId());
        dto.setPlateNo(model.getPlateNo());
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setLogo(model.getLogo());
        dto.setLevel(model.getLevel());
        dto.setBuses(tourBusServiceConverter.toDto(model.getBuses()));
        dto.setCarType(model.getCarType());
        dto.setRegistryDate(model.getRegistryDate());
        dto.setRepresentativeOwner(model.getRepresentativeOwner());
        dto.setContactPeople(model.getContactPeople());
        dto.setContact(model.getContact());
        dto.setContactAddress(model.getContactAddress());
        dto.setTransportationType(model.getTransportationType());
        dto.setEconomicType(model.getEconomicType());
        dto.setEstablishmentCode(model.getEstablishmentCode());
        dto.setTechnicalGrade(model.getTechnicalGrade());
        dto.setSafeDrivingMileage(model.getSafeDrivingMileage());
        dto.setTechnologyStartValidityPeriod(model.getTechnologyStartValidityPeriod());
        dto.setTechnologyEndValidityPeriod(model.getTechnologyEndValidityPeriod());
        dto.setSpeed(model.getSpeed());
        dto.setIntroduction(model.getIntroduction());
        dto.setConsultingPhoneNumber(model.getConsultingPhoneNumber());
        dto.setComplaintsPhoneNumber(model.getComplaintsPhoneNumber());
        dto.setOnlineComplaintsAddress(model.getOnlineComplaintsAddress());
        dto.setOnlineTicketable(model.getOnlineTicketable());
        dto.setTicketAddress(model.getTicketAddress());
        dto.setTicketPhoneNumber(model.getTicketPhoneNumber());
        dto.setSurroundingInformation(model.getSurroundingInformation());
        return dto;
    }

    @Override
    public TourBus copyProperties(TourBus model, TourBusDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());
        model.setPlateNo(dto.getPlateNo());
        model.setLongitude(dto.getLongitude());
        model.setLatitude(dto.getLatitude());
        model.setAddress(dto.getAddress());
        model.setLogo(dto.getLogo());
        model.setLevel(dto.getLevel());
        model.setCarType(dto.getCarType());
        model.setRegistryDate(dto.getRegistryDate());
        model.setRepresentativeOwner(dto.getRepresentativeOwner());
        model.setContactPeople(dto.getContactPeople());
        model.setContact(dto.getContact());
        model.setContactAddress(dto.getContactAddress());
        model.setTransportationType(dto.getTransportationType());
        model.setEconomicType(dto.getEconomicType());
        model.setEstablishmentCode(dto.getEstablishmentCode());
        model.setTechnicalGrade(dto.getTechnicalGrade());
        model.setSafeDrivingMileage(dto.getSafeDrivingMileage());
        model.setTechnologyStartValidityPeriod(dto.getTechnologyStartValidityPeriod());
        model.setTechnologyEndValidityPeriod(dto.getTechnologyEndValidityPeriod());
        model.setSpeed(dto.getSpeed());
        model.setIntroduction(dto.getIntroduction());
        model.setConsultingPhoneNumber(dto.getConsultingPhoneNumber());
        model.setComplaintsPhoneNumber(dto.getComplaintsPhoneNumber());
        model.setOnlineComplaintsAddress(dto.getOnlineComplaintsAddress());
        model.setOnlineTicketable(dto.getOnlineTicketable());
        model.setTicketAddress(dto.getTicketAddress());
        model.setTicketPhoneNumber(dto.getTicketPhoneNumber());
        model.setSurroundingInformation(dto.getSurroundingInformation());
        model.setBuses(dto.getBuses().stream().map(ele -> {
            return tourBusServiceConverter.copyProperties(new TourBusService(), ele);
        }).collect(Collectors.toList()));
        return model;
    }

    @Override
    protected TourBusDto getDto() {
        return new TourBusDto();
    }
}
