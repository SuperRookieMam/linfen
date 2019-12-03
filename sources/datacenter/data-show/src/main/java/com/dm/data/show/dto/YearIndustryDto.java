package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年旅游产业数量
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearIndustryDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 5476711083989123870L;
	/**
	 * 产业名称
	 * 吃、住、行、游、购、娱
	 */
	private String name;
}
