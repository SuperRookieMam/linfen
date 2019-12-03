package com.dm.linfen.emergency.service.impl;

import com.dm.linfen.emergency.entity.Plan;
import com.dm.linfen.emergency.entity.QPlan;
import com.dm.linfen.emergency.repository.PlanRepository;
import com.dm.linfen.emergency.service.PlanService;
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
 * @create 2019-07-25 15:36
 **/
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository repository;

    final static QPlan QPLAN = QPlan.plan;

    @Override
    public Optional<Plan> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Plan save(Plan plan) {
        return repository.save(plan);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Plan update(Plan plan) {
        return repository.saveAndFlush(plan);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Plan> findPlans(Plan plan, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.isNotBlank(plan.getName())) {
            builder.and(QPLAN.name.containsIgnoreCase(plan.getName()));
        }
        if (plan.getStatus() != null) {
            builder.and(QPLAN.status.eq(plan.getStatus()));
        }
        return repository.findAll(builder, pageable);
    }
}
