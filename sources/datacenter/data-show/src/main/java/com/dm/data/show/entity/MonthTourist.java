package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractMonthData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每月游客数量
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class MonthTourist extends AbstractMonthData<Long> {

}
