package exercise;

import java.util.Calendar;

public class MyCalendar {

	public static void main(String[] args) {
		
		Calendar calNow = Calendar.getInstance();
	     
	     int year = calNow.get(Calendar.YEAR);
	     int month = calNow.get(Calendar.MONTH);
	     int date = calNow.get(Calendar.DAY_OF_MONTH);
	     int day = calNow.get(Calendar.DAY_OF_WEEK);
	     int apm = calNow.get(Calendar.AM_PM);
	     int hour = calNow.get(Calendar.HOUR);
	     int min = calNow.get(Calendar.MINUTE);
	     int sec = calNow.get(Calendar.SECOND);
	      
	     
	     calNow.set(year, month, 1); 
	     int end = calNow.getActualMaximum(Calendar.DATE); //해당 월 마지막 날짜
	     int start = calNow.get(Calendar.DAY_OF_WEEK);	//해당 월 1일의 요일
	     
	     
	     switch (apm)	{
	     case 1 :  System.out.print("오후 ");	break;
	     default : System.out.print("오전 ");	break;
	     }
	     System.out.println(hour + "시 " + min + "분 " + sec + "초");
	     
	     System.out.print(year + "년 " + (month+1) + "월 " + date + "일 ");
	     
	     String[] day1 = {"일", "월", "화", "수", "목", "금", "토"};
	     System.out.println(day1[day-1] + "요일");
	     System.out.println();
	     System.out.println(" Sun Mon Tue Wed Thr Fri Sat");
	     System.out.println("----------------------------");
	     
	     
	     for (int i = 1; i < start ; i++)	{
	            System.out.print("    ");}		// 1일의 요일만큼 공백
	     
	     for (int i = 1; i <= end ; i++) {       
	    	 System.out.printf("%4d", i); 
	            if(start%7==0) System.out.println(); // 토요일이 되면 줄바꿈
	            start++;
	}
	}
}
