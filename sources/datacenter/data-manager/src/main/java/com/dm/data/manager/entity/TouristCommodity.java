package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * 旅游商品
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tourist_commodity_")
public class TouristCommodity extends AbstractCurrency<Long> {

    /**
     * 中文全称
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
     * 商品类型
     */
    @Column(name = "type_", length = 50)
    private String type;

    /**
     * 商品说明
     */
    @Column(name = "description_")
    @Lob
    private String description;

    /**
     * 商品介绍
     */
    @Column(name = "note_")
    @Lob
    private String note;

    /**
     * 购物提示
     */
    @Column(name = "propt_")
    @Lob
    private String propt;

    /**
     * 物流提示
     */
    @Column(name = "logistics_prompt_")
    @Lob
    private String logisticsPrompt;

    /**
     * 推荐品牌
     */
    @Column(name = "recommended_brand_")
    @Lob
    private String recommendedBrand;

    /**
     * 推荐购物场所
     */
    @Column(name = "recommended_shop_")
    @Lob

    private String recommendedShop;

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

}
