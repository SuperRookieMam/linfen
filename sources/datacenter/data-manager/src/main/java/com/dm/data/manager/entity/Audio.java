package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 音频库
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "audio_database_")
public class Audio extends AbstractCurrency<Long> {

    /**
     * 音频标题
     */
    @Column(name = "audio_title_", length = 200)
    private String audioTitle;

    /**
     * 类型
     */
    @Column(name = "type_", length = 50)
    private String type;

    /**
     * 来源
     */
    @Column(name = "source_", length = 200)
    private String source;

    /**
     * 音频格式
     */
    @Column(name = "audio_formats_", length = 200)
    private String audioFormats;

    /**
     * 文件大小
     */
    @Column(name = "the_file_size_", length = 200)
    private String theFileSize;

    /**
     * 音频时长
     */
    @Column(name = "the_audio_time_", length = 200)
    private String theAudioTime;

    /**
     * 录制时间
     */
    @Column(name = "the_recording_time_", length = 200)
    private String theRecordingTime;

    /**
     * 所属资源
     */
    @Column(name = "subordinate_to_the_resource_", length = 200)
    private String subordinateToTheResource;

    /**
     * 描述
     */
    @Column(name = "describe_")
    @Lob
    private String describe;

    /**
     * 版权所有
     */
    @Column(name = "all_rights_reserved_", length = 200)
    private String allRightsReserved;

    /**
     * 版权说明
     */
    @Column(name = "copyright_")
    @Lob
    private String copyright;

    @Column(name = "file_", length = 40)
    private String file;

    @Column(name = "name_", length = 200)
    private String name;
}
