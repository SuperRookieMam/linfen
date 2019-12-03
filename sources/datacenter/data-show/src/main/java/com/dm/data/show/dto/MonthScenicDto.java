package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractMonthDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每月景区人数统计
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonthScenicDto extends AbstractMonthDataDto<Long> {

	private static final long serialVersionUID = 1490101268171848092L;
	/**
	 * 景区名称
	 */
	private String name;
}
