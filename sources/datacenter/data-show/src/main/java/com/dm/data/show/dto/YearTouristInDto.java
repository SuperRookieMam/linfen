package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年国外游客人数
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristInDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -6135498032000960520L;
	/**
	 * 国家名称
	 */
	private String name;
}
