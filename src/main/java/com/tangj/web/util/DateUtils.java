package com.tangj.web.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String format(Date date , String format){
		return (new SimpleDateFormat(format)).format(date);
	}
	
	/**
	 * 获取日期最开始秒
	 * @param date
	 * @return
	 */
	public static Date getFirstDate(Date date){
		if( date == null ){
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取日期的最后秒
	 * @param date
	 * @return
	 */
	public static Date getLastDate(Date date){
		if( date == null ){
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
	
	
	/**
	 * 添加几天
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date , int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}
	
}