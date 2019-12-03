package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 每年关键词
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearKeywordDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -8538701612582239945L;

	/**
	 * 关键词
	 */
	private String name;
	
	/**
	 * 是否负面词汇
	 */
	private Boolean isBad;
}
