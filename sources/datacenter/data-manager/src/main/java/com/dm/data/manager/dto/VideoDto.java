package com.dm.data.manager.dto;

import lombok.Data;

/**
 * 视频库
 *
 */
@Data
public class VideoDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 视频标题
     */
    private Long id;

    /**
     * 类型
     */
    private String type;

    /**
     * 来源
     */
    private String source;

    /**
     * 视频规格
     */
    private String videoSpecifications;

    /**
     * 视频格式
     */
    private String videoFormat;

    /**
     * 文件大小
     */
    private String theFileSize;

    /**
     * 视频时长
     */
    private String theVideoTime;

    /**
     * 拍摄时间
     */
    private String shootingTime;

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
     * 标题
     */
    private String title;
    /**
     * 版权说明
     */
    private String copyright;

    private String file;

    private String name;
    private boolean show = false;
}
