package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class RoomInfoDto extends AbstractRegionDto {

    private static final long serialVersionUID = -7104214179832903776L;
    /**
     * 资源编码
     */
    private Long id;
    /**
     * 房间类型
     */
    private String roomType;

    /**
     * 房间数量
     */
    private Long roomNumber;

    /**
     * 可预订房间
     */
    private Long canBookARoom;

    /**
     * 正常价格
     */
    private String normalPrice;

    /**
     * 节假日价格
     */
    private String holidayPrices;

    /**
     * 加床价
     */
    private String extraBedPrice;

    /**
     * 服务设施描述
     */
    private String servicesDescribed;

    /**
     * 餐饮说明
     */
    private String eatDescription;

    /**
     * 酒店Id
     */
    private Long accommodationId;

    /**
     * 简介
     */
    private String description;

    /**
     * 图片库
     */
    private List<ImageDto> images = Collections.emptyList();

    private List<VideoDto> videos = Collections.emptyList();
}
