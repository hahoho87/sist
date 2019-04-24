package vo;

import java.util.Date;

public class CustomerVO {

	private int customerNo;
	private String customerID;
	private String customerPW;
	private String customerName;
	private String customerPhone;
	private Date customerBirth;

	public CustomerVO() {
	}

	public CustomerVO(int customerNo, String customerID, String customerPW, String customerName, String customerPhone,
			Date customerBirth) {
		
		this.customerNo = customerNo;
		this.customerID = customerID;
		this.customerPW = customerPW;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerBirth = customerBirth;

	}
	
	public CustomerVO(String customerID, String customerPW, String customerName, String customerPhone,
			Date customerBirth) {
		
		this.customerID = customerID;
		this.customerPW = customerPW;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerBirth = customerBirth;

	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerPW() {
		return customerPW;
	}

	public void setCustomerPW(String customerPW) {
		this.customerPW = customerPW;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Date getCustomerBirth() {
		return customerBirth;
	}

	public void setCustomerBirth(Date customerBirth) {
		this.customerBirth = customerBirth;
	}

}
