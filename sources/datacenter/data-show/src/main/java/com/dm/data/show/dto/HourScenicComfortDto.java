package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractHourDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每天景区舒适度
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HourScenicComfortDto extends AbstractHourDataDto<Float> {

	private static final long serialVersionUID = 8005144861241776219L;
	/**
	 * 景区名称
	 */
	private String name;
}
