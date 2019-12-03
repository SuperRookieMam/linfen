package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractMonthDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每月国内/入境游客住宿
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonthTourisHotelLocalInDto extends AbstractMonthDataDto<Long> {

	private static final long serialVersionUID = -7908831094410585700L;
	/**
	 * 游客类型
	 * 入境游客、国内游客
	 */
	private String name;
}
