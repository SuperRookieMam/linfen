package com.dm.data.manager.entity.core;

import com.dm.data.manager.enums.NoEnums;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 通用类
 *
 * @author Administrator
 *
 */
@Getter
@Setter
@MappedSuperclass
public class AbstractCurrency<T extends Serializable> extends AbstractCore<T> {

    @Column(name = "region_code_")
    private String regionCode;

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

}
