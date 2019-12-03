package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年累计接待游客人数
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTourist extends AbstractYearData<Long>{

}
