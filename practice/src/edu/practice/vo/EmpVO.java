package edu.practice.vo;

import java.util.Date;

public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNum;
	private Date hireDate;
	private String jobId;
	private int salary;
	private int commissionPCT;
	private int managerID;
	
	public EmpVO() { }
	
	public EmpVO(int id, String lastName, String firstName, String email, String jobId) {
		this.employeeId = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.jobId = jobId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeID) {
		this.employeeId = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobID) {
		this.jobId = jobID;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getCommissionPCT() {
		return commissionPCT;
	}
	public void setCommissionPCT(int commissionPCT) {
		this.commissionPCT = commissionPCT;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	private int departmentID;
	
	
	
	
}
