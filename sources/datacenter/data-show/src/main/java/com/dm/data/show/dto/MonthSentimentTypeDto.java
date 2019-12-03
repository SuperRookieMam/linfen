package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractMonthDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每月舆情数量
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonthSentimentTypeDto extends AbstractMonthDataDto<Long> {

	private static final long serialVersionUID = -4215330094173960180L;
	/**
	 * 舆情类型
	 * 敏感、非敏感
	 */
	private String name;
}
