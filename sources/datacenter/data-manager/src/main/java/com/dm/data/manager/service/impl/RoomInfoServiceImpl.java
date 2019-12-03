package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.RoomInfoConverter;
import com.dm.data.manager.dto.RoomInfoDto;
import com.dm.data.manager.entity.QRoomInfo;
import com.dm.data.manager.entity.RoomInfo;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.RoomInfoRepository;
import com.dm.data.manager.service.RoomInfoService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoomInfoServiceImpl extends AbstractCurrencyServiceImpl<RoomInfo> implements RoomInfoService {

    @Autowired
    private RoomInfoRepository RoomInfoRepository;

    @Autowired
    private RoomInfoConverter RoomInfoConverter;

    private final QRoomInfo qRoomInfo = QRoomInfo.roomInfo;

    @Override
    public Optional<RoomInfo> findById(Long id) {
        return RoomInfoRepository.findById(id);
    }

    @Override
    @Transactional
    public RoomInfo save(RoomInfoDto data) {
        RoomInfo entity = new RoomInfo();
        RoomInfoConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.酒店房间);
        return RoomInfoRepository.save(entity);
    }

    @Override
    @Transactional
    public RoomInfo update(Long id, RoomInfoDto data) {
        RoomInfo entity = RoomInfoRepository.getOne(id);
        RoomInfoConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        RoomInfoRepository.deleteById(id);
    }

    @Override
    public Page<RoomInfo> find(Pageable pageable) {
        return RoomInfoRepository.findAll(pageable);
    }

    @Override
    public Page<RoomInfo> find(RoomInfoDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qRoomInfo.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getEatDescription();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qRoomInfo.roomType.containsIgnoreCase(fullName)).or(qRoomInfo.extraBedPrice.like(fullName))
                    .or(qRoomInfo.holidayPrices.like(fullName)).or(qRoomInfo.normalPrice.like(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qRoomInfo.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return RoomInfoRepository.findAll(builder, pageable);
    }
}
