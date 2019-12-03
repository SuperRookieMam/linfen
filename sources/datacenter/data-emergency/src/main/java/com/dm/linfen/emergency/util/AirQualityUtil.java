package com.dm.linfen.emergency.util;

/**
 * @author 温东山
 * @create 2018-09-10 10:52 空气污染指数判断标准
 **/
public class AirQualityUtil {

	/**
	 * 根据pm值获取空气指数
	 * 
	 * @param val
	 * @return
	 */
	public static String getPm25(Integer val) {
		if (val <= AirQualityEnum.EXCELLENT.max) {
			return AirQualityEnum.EXCELLENT.msg;
		} else if (val > AirQualityEnum.EXCELLENT.max && val <= AirQualityEnum.GOOD.max) {
			return AirQualityEnum.GOOD.msg;
		} else if (val > AirQualityEnum.GOOD.max && val <= AirQualityEnum.MILD.max) {
			return AirQualityEnum.MILD.msg;
		} else if (val > AirQualityEnum.MILD.max && val <= AirQualityEnum.MODERATE.max) {
			return AirQualityEnum.MODERATE.msg;
		} else if (val >= AirQualityEnum.MODERATE.max && val <= AirQualityEnum.SEVERE.max) {
			return AirQualityEnum.SEVERE.msg;
		} else if (val > AirQualityEnum.SEVERE.max) {
			return AirQualityEnum.EXTREMELY.msg;
		}
		return "";
	}
}
