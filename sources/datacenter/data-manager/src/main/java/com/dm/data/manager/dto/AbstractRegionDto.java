package com.dm.data.manager.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.dm.common.entity.Audit;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Data
public abstract class AbstractRegionDto implements Serializable {
    private static final long serialVersionUID = -5731457797851150256L;

    @JsonProperty(access = Access.READ_ONLY)
    private ZonedDateTime createDate;

    @JsonProperty(access = Access.READ_ONLY)
    private ZonedDateTime lastModifiedDate;

    @JsonProperty(access = Access.READ_ONLY)
    private Audit createdBy;

    @JsonProperty(access = Access.READ_ONLY)
    private Audit lastModifiedBy;

    /**
     * 区划代码
     */
    private String regionCode;
}
