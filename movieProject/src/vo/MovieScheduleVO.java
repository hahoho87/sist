package vo;

import java.util.Date;

public class MovieScheduleVO {
	
	private int screenNo;
	private Date screenDate;
	private Date screenTime;
	private int movieID;
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
	public Date getScreenTime() {
		return screenTime;
	}
	public void setScreenTime(Date screenTime) {
		this.screenTime = screenTime;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	
	
	

}
