package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractHourDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每小时景区停车位
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HourScenicParkingDto extends AbstractHourDataDto<Long> {

	private static final long serialVersionUID = -424471780447265101L;
	/**
	 * 景区名称
	 */
	private String name;
}
