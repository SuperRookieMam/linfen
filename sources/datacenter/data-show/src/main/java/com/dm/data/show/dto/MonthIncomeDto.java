package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractMonthDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每月旅游收入
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonthIncomeDto extends AbstractMonthDataDto<Float> {
	
	private static final long serialVersionUID = 8769020643847252349L;

}
