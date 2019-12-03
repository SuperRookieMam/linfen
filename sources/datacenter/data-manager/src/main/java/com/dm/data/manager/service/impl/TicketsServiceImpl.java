package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TicketsConverter;
import com.dm.data.manager.dto.TicketsDto;
import com.dm.data.manager.entity.QTickets;
import com.dm.data.manager.entity.Tickets;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TicketsRepository;
import com.dm.data.manager.service.TicketsService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TicketsServiceImpl extends AbstractCurrencyServiceImpl<Tickets> implements TicketsService {

    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private TicketsConverter ticketsConverter;

    private QTickets qTickets = QTickets.tickets;

    @Override
    public Optional<Tickets> findById(Long id) {
        return ticketsRepository.findById(id);
    }

    @Override
    @Transactional
    public Tickets save(TicketsDto data) {
        Tickets entity = new Tickets();
        ticketsConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return ticketsRepository.save(entity);
    }

    @Override
    @Transactional
    public Tickets update(Long id, TicketsDto data) {
        Tickets entity = ticketsRepository.getOne(id);
        ticketsConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ticketsRepository.deleteById(id);
    }

    @Override
    public Page<Tickets> find(TicketsDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
//		if (StringUtils.isNotEmpty(regionCode)) {
//			builder.and(qTickets.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
//		}
        String fullName = condition.getScenic();
        if (StringUtils.isNotBlank(fullName)) {
            if (fullName.matches("\\d{4}-\\d{2}-\\d{2}")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime localDateTime = LocalDateTime.of(LocalDate.parse(fullName, formatter), LocalTime.MIN);
                builder.and(qTickets.createDate.eq(ZonedDateTime.of(LocalDate.parse(fullName, formatter), LocalTime.MIN, ZoneId.of("Asia/Shanghai"))));
            } else {
                builder.and(qTickets.scenic.containsIgnoreCase(fullName))
                        .or(qTickets.price.like(fullName))
                        .or(qTickets.score.like(fullName));
            }
        }
//		// 这段代码过滤查询区域
//		String areas = condition.getRegionCode();
//		if (StringUtils.isNotEmpty(areas)) {
//			builder.and(qTickets.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
//		}
        return ticketsRepository.findAll(builder, pageable);
    }

    @Override
    public List<Tickets> findBySearch(String search) {
        return null;
    }
}
