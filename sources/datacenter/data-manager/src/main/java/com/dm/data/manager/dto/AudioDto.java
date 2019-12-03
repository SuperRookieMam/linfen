package com.dm.data.manager.dto;

import lombok.Data;

/**
 * 音频库
 *
 */
@Data
public class AudioDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 音频标题
     */
    private String audioTitle;

    /**
     * 类型
     */
    private String type;

    /**
     * 来源
     */
    private String source;

    /**
     * 音频格式
     */
    private String audioFormats;

    /**
     * 文件大小
     */
    private String theFileSize;

    /**
     * 音频时长
     */
    private String theAudioTime;

    /**
     * 录制时间
     */
    private String theRecordingTime;

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

}
