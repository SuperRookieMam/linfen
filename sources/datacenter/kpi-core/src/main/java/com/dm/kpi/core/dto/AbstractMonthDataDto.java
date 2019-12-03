package com.dm.kpi.core.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractMonthDataDto<T extends Number> extends AbstractBaseIndexDto<T> {
	private static final long serialVersionUID = 4610750648872872548L;

	private Integer year;

	@Max(12)
	@Min(1)
	private Integer month;

}
