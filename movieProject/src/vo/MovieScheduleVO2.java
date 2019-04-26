package vo;

import java.util.Date;
import java.sql.Time;

public class MovieScheduleVO2 {

	private int screenNo;
	private String screenDate;
	private String screenTime;
	private int movieID;

	public MovieScheduleVO2() {
	}

	public MovieScheduleVO2(int screenNo, String screenDate, String screenTime, int movieID) {
		this.screenNo = screenNo;
		this.screenDate = screenDate;
		this.screenTime = screenTime;
		this.movieID = movieID;
	}
	
	public MovieScheduleVO2(String screenDate, String screenTime, int movieID) {
		this.screenDate = screenDate;
		this.screenTime = screenTime;
		this.movieID = movieID;
	}
	
	public MovieScheduleVO2(String screenDate, String screenTime) {
		this.screenDate = screenDate;
		this.screenTime = screenTime;
	}
	
	public MovieScheduleVO2(int screenNo, String screenDate, String screenTime) {
		this.screenNo = screenNo;
		this.screenDate = screenDate;
		this.screenTime = screenTime;
	}
	

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	public String getScreenDate() {
		return screenDate;
	}

	public void setScreenDate(String screenDate) {
		this.screenDate = screenDate;
	}

	public String getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(String screenTime) {
		this.screenTime = screenTime;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

}
