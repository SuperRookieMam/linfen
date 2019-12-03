package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客性别
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristGenderDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -4306101302609181466L;
	/**
	 * 性别名称
	 * 男、女、未知
	 */
	private String name;
}
