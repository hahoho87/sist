package webex.vo;

public class MemberVO {
	private String userId;
	private String userPw;
	private String userNm;
	private String email1;
	private String email2;
	private String birthDate;
	private String gender;
	private String photo;
	private String regDate;
	
	public MemberVO(String userId, String userPw, String userNm, String email1, String email2, String birthDate,
			String gender, String photo, String regDate) {
		this.userId = userId;
		this.userPw = userPw;
		this.userNm = userNm;
		this.email1 = email1;
		this.email2 = email2;
		this.birthDate = birthDate;
		this.gender = gender;
		this.photo = photo;
		this.regDate = regDate;
	}
	
	public MemberVO(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
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

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	

}
