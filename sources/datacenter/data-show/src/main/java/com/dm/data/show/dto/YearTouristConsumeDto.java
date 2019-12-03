package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客消费分析
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristConsumeDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 7523788471989990840L;
	/**
	 * 消费类型
	 * 2000以下、2000-3000、3000-4000、4000-5000、5000-6000、6000以上
	 */
	private String name;
}
