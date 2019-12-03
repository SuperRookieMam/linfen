package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * 停车场
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "parking_lot_")
public class ParkingLot extends AbstractCurrency<Long> {

    /**
     * 中文全称
     */
    @Column(name = "chinese_full_name_", length = 50)
    private String chineseFullName;

    /**
     * 中文简称
     */
    @Column(name = "chinese_short_name_", length = 20)
    private String chineseShortName;

    /**
     * 拼音名称
     */
    @Column(name = "pinyin_name_", length = 50)
    private String pinyinName;

    /**
     * 英文名称
     */
    @Column(name = "english_name_", length = 100)
    private String englishName;

    /**
     * 所属区域
     */

    /**
     * 地理位置
     */

    /*** 经度 */
    @Column(name = "longitude_")
    private Double longitude;
    /*** 纬度 */
    @Column(name = "latitude_")
    private Double latitude;

    /**
     * 地址
     */
    @Column(name = "address_", length = 100)
    private String address;

    /**
     * 所属公司
     */
    @Column(name = "the_company_of_affiliation_", length = 200)
    private String theCompanyOfAffiliation;

    /**
     * 关键字
     */
    @Column(name = "keywords_", length = 200)
    private String keywords;

    /**
     * 服务设施
     */
    @Column(name = "service_facilities_", length = 200)
    private String serviceFacilities;

    /**
     * 图片库
     */

    @OneToMany
    private List<Image> images;

    /**
     * 视频库
     */

    @OneToMany
    private List<Video> videos;

    /**
     * 音频库
     */

    @OneToMany
    private List<Audio> audios;

    /**
     * 虚拟素材库
     */

    @OneToMany
    private List<VirtualMaterial> virtualMaterials;

    /**
     * 停车场类型
     */
    @Column(name = "the_parking_lot_type_", length = 50)
    private String theParkingLotType;

    /**
     * 车位类型
     */
    @Column(name = "car_type_", length = 50)
    private String carType;

    /**
     * 车位数量
     */
    @Column(name = "number_of_parking_")
    private Long numberOfParking;

    /**
     * 营业时间
     */
    @Column(name = "business_hours_", length = 200)
    private String businessHours;

    /**
     * 收费标准
     */
    @Column(name = "charge_standard_", length = 200)
    private String chargeStandard;
    /**
     * 活跃度
     */
    @Column(name = "hot_index_")
    private String hotIndex;
}
