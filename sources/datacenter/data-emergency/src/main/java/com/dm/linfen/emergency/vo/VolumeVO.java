package com.dm.linfen.emergency.vo;

import lombok.Data;

/**
 * @author 温东山
 * @create 2019-07-23 14:22
 **/
@Data
public class VolumeVO {
	private String dataTime;
	private Integer count;
	private String volumeName;

	public VolumeVO(String dataTime, Integer count, String volumeName) {
		this.dataTime = dataTime;
		this.count = count;
		this.volumeName = volumeName;
	}

	public VolumeVO() {

	}
}
