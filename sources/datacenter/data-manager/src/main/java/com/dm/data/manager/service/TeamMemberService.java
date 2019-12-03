package com.dm.data.manager.service;

import com.dm.data.manager.dto.TeamMemberDto;
import com.dm.data.manager.entity.TeamMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TeamMemberService extends ApiService<TeamMember> {
    Optional<TeamMember> findById(Long id);

    TeamMember save(TeamMemberDto data);

    TeamMember update(Long id, TeamMemberDto data);

    void delete(Long id);

    Page<TeamMember> find(Pageable pageable);

    Page<TeamMember> find(TeamMemberDto condition, String regionCode, Pageable pageable);
}
