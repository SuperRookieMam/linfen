package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractMonthData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每月旅游收入
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class MonthIncome extends AbstractMonthData<Float> {

}
