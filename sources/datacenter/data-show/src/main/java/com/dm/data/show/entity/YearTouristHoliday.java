package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年节假日累计接待人数 
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTouristHoliday extends AbstractYearData<Long> {

}
