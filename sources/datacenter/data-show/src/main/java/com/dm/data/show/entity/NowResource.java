package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractIndex;

import lombok.Getter;
import lombok.Setter;

/**
 * 全市旅游资源
 * 
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class NowResource extends AbstractIndex<Long> {

	/**
	 * 资源名称
	 */
	private String name;
}
