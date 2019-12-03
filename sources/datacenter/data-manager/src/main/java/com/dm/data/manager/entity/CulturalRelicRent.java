package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import com.dm.file.entity.FileInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author yinjie
 * @date 2019年8月2日11:05:24 文物租赁
 */

@Getter
@Setter
@Entity(name = "culture_relic_rent")
public class CulturalRelicRent extends AbstractCurrency<Long> {
    /**
     * 文物名称
     */
    @Column(name = "name_")
    private String name;
    /**
     * 出借单位
     */
    @Column(name = "lending_unit_")
    private String lendingUnit;
    /**
     * 出借城市
     */
    @Column(name = "lending_code_")
    private String lendingCode;

    /**
     * 租借单位
     */
    @Column(name = "rental_unit_")
    private String rentalUnit;
    /**
     * 租借城市坐标
     */
    @Column(name = "rental_code_")
    private String rentalCode;
    /**
     * 开始时间
     */
    @Column(name = "rental_time_")
    private LocalDate rentalTime;
    /**
     * 归还时间
     */
    @Column(name = "return_time_")
    private LocalDate returnTime;
    /**
     * 图片路径集合
     */
    @OneToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "t_culture_relic_img")
//   @ElementCollection
    private List<FileInfo> imgs;
    /**
     * //租借状态
     */
    @Column(name = "return_status")
    private String rentStatus;
    /**
     * 描述
     */
    @Column(name = "desc_")
    @Lob
    private String description;

    /**
     * 租借天数
     */
    @Column(name = "rent_days_")
    private Integer rentDays;

}
