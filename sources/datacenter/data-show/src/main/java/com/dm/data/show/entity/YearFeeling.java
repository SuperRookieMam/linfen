package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年情感分布
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearFeeling extends AbstractYearData<Float> {

}
