package com.dm.data.manager.service;

import com.dm.data.manager.dto.TeamReportDto;
import com.dm.data.manager.entity.TeamReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TeamReportService extends ApiService<TeamReport> {

    Optional<TeamReport> findById(Long id);

    TeamReport save(TeamReportDto data);

    TeamReport update(Long id, TeamReportDto data);

    void delete(Long id);

    Page<TeamReport> find(Pageable pageable);

    Page<TeamReport> find(TeamReportDto condition, String regionCode, Pageable pageable);

    List<TeamReport> findBySearch(String search);
}
