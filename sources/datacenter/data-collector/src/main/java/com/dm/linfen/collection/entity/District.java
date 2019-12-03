package com.dm.linfen.collection.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 1.0
 * @Description: 地区实体
 * @Auther: hay17
 * @Date: 2018/12/8 11:40
 */
@Data
@Entity(name = "t_district")
public class District {

	/**
	 * 地点 编号
	 */
	@Column(name = "district_id_")
	@Id
	private String districtId;

	/**
	 * 地区 名称
	 */
	@Column(name = "district_name_")
	private String name;

	/**
	 * 所属区划代码
	 */
	@Column(name = "region_code_")
	private String regionCode;

	/**
	 * 所属区划名称
	 */
	@Column(name = "region_name_")
	private String regionName;

}
