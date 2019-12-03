package com.dm.data.manager.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 旅游线路
 *
 */
@Data
public class TouristRouteDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 资源编码
     */
    private Long id;

    /**
     * 线路编号
     */
    private String no;

    /**
     * 线路名称
     */
    private String name;

    /**
     * 线路类型
     */
    private String type;

    /**
     * 目的地
     */
    private String target;

    /**
     * 目的地类型
     */
    private String targetType;

    /**
     * 线路天数
     */
    private String days;

    /**
     * 线路图片
     */

    private List<ImageDto> images = Collections.emptyList();

    /**
     * 线路介绍
     */
    private String description;
    /**
     * 价格
     */
    private String price;

    /**
     * 电话
     */
    private String phone;
    /**
     * 出行方式
     */
    private String wayType;

    private List<PathPointDto> pathPoints = Collections.emptyList();
}
