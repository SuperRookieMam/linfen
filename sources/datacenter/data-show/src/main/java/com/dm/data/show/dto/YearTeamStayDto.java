package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年团队停留时长
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTeamStayDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 6244980484146099803L;
	/**
	 * 停留类型
	 */
	private String name;
}
