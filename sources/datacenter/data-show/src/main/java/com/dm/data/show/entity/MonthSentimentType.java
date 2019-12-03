package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractMonthData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每月舆情数量
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class MonthSentimentType extends AbstractMonthData<Long> {

	/**
	 * 舆情类型
	 * 敏感、非敏感
	 */
	private String name;
}
