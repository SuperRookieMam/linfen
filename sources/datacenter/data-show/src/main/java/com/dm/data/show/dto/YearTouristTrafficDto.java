package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客交通工具
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristTrafficDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -1155237070550525988L;
	/**
	 * 交通工具名称
	 */
	private String name;
}
