package com.dm.linfen.entity;

import com.dm.linfen.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 住宿场所
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity
@Table(name = "monitor_manager_")
public class MonitorManager extends AbstractCurrency<Long> {

	/**
	 * 监控名称
	 */
	@Column(name = "monitor_name_", length = 50)
	private String monitorName;

	/**
	 * 监控编号
	 */
	@Column(name = "room_number_")
	private String roomNumber;

	/**
	 * 推流地址
	 */
	@Column(name = "monitor_push_url")
	private String monitorPushUrl;

	/**
	 * 推流密码
	 */
	@Column(name = "push_password_")
	private String pushPassword;


	/**
	 * 摄像头地址
	 */
	@Column(name = "camera_url")
	private String cameraUrl;
	/**
	 * 拉流地址
	 */
	@Column(name = "monitor_pull_url")
	private String monitorPullUrl;
	/**
	 * 拉流密码
	 */
	@Column(name = "pull_passowrd")
	private String pullPassword;

	/**
	 * 经度
	 */
	@Column(name = "longitude_")
	private Double longitude;

	/**
	 * 纬度
	 */
	@Column(name = "latitude_")
	private Double latitude;

	/**
	 * 封面图
	 */
	@Column(name = "cover_photo_")
	private String coverPhoto;

	/**
	 * 所属景区
	 */
	@Column(name = "scenic_")
	private String scenic;

	/**
	 * 开启状态
	 */
	@Column(name = "run_")
	private Boolean run;

	@Column(name = "width_")
	private Integer width;

	@Column(name = "height_")
	private Integer height;

	@Column(name = "audio_switch_")
	private Integer audioSwitch=0;

	@Column(name = "transfer_type_")
	private String transformType;

}
