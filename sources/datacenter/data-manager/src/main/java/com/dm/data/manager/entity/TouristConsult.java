package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import com.dm.data.manager.enums.NoEnums;
import com.dm.file.entity.FileInfo;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * 旅游咨询
 */
@Getter
@Setter
@Entity(name = "tourist_consult_")
public class TouristConsult extends AbstractCurrency<Long> {

    /**
     * 编号
     */
    @Column(name = "no_")
    public String no;

    /**
     * 编码规则
     */
    @Column(name = "no_enums_")
    @Enumerated(EnumType.STRING)
    public NoEnums noEnums;
    /**
     * 标题
     */
    @Column(name = "titile_")
    private String titile;
    /**
     * 来源
     */
    @Column(name = "source_")
    private String source;
    /**
     * 咨询简介
     */
    @Lob
    @Column(name = "description_")
    private String description;

    @Lob
    @Column(name = "html_")
    private String html;
    /**
     * 咨询,活动,攻略,旅游行程路线
     */
    @Column(name = "type_")
    private String type;

    @ElementCollection
    private List<FileInfo> imgs;
//创建人
    @Column(name = "creat_user_")
    private String creatUser;
//创建时间
    @Column(name = "creat_time")
    private LocalDate creatTime;

}
