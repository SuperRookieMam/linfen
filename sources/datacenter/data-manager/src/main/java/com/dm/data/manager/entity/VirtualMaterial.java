package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 虚拟素材
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "virtual_material_")
public class VirtualMaterial extends AbstractCurrency<Long> {

    /**
     * 素材标题
     */
    @Column(name = "material_title_", length = 200)
    private String materialTitle;

    /**
     * 类型
     */
    @Column(name = "type_", length = 50)
    private String type;

    /**
     * 来源
     */
    @Column(name = "source_")
    @Lob
    private String source;

    /**
     * 素材分类
     */
    @Column(name = "the_material_class_ification_", length = 50)
    private String theMaterialClassification;

    /**
     * 文件大小
     */
    @Column(name = "the_file_size_")
    @Lob
    private String theFileSize;

    /**
     * 拍摄时间
     */
    @Column(name = "shooting_time_", length = 20)
    private String shootingTime;

    /**
     * 所属资源
     */
    @Column(name = "subordinate_to_the_resource_")
    @Lob
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
