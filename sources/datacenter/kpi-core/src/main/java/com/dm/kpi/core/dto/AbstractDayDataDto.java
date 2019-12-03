package com.dm.kpi.core.dto;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AbstractDayDataDto<T extends Number> extends AbstractBaseIndexDto<T> {
	private static final long serialVersionUID = 2868424799953880685L;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private ZonedDateTime currentDate;

}
