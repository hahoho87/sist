package webz.vo;

import java.util.Date;

public class MemoVO {

	private int memoId;
	private int pMemoId;
	private String userId;
	private String title;
	private String content;
	private Date regDate;

	public MemoVO(int memoId, int pMemoId, String userId, 
				String title, String content, Date regDate) {
		this.memoId = memoId;
		this.pMemoId = pMemoId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public int getMemoId() {
		return memoId;
	}

	public void setMemoId(int memoId) {
		this.memoId = memoId;
	}

	public int getpMemoId() {
		return pMemoId;
	}

	public void setpMemoId(int pMemoId) {
		this.pMemoId = pMemoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
