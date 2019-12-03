package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TeamReportConverter;
import com.dm.data.manager.dto.TeamReportDto;
import com.dm.data.manager.entity.QTeamReport;
import com.dm.data.manager.entity.TeamReport;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TeamReportRepository;
import com.dm.data.manager.service.TeamReportService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamReportServiceImpl extends AbstractCurrencyServiceImpl<TeamReport> implements TeamReportService {

    @Autowired
    private TeamReportRepository teamReportRepository;

    @Autowired
    private TeamReportConverter teamReportConverter;

    private final QTeamReport qTeamReport = QTeamReport.teamReport;

    @Override
    public Optional<TeamReport> findById(Long id) {
        return teamReportRepository.findById(id);
    }

    @Override
    @Transactional
    public TeamReport save(TeamReportDto data) {
        TeamReport entity = new TeamReport();
        teamReportConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.团队填报);
        return teamReportRepository.save(entity);
    }

    @Override
    @Transactional
    public TeamReport update(Long id, TeamReportDto data) {
        TeamReport entity = teamReportRepository.getOne(id);
        teamReportConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        teamReportRepository.deleteById(id);
    }

    @Override
    public Page<TeamReport> find(Pageable pageable) {
        return teamReportRepository.findAll(pageable);
    }

    @Override
    public Page<TeamReport> find(TeamReportDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTeamReport.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getTeamName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTeamReport.teamName.containsIgnoreCase(fullName))
                    .or(qTeamReport.state.eq(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTeamReport.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return teamReportRepository.findAll(builder, pageable);
    }

    @Override
    public List<TeamReport> findBySearch(String search) {
        return teamReportRepository.findByTeamNameContains(search);
    }
}
