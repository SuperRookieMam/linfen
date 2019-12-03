package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年景区人数统计
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearScenicDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -6090727915008207458L;
	/**
	 * 景区名称
	 */
	private String name;
	
	private Integer startYear;
	
	private Integer endYear;
}
