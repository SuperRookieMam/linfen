package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 旅游厕所
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tourist_toilet_")
public class TouristToilet extends AbstractCurrency<Long> {

    /**
     * 中文名称
     */
    @Column(name = "fullname_", length = 50)
    private String fullname;

    /**
     * 中文简称
     */
    @Column(name = "short_name_", length = 20)
    private String shortName;

    /**
     * 拼音名称
     */
    @Column(name = "pin_yin_", length = 50)
    private String pinYin;

    /**
     * 英文名称
     */
    @Column(name = "english_name_", length = 100)
    private String englishName;

    /**
     * 所在区域
     */
    @Column(name = "region_", length = 200)
    private String region;

    /**
     * 地理位置
     */
    @Column(name = "location_", length = 200)
    private String location;

    /**
     * 地址
     */
    @Column(name = "address_", length = 200)
    private String address;

    /**
     * 厕所等级
     */
    @Column(name = "tourist_toilet_grade_", length = 20)
    private String touristToiletGrade;

    /**
     * 报警电话
     */
    @Column(name = "police_station_phone_", length = 20)
    private String policeStationPhone;

    /**
     * 收费标准
     */
    @Column(name = "charges_", length = 200)
    private String charges;

    /**
     * 相关景区
     */
    @Column(name = "related_scenics_")
    @Lob
    private String relatedScenics;
    /**
     * 地理经度
     */
    private Double latitude;

    /**
     * 地理经度
     */
    private Double longitude;

    /**
     * 活跃度
     */
    @Column(name = "hot_index_")
    private String hotIndex;
}
