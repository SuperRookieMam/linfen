package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客浏览景区数量
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristScenicDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 3168857810900022872L;
	/**
	 * 数量类型
	 * 1个景区、2个景区、3个景区以上
	 */
	private String name;
}
