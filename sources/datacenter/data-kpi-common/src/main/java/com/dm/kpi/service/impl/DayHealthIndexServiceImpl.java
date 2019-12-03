package com.dm.kpi.service.impl;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.converter.DayHealthIndexConverter;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.kpi.dto.DayHealthIndexDto;
import com.dm.kpi.entity.DayHealthIndex;
import com.dm.kpi.repository.DayHealthIndexRepository;
import com.dm.kpi.service.DayHealthIndexService;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @Author: 温东山
 * @Description: 类作用描述
 * @CreateDate: 2019/9/5 0005$ 16:19$
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/9/5 0005$ 16:19$
 * @history: 修改记录
 * @Version: 1.0
 */
@Service
public class DayHealthIndexServiceImpl extends BaseIndexServiceImpl<DayHealthIndex, DayHealthIndexDto> implements DayHealthIndexService {
    
	@Autowired
    private DayHealthIndexRepository healthIndexRepository;
	
	@Autowired
	private DayHealthIndexConverter dayHealthIndexConverter;
    
	@Override
	protected JpaRepository<DayHealthIndex, Long> getRepository() {
		return healthIndexRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<DayHealthIndex> getQuerydsl() {
		return healthIndexRepository;
	}

	@Override
	protected AbstractConverter<DayHealthIndex, DayHealthIndexDto> getConverter() {
		return dayHealthIndexConverter;
	}

	@Override
	protected DayHealthIndex newModel() {
		return new DayHealthIndex();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, DayHealthIndexDto dto) {
		return null;
	}
	
	@Override
    public DayHealthIndex findByCurrentDateAndDistrictId(LocalDate localDate, String districtId) {
        return healthIndexRepository.findByCurrentDateAndDistrictId(localDate,districtId);
    }

	@Override
	public DayHealthIndex save(DayHealthIndex model) {
		return healthIndexRepository.save(model);
	}
}
