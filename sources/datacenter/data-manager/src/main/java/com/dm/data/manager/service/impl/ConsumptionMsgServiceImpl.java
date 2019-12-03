package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.ConsumptionMsgConverter;
import com.dm.data.manager.dto.ConsumptionMsgDto;
import com.dm.data.manager.entity.ConsumptionMsg;
import com.dm.data.manager.entity.QConsumptionMsg;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.ConsumptionMsgRepository;
import com.dm.data.manager.service.ConsumptionMsgService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConsumptionMsgServiceImpl extends AbstractCurrencyServiceImpl<ConsumptionMsg>
        implements ConsumptionMsgService {

    @Autowired
    private ConsumptionMsgRepository consumptionMsgRepository;

    @Autowired
    private ConsumptionMsgConverter consumptionMsgConverter;

    private QConsumptionMsg qConsumptionMsg = QConsumptionMsg.consumptionMsg;

    @Override
    public Optional<ConsumptionMsg> findById(Long id) {
        return consumptionMsgRepository.findById(id);
    }

    @Override
    @Transactional
    public ConsumptionMsg save(ConsumptionMsgDto data) {
        ConsumptionMsg entity = new ConsumptionMsg();
        consumptionMsgConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return consumptionMsgRepository.save(entity);
    }

    @Override
    @Transactional
    public ConsumptionMsg update(Long id, ConsumptionMsgDto data) {
        ConsumptionMsg entity = consumptionMsgRepository.getOne(id);
        consumptionMsgConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        consumptionMsgRepository.deleteById(id);
    }

    @Override
    public Page<ConsumptionMsg> find(ConsumptionMsgDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qConsumptionMsg.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getBusiness();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qConsumptionMsg.business.containsIgnoreCase(fullName))
                    .or(qConsumptionMsg.money.containsIgnoreCase(fullName))
                    .or(qConsumptionMsg.type.containsIgnoreCase(fullName))
                    .or(qConsumptionMsg.mobile.containsIgnoreCase(fullName));
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qConsumptionMsg.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return consumptionMsgRepository.findAll(builder, pageable);
    }

}
