package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 景区接待
 */
@Getter
@Setter
public class SenicReceptionDto extends AbstractRegionDto {
    private static final long serialVersionUID = 5331711487060453837L;
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
     * 数量
     */
    private Integer number;

}
