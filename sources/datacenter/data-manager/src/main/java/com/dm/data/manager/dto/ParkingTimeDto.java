package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingTimeDto extends AbstractRegionDto {
    private static final long serialVersionUID = -2362575122527572823L;
    /**
     * 资源编码
     */
    private Long id;
    /**
     * 年
     */
    private Integer year;

    /**
     * 月
     */
    private Integer month;

    /**
     * 日
     */
    private Integer day;

    /**
     * 时
     */
    private Integer houre;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 景区
     */
    private String scenic;
    /**
     * 总量
     */
    private Integer totalNumber;

    /**
     * 使用量
     */
    private Integer useNumber;
}
