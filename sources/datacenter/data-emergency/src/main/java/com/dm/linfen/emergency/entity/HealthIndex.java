package com.dm.linfen.emergency.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author 1.0
 * @Description:
 * @Auther: hay17
 * @Date: 2018/12/8 11:40
 */

@Data
@Entity(name = "t_health_index")
public class HealthIndex {

	@Id
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 地区 编号
	 */
	@Column(name = "district_id_")
	private String districtId;
	/**
	 * 地区 名称
	 */
	@Column(name = "district_name_")
	private String districtName;

	/**
	 * 数据采集时间
	 */
	@Column(name = "collect_time", length = 8000)
	private LocalDate collectTime;
	/**
	 * 指数信息,全部存储到json里面每小时抓取一次
	 */
	@Column(name = "info_")
	@Lob
	private String info;

}
