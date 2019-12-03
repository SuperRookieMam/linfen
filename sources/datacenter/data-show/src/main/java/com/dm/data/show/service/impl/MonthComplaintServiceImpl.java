package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthComplaintConverter;
import com.dm.data.show.dto.MonthComplaintDto;
import com.dm.data.show.entity.MonthComplaint;
import com.dm.data.show.entity.QMonthComplaint;
import com.dm.data.show.repository.MonthComplaintRepository;
import com.dm.data.show.service.MonthComplaintService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class MonthComplaintServiceImpl extends BaseIndexServiceImpl<MonthComplaint, MonthComplaintDto> implements MonthComplaintService {

	@Autowired
	private MonthComplaintRepository monthComplaintRepository;
	
	@Autowired
	private MonthComplaintConverter monthComplaintConverter;
	
	private final QMonthComplaint qMonthComplaint = QMonthComplaint.monthComplaint;
	
	@Override
	protected JpaRepository<MonthComplaint, Long> getRepository() {
		return monthComplaintRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<MonthComplaint> getQuerydsl() {
		return monthComplaintRepository;
	}

	@Override
	protected AbstractConverter<MonthComplaint, MonthComplaintDto> getConverter() {
		return monthComplaintConverter;
	}

	@Override
	protected MonthComplaint newModel() {
		return new MonthComplaint();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, MonthComplaintDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qMonthComplaint.year.eq(dto.getYear()));
		}
		if(dto.getMonth() != null) {
			booleanBuilder.and(qMonthComplaint.month.eq(dto.getMonth()));
		}
		return booleanBuilder;
	}


}
