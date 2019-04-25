package vo;

import java.sql.Date;
import java.sql.Time;

public class MovieScheduleListVO {

	private int screenNo;
	private Date screenDate;
	private Time screenTime;
	private Time screenEndTime;
	private int movieID;
	private String movieTitle;
	
	
	public Time getScreenEndTime() {
		return screenEndTime;
	}
	public void setScreenEndTime(Time screenEndTime) {
		this.screenEndTime = screenEndTime;
	}
	public int getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	public Date getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(Date screenDate) {
		this.screenDate = screenDate;
	}
	public Time getScreenTime() {
		return screenTime;
	}
	public void setScreenTime(Time screenTime) {
		this.screenTime = screenTime;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	
	
}
