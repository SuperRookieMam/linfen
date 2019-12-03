package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客投诉
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearComplaintDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -8698868223199762753L;
	/**
	 * 投诉类型
	 */
	private String name;
}
