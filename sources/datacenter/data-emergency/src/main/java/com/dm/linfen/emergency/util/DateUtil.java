package com.dm.linfen.emergency.util;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Description: 当前项目需要的时间格式
 * @Author: 温东山
 * @CreateDate: 2019/7/23 0023 13:57
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/7/23 0023 13:57
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class DateUtil {

	private static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * 获取当前时间的前多少月的日期月份集合
	 *
	 * @param num
	 * @return
	 */
	public static List<String> getTopNum(Integer num) {
		List<String> dates = new ArrayList(16);
		formatters = DateTimeFormatter.ofPattern("yyyyMM");
		LocalDate now = LocalDate.now();
		for (int i = num - 1; i >= 0; i--) {
			dates.add(now.minusMonths(i).format(formatters));
		}
		return dates;

	}

	/**
	 * 获得某个月最大天数
	 *
	 * @param year  年份
	 * @param month 月份 (1-12)
	 * @return 某个月最大天数
	 */
	public static int getMaxDayByYearMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year - 1);
		calendar.set(Calendar.MONTH, month);
		return calendar.getActualMaximum(Calendar.DATE);
	}

}
