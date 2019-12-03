package com.dm.kpi.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractYearDataDto<V extends Number> extends AbstractBaseIndexDto<V> {
	private static final long serialVersionUID = 1L;
	private Integer year;

}
