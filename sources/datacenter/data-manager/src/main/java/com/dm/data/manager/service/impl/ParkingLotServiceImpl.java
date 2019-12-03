package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.ParkingLotConverter;
import com.dm.data.manager.dto.ParkingLotDto;
import com.dm.data.manager.entity.ParkingLot;
import com.dm.data.manager.entity.QParkingLot;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.ParkingLotRepository;
import com.dm.data.manager.service.MediaService;
import com.dm.data.manager.service.ParkingLotService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ParkingLotServiceImpl extends AbstractCurrencyServiceImpl<ParkingLot> implements ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ParkingLotConverter parkingLotConverter;

    private QParkingLot qParkingLot = QParkingLot.parkingLot;

    @Override
    public Optional<ParkingLot> findById(Long id) {
        return parkingLotRepository.findById(id);
    }

    @Autowired
    private MediaService mediaService;

    @Override
    @Transactional
    public ParkingLot save(ParkingLotDto data) {
        ParkingLot entity = new ParkingLot();
        parkingLotConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.停车场);

        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return parkingLotRepository.save(entity);
    }

    @Override
    @Transactional
    public ParkingLot update(Long id, ParkingLotDto data) {
        ParkingLot entity = parkingLotRepository.getOne(id);

        parkingLotConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        parkingLotRepository.deleteById(id);
    }

    @Override
    public Page<ParkingLot> find(Pageable pageable) {
        return parkingLotRepository.findAll(pageable);
    }

    @Override
    public Page<ParkingLot> find(ParkingLotDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qParkingLot.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }

        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qParkingLot.chineseFullName.containsIgnoreCase(fullName))
                    .or(qParkingLot.address.containsIgnoreCase(fullName))
                    .or(qParkingLot.chargeStandard.containsIgnoreCase(fullName))
                    .or(qParkingLot.businessHours.containsIgnoreCase(fullName));
        }

        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qParkingLot.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return parkingLotRepository.findAll(builder, pageable);
    }
}
