package com.dm.data.manager.dto;

import lombok.Data;

/**
 * 图片库
 *
 */
@Data
public class ImageDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 图片标题
     */
    private String pictureCaptions;

    /**
     * 类型
     */
    private String type;

    /**
     * 来源
     */
    private String source;

    /**
     * 图片格式
     */
    private String imageFormat;

    /**
     * 文件大小
     */
    private String theFileSize;

    /**
     * 拍摄时间
     */
    private String shootingTime;

    /**
     * 是否源文件
     */
    private String ifTheSourceFile;

    /**
     * 所属资源
     */
    private String subordinateToTheResource;

    /**
     * 描述
     */
    private String describe;

    /**
     * 版权所有
     */
    private String allRightsReserved;

    /**
     * 版权说明
     */
    private String copyright;

    private String file;

    private String name;
    private boolean show = false;

}
