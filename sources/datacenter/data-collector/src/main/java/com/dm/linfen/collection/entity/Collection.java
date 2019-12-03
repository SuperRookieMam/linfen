package com.dm.linfen.collection.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dm.common.entity.AbstractAuditEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 一次采集动作, 记录采集日志
 * 
 * @author LiDong
 *
 */
@Entity
@Getter
@Setter
public class Collection extends AbstractAuditEntity {
	private static final long serialVersionUID = -3982057877026368383L;

	/**
	 * 采集事务的结果
	 * 
	 * @author LiDong
	 *
	 */
	public enum Result {
		/**
		 * 采集成功
		 */
		SUCCESS,
		/**
		 * 采集失败
		 */
		FAILURE
	}

	/**
	 * 采集的类型
	 */
	@Column(name = "type_")
	private String type;

	/**
	 * 采集到的总数
	 */
	@Column(name = "count_")
	private Long count;

}
