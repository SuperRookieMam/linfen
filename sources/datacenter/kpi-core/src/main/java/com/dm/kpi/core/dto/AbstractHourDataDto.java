package com.dm.kpi.core.dto;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AbstractHourDataDto<T extends Number> extends AbstractBaseIndexDto<T> {

	private static final long serialVersionUID = 2826619823375176983L;

	@JsonProperty
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private ZonedDateTime currentDate;

}
