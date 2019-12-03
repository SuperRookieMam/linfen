package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年团队性别及年龄
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTeamGenderAgeDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 5866619604431709867L;

	/**
	 * 性别
	 */
	private String gender;
	
	/**
	 * 年龄类别
	 */
	private String age;
}
