package kr.plee.pl.common.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonObject;

public class DateUtil {
	
	private final static String[] DAY_OF_WEEK_KR = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};

	/** 입력날짜 주의 일 정보 목록을 반환 */
	public static List<JsonObject> getWeekDayList(String yyyy, String month, int selectWeek) {
		List<JsonObject> thisWeek = new ArrayList<JsonObject>();

		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(yyyy);
		int intMonth = Integer.parseInt(month);
		System.out.println(intYear + ", " + intMonth);
		
		cal.set(Calendar.YEAR, intYear);
		cal.set(Calendar.MONTH, intMonth - 1);

		int startDay = 0;
		int endDay = 0;
		
		// 선택한 yyyymm week 주의 시작날짜 마지막날짜 구하기 
		for ( int week = 1; week < cal.getMaximum(Calendar.WEEK_OF_MONTH); week++ ) {
			cal.set(Calendar.WEEK_OF_MONTH, week);
			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			startDay = cal.get(Calendar.DAY_OF_MONTH);
			
			cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			endDay = cal.get(Calendar.DAY_OF_MONTH);
			
			if ( week == 1 && startDay >= 7 ) startDay = 1;
				
			if ( week == cal.getMaximum(Calendar.WEEK_OF_MONTH) - 1 && endDay <= 7 ) {
				endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			}

			if ( selectWeek == week ) break;
		}
		
		System.out.println(startDay);
		System.out.println(endDay);
		
		for ( int i = startDay; i <= endDay; i++ ) {
		    cal.set(Calendar.DAY_OF_MONTH , i);
		    
		    int dayOfWeekIdx = cal.get(Calendar.DAY_OF_WEEK);
		    
		    // 일요일제외
		    if ( dayOfWeekIdx == 1 ) continue;
		    
			JsonObject obj = new JsonObject();
			obj.addProperty("day", i);
			obj.addProperty("dayOfWeek", DAY_OF_WEEK_KR[dayOfWeekIdx - 1]);
			
			thisWeek.add(obj);
		}

		return thisWeek;
	}

	public static int getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd");
		Date date = new Date();

		return Integer.parseInt(format.format(date));
	}

	public static int getCurrentWeek() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.WEEK_OF_MONTH);
	}

	public static String getCurrentYearMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date date = new Date();

		return format.format(date);
	}

	public static String getCurrentYear() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date date = new Date();

		return format.format(date);
	}
	
	public static String getCurrentMonth() {
		SimpleDateFormat format = new SimpleDateFormat("MM");
		Date date = new Date();

		return format.format(date);
	}
	
}
