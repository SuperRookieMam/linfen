package com.dm.linfen.emergency.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.dm.common.entity.AbstractAuditEntity;

import javax.persistence.*;

/**
 * @author 温东山
 * @create 2019-07-25 15:23
 **/
@Data
@Entity(name = "t_plan")
@EqualsAndHashCode(callSuper = true)
public class Plan extends AbstractAuditEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5925753784830829061L;

	@Id
	@Column(name = "id_")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 名称
	 */
	@Column(name = "name_")
	private String name;

	/**
	 * 预案类型
	 */
	@Column(name = "type_")
	private String type;
	/**
	 * 预案等级
	 */
	@Column(name = "grade_")
	private String grade;

	/**
	 * 预案内容
	 */
	@Lob
	@Column(name = "content_")
	private String content;

	/**
	 * 状态0 1 是否启用
	 */
	@Column(name = "status_")
	private Integer status;

}
