package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractIndex;

import lombok.Getter;
import lombok.Setter;

/**
 * 导游类别统计
 * 
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class NowGuide extends AbstractIndex<Long> {

	/**
	 * 导游类别 特级、高级、中级、初级
	 */
	private String name;
}
