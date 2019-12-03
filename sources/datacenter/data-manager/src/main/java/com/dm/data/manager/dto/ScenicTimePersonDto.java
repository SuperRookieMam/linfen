package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 景区时时人数
 */
@Getter
@Setter
public class ScenicTimePersonDto extends AbstractRegionDto {
    private static final long serialVersionUID = -8479826939166768913L;
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
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄段
     */
    private String ageMax;
    /**
     * 年龄段
     */
    private String ageMin;

    /**
     * 游客接待总量
     */
    private Integer receiveNum;

    /**
     * 当前游客量
     */
    private Integer nowPeopleNum;
}
