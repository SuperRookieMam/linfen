package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TeamMemberConverter;
import com.dm.data.manager.dto.TeamMemberDto;
import com.dm.data.manager.entity.QTeamMember;
import com.dm.data.manager.entity.TeamMember;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TeamMemberRepository;
import com.dm.data.manager.service.TeamMemberService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeamMemberServiceImpl extends AbstractCurrencyServiceImpl<TeamMember> implements TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private TeamMemberConverter teamMemberConverter;

    private final QTeamMember qTeamMember = QTeamMember.teamMember;

    @Override
    public Optional<TeamMember> findById(Long id) {
        return teamMemberRepository.findById(id);
    }

    @Override
    @Transactional
    public TeamMember save(TeamMemberDto data) {
        TeamMember entity = new TeamMember();
        teamMemberConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.团队成员);
        return teamMemberRepository.save(entity);
    }

    @Override
    @Transactional
    public TeamMember update(Long id, TeamMemberDto data) {
        TeamMember entity = teamMemberRepository.getOne(id);
        teamMemberConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        teamMemberRepository.deleteById(id);
    }

    @Override
    public Page<TeamMember> find(Pageable pageable) {
        return teamMemberRepository.findAll(pageable);
    }

    @Override
    public Page<TeamMember> find(TeamMemberDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTeamMember.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getMemberName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTeamMember.memberName.containsIgnoreCase(fullName))
                    .or(qTeamMember.mobile.containsIgnoreCase(fullName))
                    .or(qTeamMember.carNumber.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTeamMember.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return teamMemberRepository.findAll(builder, pageable);
    }
}
