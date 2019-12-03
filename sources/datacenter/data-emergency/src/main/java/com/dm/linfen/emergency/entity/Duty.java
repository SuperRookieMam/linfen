package com.dm.linfen.emergency.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author 温东山
 * @create 2019-07-24 10:23
 **/
@Entity(name = "t_duty")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Duty {

	@Id
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 值班时间
	 */
	@Column(name = "creat_time_")
	private LocalDate createTime;

	/**
	 * 早值班人员名称
	 */
	@Column(name = "morning_worker_name_")
	private String morningWorkerName;
	/**
	 * 早值班人员电话
	 */
	@Column(name = "morning_worker_telephone_")
	private String morningWorkerTelephone;

	/**
	 * 中值班人员名称
	 */
	@Column(name = "noon_worker_name_")
	private String noonWorkerName;
	/**
	 * 中值班人员电话
	 */
	@Column(name = "noon_worker_telephone_")
	private String noonWorkerTelephone;

	/**
	 * 中值班人员名称
	 */
	@Column(name = "night_worker_name_")
	private String nightWorkerName;
	/**
	 * 中值班人员电话
	 */
	@Column(name = "night_worker_telephone_")
	private String nightWorkerTelephone;
	/**
	 * 管理部门电话
	 */
	@Column(name = "manager_department_telephone_")
	private String managerDepartmentTelephone;
	/**
	 * 应急部门电话
	 */
	@Column(name = "headquarter_telephone")
	private String headquarterTelephone;

}
