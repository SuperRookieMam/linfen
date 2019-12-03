package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.HotelTimePersonConverter;
import com.dm.data.manager.dto.HotelTimePersonDto;
import com.dm.data.manager.entity.HotelTimePerson;
import com.dm.data.manager.entity.QHotelTimePerson;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.HotelTimePersonRepository;
import com.dm.data.manager.service.HotelTimePersonService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HotelTimePersonServiceImpl extends AbstractCurrencyServiceImpl<HotelTimePerson>
        implements HotelTimePersonService {

    @Autowired
    private HotelTimePersonRepository hotelTimePersonRepository;

    @Autowired
    private HotelTimePersonConverter hotelTimePersonConverter;

    private QHotelTimePerson qHotelTimePerson = QHotelTimePerson.hotelTimePerson;

    @Override
    public Optional<HotelTimePerson> findById(Long id) {
        return hotelTimePersonRepository.findById(id);
    }

    @Override
    @Transactional
    public HotelTimePerson save(HotelTimePersonDto data) {
        HotelTimePerson entity = new HotelTimePerson();
        hotelTimePersonConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return hotelTimePersonRepository.save(entity);
    }

    @Override
    @Transactional
    public HotelTimePerson update(Long id, HotelTimePersonDto data) {
        HotelTimePerson entity = hotelTimePersonRepository.getOne(id);
        hotelTimePersonConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        hotelTimePersonRepository.deleteById(id);
    }

    @Override
    public Page<HotelTimePerson> find(HotelTimePersonDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qHotelTimePerson.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getArea();
        if (StringUtils.isNotBlank(fullName)) {
            if (fullName.matches("\\d{4}-\\d+-\\d+")) {
                String[] time = fullName.split("-");
                builder.and(qHotelTimePerson.year.eq(Integer.valueOf(time[0])))
                        .and(qHotelTimePerson.month.eq(Integer.valueOf(time[1])))
                        .and(qHotelTimePerson.day.eq(Integer.valueOf(time[2])));
            } else {
                builder.and(qHotelTimePerson.houre.like(fullName))
                        .or(qHotelTimePerson.scenic.containsIgnoreCase(fullName))
                        .or(qHotelTimePerson.hotelName.like(fullName))
                        .or(qHotelTimePerson.sex.containsIgnoreCase(fullName))
                        .or(qHotelTimePerson.number.like(fullName));
            }
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qHotelTimePerson.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return hotelTimePersonRepository.findAll(builder, pageable);
    }
}
