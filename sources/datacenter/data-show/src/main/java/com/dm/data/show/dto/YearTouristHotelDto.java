package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客住宿天数
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristHotelDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 8136778977360361679L;
	/**
	 * 住宿天数类型
	 */
	private String name;
}
