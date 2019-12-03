package com.dm.data.show.dto;

import com.dm.kpi.core.dto.AbstractMonthDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每月游客投诉
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonthComplaintDto extends AbstractMonthDataDto<Long> {

	private static final long serialVersionUID = 3545792502847034368L;
	/**
	 * 投诉类型
	 */
	private String name;
}
