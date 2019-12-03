package com.dm.data.manager.dto;

import lombok.Data;

import java.util.List;

/**
 * 旅游商品
 *
 */
@Data
public class TouristCommodityDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 资源编码
     */
    private Long id;

    /**
     * 中文全称
     */
    private String fullname;

    /**
     * 中文简称
     */
    private String shortName;

    /**
     * 拼音名称
     */
    private String pinYin;

    /**
     * 英文名称
     */
    private String englishName;

    /**
     * 商品类型
     */
    private String type;

    /**
     * 商品说明
     */
    private String description;

    /**
     * 商品介绍
     */
    private String note;

    /**
     * 购物提示
     */
    private String propt;

    /**
     * 物流提示
     */
    private String logisticsPrompt;

    /**
     * 推荐品牌
     */
    private String recommendedBrand;

    /**
     * 推荐购物场所
     */
    private String recommendedShop;

    /**
     * 图片库
     */

    private List<ImageDto> images;

    /**
     * 视频库
     */

    private List<VideoDto> videos;

}
