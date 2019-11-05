package com.dm.linfen.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 住宿场所
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonitorManagerDto extends AbstractRegionDto {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	public String no;

	/**
	 * 资源编码
	 */
	private Long id;
	/**
	 * 监控名称
	 */
	private String monitorName;

	/**
	 * 推流地址
	 */
	private String monitorPushUrl;

	/**
	 * 拉流地址
	 */
	private String monitorPullUrl;
	/**
	 * 经度
	 */
	private Double longitude;

	/**
	 * 纬度
	 */
	private Double latitude;

	/**
	 * 最后一次画面
	 */
	private String coverPhoto;

	/**
	 * 监控编号
	 */
	private String roomNumber;

	/**
	 * 所属景区
	 */
	private String scenic;

	/**
	 * 推流密码
	 */
	private String pushPassword;

	/**
	 * 拉流密码
	 */
	private String pullPassword;

	/**
	 * 摄像头地址
	 * */
	private String cameraUrl;

	private Integer width;

	private Integer height;

	private Boolean run = false;

    private Integer audioSwitch=0;

	private String transformType;
}
