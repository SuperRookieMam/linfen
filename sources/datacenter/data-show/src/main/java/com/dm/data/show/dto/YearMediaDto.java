package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年媒体来源数量
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearMediaDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -2627702048252388922L;
	/**
	 * 媒体类型
	 * 微博、外媒、新闻等
	 */
	private String name;
}
