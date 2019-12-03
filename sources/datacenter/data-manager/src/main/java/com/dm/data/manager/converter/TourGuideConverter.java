package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TourGuideDto;
import com.dm.data.manager.entity.TourGuide;
import com.dm.file.converter.FileInfoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TourGuideConverter extends AbstractBaseConverter<TourGuide, TourGuideDto> {
    @Autowired
    private FileInfoConverter fileInfoConverter;

    @Override
    protected TourGuideDto toDtoActual(TourGuide model) {
        TourGuideDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setNowTeam(model.getNowTeam());
        dto.setChineseName(model.getChineseName());
        dto.setPinyin(model.getPinyin());
        dto.setGender(model.getGender());
        dto.setDateOfBirth(model.getDateOfBirth());
        dto.setIdNumber(model.getIdNumber());
        dto.setRecordOfFormalSchooling(model.getRecordOfFormalSchooling());
        dto.setNational(model.getNational());
        dto.setContact(model.getContact());
        dto.setHomeAddress(model.getHomeAddress());
        dto.setProfilePicture(model.getProfilePicture());
        dto.setTheGuideType(model.getTheGuideType());
        dto.setTheGuideRanks(model.getTheGuideRanks());
        dto.setServiceLanguage(model.getServiceLanguage());
        dto.setRegionCode(model.getRegionCode());
        dto.setIntroductionTourGuide(model.getIntroductionTourGuide());
        dto.setLegallyNumber(model.getLegallyNumber());
        dto.setTurnedTheReleaseDate(model.getTurnedTheReleaseDate());
        dto.setQualificationCardNumber(model.getQualificationCardNumber());
        dto.setCertificateIssuanceDate(model.getCertificateIssuanceDate());
        dto.setLicense(model.getLicense());
        dto.setTheTourGuideIcCardNumber(model.getTheTourGuideIcCardNumber());
        dto.setTheTourGuideCardNumber(model.getTheTourGuideCardNumber());
        dto.setAttachedUnits(model.getAttachedUnits());
        dto.setTheAffiliatedUnitType(model.getTheAffiliatedUnitType());
        dto.setTotalValue(model.getTotalValue());
        dto.setDeductionScore(model.getDeductionScore());
        dto.setGoodAtInterpretationOfTheCity(model.getGoodAtInterpretationOfTheCity());
        dto.setGoodAtInterpretationOfTheScenicSpot(model.getGoodAtInterpretationOfTheScenicSpot());
        dto.setGoodAtLineOfTour(model.getGoodAtLineOfTour());
        dto.setWorkingCondition(model.getWorkingCondition());
        dto.setHeadImgs(fileInfoConverter.toDto(model.getHeadImgs()));
        return dto;
    }

    @Override
    public TourGuide copyProperties(TourGuide model, TourGuideDto dto) {
        model = super.copyProperties(model, dto);
        model.setChineseName(dto.getChineseName());
        model.setPinyin(dto.getPinyin());
        model.setGender(dto.getGender());
        model.setDateOfBirth(dto.getDateOfBirth());
        model.setIdNumber(dto.getIdNumber());
        model.setRecordOfFormalSchooling(dto.getRecordOfFormalSchooling());
        model.setNational(dto.getNational());
        model.setContact(dto.getContact());
        model.setHomeAddress(dto.getHomeAddress());
        model.setProfilePicture(dto.getProfilePicture());
        model.setTheGuideType(dto.getTheGuideType());
        model.setTheGuideRanks(dto.getTheGuideRanks());
        model.setServiceLanguage(dto.getServiceLanguage());
        // model.setArea(dto.getArea());
        model.setRegionCode(dto.getRegionCode());
        model.setIntroductionTourGuide(dto.getIntroductionTourGuide());
        model.setLegallyNumber(dto.getLegallyNumber());
        model.setTurnedTheReleaseDate(dto.getTurnedTheReleaseDate());
        model.setQualificationCardNumber(dto.getQualificationCardNumber());
        model.setCertificateIssuanceDate(dto.getCertificateIssuanceDate());
        model.setLicense(dto.getLicense());
        model.setTheTourGuideIcCardNumber(dto.getTheTourGuideIcCardNumber());
        model.setTheTourGuideCardNumber(dto.getTheTourGuideCardNumber());
        model.setAttachedUnits(dto.getAttachedUnits());
        model.setTheAffiliatedUnitType(dto.getTheAffiliatedUnitType());
        model.setTotalValue(dto.getTotalValue());
        model.setDeductionScore(dto.getDeductionScore());
        model.setGoodAtInterpretationOfTheCity(dto.getGoodAtInterpretationOfTheCity());
        model.setGoodAtInterpretationOfTheScenicSpot(dto.getGoodAtInterpretationOfTheScenicSpot());
        model.setGoodAtLineOfTour(dto.getGoodAtLineOfTour());
        model.setWorkingCondition(dto.getWorkingCondition());
        model.setNowTeam(dto.getNowTeam());
        return model;
    }

    @Override
    protected TourGuideDto getDto() {
        return new TourGuideDto();
    }
}
