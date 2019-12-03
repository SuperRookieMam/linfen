package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 停车场
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ParkingLotDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public String no;

    /**
     * 省会编码
     */

    /**
     * 城市编码
     */
    /** 区划名称 **/

    /**
     * 区县编码
     */

    /**
     * 资源编码
     */
    private Long id;

    /**
     * 中文全称
     */
    private String chineseFullName;

    /**
     * 中文简称
     */
    private String chineseShortName;

    /**
     * 拼音名称
     */
    private String pinyinName;

    /**
     * 英文名称
     */
    private String englishName;

    /**
     * 所属区域
     */

    /**
     * 地理位置
     */
    /** 经度 **/
    private Double longitude;
    /** 纬度度 **/
    private Double latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 所属公司
     */
    private String theCompanyOfAffiliation;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 服务设施
     */
    private String serviceFacilities;

    /**
     * 图片库
     */

    private List<ImageDto> images;

    /**
     * 视频库
     */
    private List<VideoDto> videos;

    /**
     * 音频库
     */

    private List<AudioDto> audios;

    /**
     * 虚拟素材库
     */

    private List<VirtualMaterialDto> virtualMaterials;

    /**
     * 停车场类型
     */
    private String theParkingLotType;

    /**
     * 车位类型
     */
    private String carType;

    /**
     * 车位数量
     */
    private Long numberOfParking;

    /**
     * 营业时间
     */
    private String businessHours;

    /**
     * 收费标准
     */
    private String chargeStandard;
    /**
     * 活跃度
     */
    private String hotIndex;
}
