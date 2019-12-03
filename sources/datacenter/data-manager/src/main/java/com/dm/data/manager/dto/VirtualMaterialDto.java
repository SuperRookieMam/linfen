package com.dm.data.manager.dto;

import lombok.Data;

/**
 * 虚拟素材
 *
 */
@Data
public class VirtualMaterialDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 素材标题
     */
    private String materialTitle;

    /**
     * 类型
     */
    private String type;

    /**
     * 来源
     */
    private String source;

    /**
     * 素材分类
     */
    private String theMaterialClassification;

    /**
     * 文件大小
     */
    private String theFileSize;

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
     * 版权说明
     */
    private String copyright;

    private String file;

    private String name;

}
