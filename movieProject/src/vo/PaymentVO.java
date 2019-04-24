package vo;

import java.util.Date;

public class PaymentVO {
	
	private int bookingNo;
	private Date bookingDate;
	private String paymentConfirm;
	
	public PaymentVO() {}
	
	public PaymentVO(int bookingNo, String paymentConfirm) {
		this.bookingNo = bookingNo;
		this.paymentConfirm = paymentConfirm;
	}
	
	
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getPaymentConfirm() {
		return paymentConfirm;
	}
	public void setPaymentConfirm(String paymentConfirm) {
		this.paymentConfirm = paymentConfirm;
	}
	
	
	

}
