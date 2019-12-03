package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "team_member_")
public class TeamMember extends AbstractCurrency<Long> {

    /**
     * 团员姓名
     */
    @Column(name = "member_name_")
    private String memberName;
    /**
     * 手机
     */
    @Column(name = "mobile_")
    private String mobile;
    /**
     * 身份证号码
     */
    @Column(name = "car_number_")
    private String carNumber;
}
