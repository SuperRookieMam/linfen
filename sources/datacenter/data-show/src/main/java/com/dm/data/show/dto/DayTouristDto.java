package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每日游客数量
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DayTouristDto extends AbstractDayDataDto<Long>{
	
	private static final long serialVersionUID = 1027872065648739073L;

}
