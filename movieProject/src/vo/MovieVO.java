package vo;

import java.sql.Date;

public class MovieVO {
	
	private int movieID;
	private String movieTitle;
	private String movieDirector;
	private String movieActor;
	private int movieAge;
	private String movieOpenday;
	private int movieRunningTime;
	private String movieSummary;
	
	public MovieVO() {}
	
	public MovieVO(int movieID, String movieTitle, String movieDirector,
				   String movieActor, int movieAge, String movieOpenday,
				   int movieRunningTime, String movieSummary) {
		this.movieID = movieID;
		this.movieTitle = movieTitle;
		this.movieDirector = movieDirector;
		this.movieActor = movieActor;
		this.movieAge = movieAge;
		this.movieOpenday = movieOpenday;
		this.movieRunningTime = movieRunningTime;
		this.movieSummary = movieSummary;
		
	}
	
	public MovieVO(String movieTitle, String movieDirector,
			   String movieActor, int movieAge, String movieOpenday,
			   int movieRunningTime, String movieSummary) {

	this.movieTitle = movieTitle;
	this.movieDirector = movieDirector;
	this.movieActor = movieActor;
	this.movieAge = movieAge;
	this.movieOpenday = movieOpenday;
	this.movieRunningTime = movieRunningTime;
	this.movieSummary = movieSummary;
	
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

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieActor() {
		return movieActor;
	}

	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}

	public int getMovieAge() {
		return movieAge;
	}

	public void setMovieAge(int movieAge) {
		this.movieAge = movieAge;
	}

	public String getMovieOpenday() {
		return movieOpenday;
	}

	public void setMovieOpenday(String movieOpenday) {
		this.movieOpenday = movieOpenday;
	}

	public int getMovieRunningTime() {
		return movieRunningTime;
	}

	public void setMovieRunningTime(int movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}

	public String getMovieSummary() {
		return movieSummary;
	}

	public void setMovieSummary(String movieSummary) {
		this.movieSummary = movieSummary;
	}

	
	
}
