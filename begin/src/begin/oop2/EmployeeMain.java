package begin.oop2;

import begin.oop.*; // 특정 패키지 전체를 가져옴
//import begin.oop.Method;
//import begin.oop.Animal;
//import begin.oop.Employee;	// 패키지가 다를 때, import를 해주면
//							// 계속 파일명으로만 사용 가능

public class EmployeeMain extends Employee{		
	//protected 사용을 위해 상속 지정
	
	public static void main(String[] args) {
		// Employee 클래스의 참조변수 emp를 생성하고
//		begin.oop.Employee lee = new Employee();
		Employee lee = new Employee();

		// 이름을 Lee로 저장
		lee.name = "Lee";
		
		// 직함을 manager로 저장
		EmployeeMain emp = new EmployeeMain();
		emp.title = "Manager";
		
		// 사번은1234로 저장
		lee.setEmpNo(1234);
		
		System.out.println(lee.name);
		System.out.println(emp.title);
		System.out.println(lee.getEmpNo());
}
}
