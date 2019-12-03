package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractHourDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每小时景区人数
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HourScenicDto extends AbstractHourDataDto<Long> {

	private static final long serialVersionUID = 6137112737830959677L;
	/**
	 * 景区名称
	 */
	private String name;
}
