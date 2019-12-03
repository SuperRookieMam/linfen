package com.dm.linfen.emergency.service.impl;

import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.QReport;
import com.dm.linfen.emergency.entity.Report;
import com.dm.linfen.emergency.repository.ReportRepository;
import com.dm.linfen.emergency.service.ReportService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author 温东山
 * @create 2019-07-25 14:01
 **/
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    final static QReport QREPORT = QReport.report;

    @Override
    public Optional<Report> findById(Long id) {
        return reportRepository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Report update(Report report) {
        if (report == null || report.getId() == null) {
            throw new DataValidateException("保存数据不能为null!");
        }
        if (!reportRepository.findById(report.getId()).isPresent()) {
            throw new DataValidateException("数据不存在!");
        }
        return reportRepository.saveAndFlush(report);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public Page<Report> findReports(Report report, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.isNotBlank(report.getTitle())) {
            builder.and(QREPORT.title.containsIgnoreCase(report.getTitle()));
        }
        if (report.getStatus() != null) {
            builder.and(QREPORT.status.eq(report.getStatus()));
        }
        return reportRepository.findAll(builder, pageable);
    }
}
