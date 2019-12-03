package com.dm.linfen.emergency.util;

/**
 * @Description: 天气污染指标范围
 * @Author: 温东山
 * @CreateDate: 2019/8/6 0006 09:29
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/8/6 0006 09:29
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public enum AirQualityEnum {
	/**
	 * 优秀
	 */
	EXCELLENT("优", 0, 50),
	/**
	 * 良好
	 */
	GOOD("良", 51, 100),
	/**
	 * 轻微污染
	 */
	MILD("轻度污染", 101, 150),
	/**
	 * 中等污染
	 */
	MODERATE("中度污染", 151, 200),
	/**
	 * 重度污染
	 */
	SEVERE("重度污染", 201, 300),
	/**
	 * 严重污染
	 */
	EXTREMELY("严重污染", 301, 10000);
	/**
	 * 文字表述
	 */
	String msg;
	/**
	 * 最小值
	 */
	Integer min;
	/**
	 * 最大值
	 */
	Integer max;

	AirQualityEnum(String msg, Integer min, Integer max) {
		this.msg = msg;
		this.min = min;
		this.max = max;
	}
}
