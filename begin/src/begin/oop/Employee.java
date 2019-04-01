package begin.oop;

//접근제한자
//public	: 모든 곳에서 접근 가능
//protected	: 동일 패키지 또는 하위클래스(상속), 동일 클래스
//			: 동일 패키지. 동일 클래스
//private	: 동일 클래스

public class Employee { 
	public String name; 
	protected String title; 
	int age; 
	private int empNo;
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	} 

	
}
