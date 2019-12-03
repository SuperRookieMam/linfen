package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客认知图谱
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearCognitionAtlasDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 5455691104693440004L;
	/**
	 * 图谱名称
	 */
	private String name;
}
