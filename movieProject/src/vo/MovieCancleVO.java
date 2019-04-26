package vo;

import java.util.List;

public class MovieCancleVO {

	private String movieTitle;
	private String screenDate;
	private int movieID;
	private int bookingNO;
	
	public int getBookingNO() {
		return bookingNO;
	}
	public void setBookingNO(int bookingNO) {
		this.bookingNO = bookingNO;
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
	public String getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(String screenDate) {
		this.screenDate = screenDate;
	}

	
}
