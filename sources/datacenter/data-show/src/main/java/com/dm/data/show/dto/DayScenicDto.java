package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每日景区人数统计
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DayScenicDto extends AbstractDayDataDto<Long> {
	
	private static final long serialVersionUID = -3378141839508129025L;
	/**
	 * 景区名称
	 */
	private String name;
}
