package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年各省旅游人数
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearRegionDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -7766105523287234389L;
	/**
	 * 省份名称
	 */
	private String name;
}
