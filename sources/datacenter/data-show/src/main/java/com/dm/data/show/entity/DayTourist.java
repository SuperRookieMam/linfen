package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractDayData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每日游客数量
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class DayTourist extends AbstractDayData<Long>{

}
