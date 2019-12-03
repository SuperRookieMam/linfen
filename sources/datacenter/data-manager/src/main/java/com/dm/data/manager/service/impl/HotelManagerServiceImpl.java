package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.HotelManagerConverter;
import com.dm.data.manager.dto.HotelManagerDto;
import com.dm.data.manager.entity.HotelManager;
import com.dm.data.manager.entity.QHotelManager;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.HotelManagerRepository;
import com.dm.data.manager.service.HotelManagerService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class HotelManagerServiceImpl extends AbstractCurrencyServiceImpl<HotelManager> implements HotelManagerService {

    @Autowired
    private HotelManagerRepository hotelManagerRepository;

    @Autowired
    private HotelManagerConverter hotelManagerConverter;

    private QHotelManager qHotelManager = QHotelManager.hotelManager;

    @Override
    public Optional<HotelManager> findById(Long id) {
        return hotelManagerRepository.findById(id);
    }

    @Override
    @Transactional
    public HotelManager save(HotelManagerDto data) {
        HotelManager entity = new HotelManager();
        hotelManagerConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return hotelManagerRepository.save(entity);
    }

    @Override
    @Transactional
    public HotelManager update(Long id, HotelManagerDto data) {
        HotelManager entity = hotelManagerRepository.getOne(id);
        hotelManagerConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        hotelManagerRepository.deleteById(id);
    }

    @Override
    public Page<HotelManager> find(HotelManagerDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
//		if (StringUtils.isNotEmpty(regionCode)) {
//			builder.and(qHotelManager.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
//		}
        String fullName = condition.getHotelName();
        if (StringUtils.isNotBlank(fullName)) {
            if (fullName.matches("\\d{4}-\\d{2}-\\d{2}")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime localDateTime = LocalDateTime.of(LocalDate.parse(fullName, formatter), LocalTime.MIN);
                ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDate.parse(fullName, formatter), LocalTime.MIN, ZoneId.of("Asia/Shanghai"));
                builder.and(qHotelManager.createDate.eq(zonedDateTime));
            } else {
                builder.and(qHotelManager.hotelName.containsIgnoreCase(fullName))
                        .or(qHotelManager.price.like(fullName))
                        .or(qHotelManager.score.like(fullName));
            }
        }
        // 这段代码过滤查询区域
//		String areas = condition.getRegionCode();
//		if (StringUtils.isNotEmpty(areas)) {
//			builder.and(qHotelManager.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
//		}
        return hotelManagerRepository.findAll(builder, pageable);
    }

}
