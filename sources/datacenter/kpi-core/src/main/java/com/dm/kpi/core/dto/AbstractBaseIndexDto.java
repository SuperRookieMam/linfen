package com.dm.kpi.core.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.dm.common.entity.Audit;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public abstract class AbstractBaseIndexDto<V extends Number> implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private Long id;

	@JsonProperty(access = Access.READ_ONLY)
	private ZonedDateTime createTime;

	@JsonProperty(access = Access.READ_ONLY)
	private ZonedDateTime updateTime;

	@JsonProperty
	private String regionName;

	@JsonProperty
	private String regionCode;

	@JsonProperty
	private V value;

	@JsonProperty(access = Access.READ_ONLY)
	private Audit createBy;

	@JsonProperty(access = Access.READ_ONLY)
	private Audit lastModifiedBy;
}
