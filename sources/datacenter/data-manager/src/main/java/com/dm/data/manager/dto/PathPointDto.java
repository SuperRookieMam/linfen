package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PathPointDto extends AbstractRegionDto {

    private static final long serialVersionUID = 9106830225429081056L;

    private Long id;
    /**
     * 点名称
     */
    private String name;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;
}
