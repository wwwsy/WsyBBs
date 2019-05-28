package WsyBBs.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static final String SQL_FORMAT = "yyyyMMdd";
	public static final SimpleDateFormat sdf = new SimpleDateFormat();

	/**
	 * 今日日期转数据库默认格式字符串
	 **/
	public static String todayToDefaultString() {
		sdf.applyPattern(SQL_FORMAT);
		return sdf.format(new Date());
	}

	/**
	 * 前端日期字符串转数据库默认格式字符串
	 * 
	 **/
	public static String frontStringToDefaultString(String frontString) {
		return frontString.replace("-", "");
	}
}
