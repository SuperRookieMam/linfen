package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractHourData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每小时景区人数
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class HourScenic extends AbstractHourData<Long> {

	/**
	 * 景区名称
	 */
	private String name;
}
