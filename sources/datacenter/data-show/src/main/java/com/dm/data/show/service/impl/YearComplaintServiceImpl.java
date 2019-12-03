package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearComplaintConverter;
import com.dm.data.show.dto.YearComplaintDto;
import com.dm.data.show.entity.QYearComplaint;
import com.dm.data.show.entity.YearComplaint;
import com.dm.data.show.repository.YearComplaintRepository;
import com.dm.data.show.service.YearComplaintService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearComplaintServiceImpl extends BaseIndexServiceImpl<YearComplaint, YearComplaintDto> implements YearComplaintService {

	@Autowired
	private YearComplaintRepository yearComplaintRepository;

	@Autowired
	private YearComplaintConverter yearComplaintConverter;
	
	private final QYearComplaint qYearComplaint = QYearComplaint.yearComplaint;

	@Override
	protected JpaRepository<YearComplaint, Long> getRepository() {
		return yearComplaintRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearComplaint> getQuerydsl() {
		return yearComplaintRepository;
	}

	@Override
	protected AbstractConverter<YearComplaint, YearComplaintDto> getConverter() {
		return yearComplaintConverter;
	}

	@Override
	protected YearComplaint newModel() {
		return new YearComplaint();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearComplaintDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearComplaint.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
