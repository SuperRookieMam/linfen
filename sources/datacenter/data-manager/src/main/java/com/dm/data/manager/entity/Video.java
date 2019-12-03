package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 视频库
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "videos_")
public class Video extends AbstractCurrency<Long> {

    /**
     * 类型
     */
    @Column(name = "type_", length = 50)
    private String type;

    /**
     * 类型
     */
    @Column(name = "title_", length = 50)
    private String title;
    /**
     * 来源
     */
    @Column(name = "source_", length = 200)
    private String source;

    /**
     * 视频规格
     */
    @Column(name = "video_specifications_", length = 200)
    private String videoSpecifications;

    /**
     * 视频格式
     */
    @Column(name = "video_format_", length = 200)
    private String videoFormat;

    /**
     * 文件大小
     */
    @Column(name = "the_file_size_", length = 200)
    private String theFileSize;

    /**
     * 视频时长
     */
    @Column(name = "the_video_time_", length = 200)
    private String theVideoTime;

    /**
     * 拍摄时间
     */
    @Column(name = "shooting_time_", length = 20)
    private String shootingTime;

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
    @Column(name = "all_rights_reserved_")
    @Lob
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

    @Column(name = "show_", length = 200)
    private boolean show = false;
}
