package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年游客认知图谱
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearCognitionAtlas extends AbstractYearData<Long> {

	/**
	 * 图谱名称
	 */
	private String name;
}
