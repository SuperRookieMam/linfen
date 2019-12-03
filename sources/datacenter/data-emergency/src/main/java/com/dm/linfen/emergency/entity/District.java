package com.dm.linfen.emergency.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

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
	 * id
	 */
	@Id
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
	 * 地区 名称 拼音
	 */
	@Column(name = "district_name_spell_")
	private String districtNameSpell;
	/**
	 * 地区 区号
	 */
	@Column(name = "district_area_code_")
	private String districtAreaCode;
	/**
	 * 地区 邮政 编号
	 */
	@Column(name = "district_mail_id_")
	private String districtMailId;

	/**
	 * 区县 名称
	 */
	@Column(name = "county_name_")
	private String countyName;

	/**
	 * 区县 名称 拼音
	 */
	@Column(name = "county_name_spell_")
	private String countyNameSpell;
	/**
	 * 省/直辖市/国名（国外） 名称
	 */
	@Column(name = "province_name_")
	private String provinceName;
	/**
	 * 省/直辖市/国名（国外） 名称 拼音
	 */
	@Column(name = "province_name_spell_")
	private String provinceNameSpell;

}
