package begin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CancellationException;

public class DateTime {

	public static void caltime() {
		long before = System.currentTimeMillis();
		System.out.println("시작 시간 : " + new Date(before));
		long sum = 0L;

		for (long l = 1l; l < 100000000000L; l++) {
			sum += l;
		}

		long after = System.currentTimeMillis();
		System.out.println("종료 시간 : " + new Date(after));
		System.out.println("1 ~ 100000000000까지의 합 : " + sum);
		System.out.println("소요 시간 : " + (after - before) / 1000 + "초");
	}

	public static void main(String[] args) {
//		testDate();	//Date클래스 사용 연습
//		calTime();	//소요시간 계산
		testCalendar();

	}// End main

	private static void testCalendar() {
		//Calendar 클래스를 이용하여 현재 시간 출력

	     Calendar calNow = Calendar.getInstance();
	     
	     int year = calNow.get(Calendar.YEAR);
	     int month = calNow.get(Calendar.MONTH);
	     int date = calNow.get(Calendar.DAY_OF_MONTH);
	     int day = calNow.get(Calendar.DAY_OF_WEEK);
	     int apm = calNow.get(Calendar.AM_PM);
	     int hour = calNow.get(Calendar.HOUR);
	     int min = calNow.get(Calendar.MINUTE);
	     int sec = calNow.get(Calendar.SECOND);
	     
	     //오늘은 2019년 3월 18일 월요일
	     //지금 시각은 오전/ㅇ후 ~~시 ~~분 ~~초
	     
	     System.out.print("오늘은 " + year + "년 " + (month+1) + "월 " + date + "일 ");
	     
	     String[] day1 = {"일", "월", "화", "수", "목", "금", "토"};
	     System.out.println(day1[day-1] + "요일");
	     
	     switch (apm)	{
	     case 1 :  System.out.print("지금 시각은 오후 ");	break;
	     default : System.out.print("지금 시각은 오전 ");	break;
	     }
	     
	     System.out.println(hour + "시 " + min + "분 " + sec + "초");
	     
	}

	private static void testDate() {
		// Date 클래스를 이용하여 현재 시간 출력
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toLocaleString());

		// 특정 문자열 포맷으로 날짜 출력
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(simpleDate.format(now));
	}

}// End class
