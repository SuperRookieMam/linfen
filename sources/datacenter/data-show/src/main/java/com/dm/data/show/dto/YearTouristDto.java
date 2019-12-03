package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年累计接待游客人数
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristDto extends AbstractYearDataDto<Long>{

	private static final long serialVersionUID = -1253608455853579246L;

}
