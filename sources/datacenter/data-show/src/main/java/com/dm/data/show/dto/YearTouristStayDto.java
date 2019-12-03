package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客停留时长
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristStayDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -2277618913353449704L;
	/**
	 * 停留类型
	 */
	private String name;
}
