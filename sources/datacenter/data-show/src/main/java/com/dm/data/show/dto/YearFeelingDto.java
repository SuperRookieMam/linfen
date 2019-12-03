package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年情感分布
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearFeelingDto extends AbstractYearDataDto<Float> {

	private static final long serialVersionUID = 3495795142834270393L;

}
