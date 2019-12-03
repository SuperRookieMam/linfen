package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 图片库
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "image_database_")
public class Image extends AbstractCore<Long> {

    /**
     * 图片标题
     */
    @Column(name = "picture_captions_", length = 50)
    private String pictureCaptions;

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
     * 图片格式
     */
    @Column(name = "image_format_", length = 200)
    private String imageFormat;

    /**
     * 文件大小
     */
    @Column(name = "the_file_size_", length = 200)
    private String theFileSize;

    /**
     * 拍摄时间
     */
    @Column(name = "shooting_time_", length = 200)
    private String shootingTime;

    /**
     * 是否源文件
     */
    @Column(name = "if_the_source_file_", length = 200)
    private String ifTheSourceFile;

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

    @Column(name = "show_", length = 200)
    private boolean show = false;

}
