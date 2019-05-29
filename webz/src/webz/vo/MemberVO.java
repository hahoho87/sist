package webz.vo;

import java.util.Date;

public class MemberVO {
	private String userId;
	private String userPw;
	private String email1;
	private String email2;
	private String birthDate;
	private String gender;
	private Date regDate;
	private String photo;
	
	public MemberVO() {}
	
	public MemberVO(String userId, String userPw, String email1, String email2, String birthDate, String gender,
			Date regDate, String photo) {
		this.userId = userId;
		this.userPw = userPw;
		this.email1 = email1;
		this.email2 = email2;
		this.birthDate = birthDate;
		this.gender = gender;
		this.regDate = regDate;
		this.photo = photo;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
