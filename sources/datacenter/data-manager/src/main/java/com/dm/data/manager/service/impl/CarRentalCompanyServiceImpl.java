package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.CarRentalCompanyConverter;
import com.dm.data.manager.dto.CarRentalCompanyDto;
import com.dm.data.manager.entity.CarRentalCompany;
import com.dm.data.manager.entity.QCarRentalCompany;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.CarRentalCompanyRepository;
import com.dm.data.manager.service.CarRentalCompanyService;
import com.dm.data.manager.service.MediaService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarRentalCompanyServiceImpl extends AbstractCurrencyServiceImpl<CarRentalCompany>
        implements CarRentalCompanyService {

    @Autowired
    private CarRentalCompanyRepository carRentalRepository;

    @Autowired
    private CarRentalCompanyConverter carRentalConverter;

    @Autowired
    private MediaService mediaService;

    private final QCarRentalCompany qCarRental = QCarRentalCompany.carRentalCompany;

    @Override
    public Optional<CarRentalCompany> findById(Long id) {
        return carRentalRepository.findById(id);
    }

    @Override
    @Transactional
    public CarRentalCompany save(CarRentalCompanyDto data) {
        CarRentalCompany entity = new CarRentalCompany();
        carRentalConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.汽车租赁公司);

        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return carRentalRepository.save(entity);
    }

    @Override
    @Transactional
    public CarRentalCompany update(Long id, CarRentalCompanyDto data) {
        CarRentalCompany entity = carRentalRepository.getOne(id);
        carRentalConverter.copyProperties(entity, data);

        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carRentalRepository.deleteById(id);
    }

    @Override
    public Page<CarRentalCompany> find(Pageable pageable) {
        return carRentalRepository.findAll(pageable);
    }

    @Override
    public Page<CarRentalCompany> find(CarRentalCompanyDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
// 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qCarRental.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qCarRental.chineseName.containsIgnoreCase(fullName))
                    .or(qCarRental.address.containsIgnoreCase(fullName))
                    .or(qCarRental.brand.containsIgnoreCase(fullName))
                    .or(qCarRental.models.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qCarRental.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return carRentalRepository.findAll(builder, pageable);
    }

}
