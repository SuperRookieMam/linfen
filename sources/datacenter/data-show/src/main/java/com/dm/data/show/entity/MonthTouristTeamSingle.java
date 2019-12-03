package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractMonthData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每月团散客走势
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class MonthTouristTeamSingle extends AbstractMonthData<Long> {

	/**
	 * 团队、散客
	 */
	private String name;
}
