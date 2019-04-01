package begin.control;

public class Switch {

	public static void main(String[] args) {
		//switch (값) {
		//	case 값1	: ~~~ ;		break;
		//	case 값2	: ~~~ ;		break;
		//		...
		//	default	: ~~~ ;
		//}
		
		int grade = 1;
		//등급이 1 : 우수회원
		//등급이 2 : 일반회원
		//등급이 3 : 관리자
		//	그 외   : 손님
		
		switch (grade) {
		case 1:		System.out.println("우수회원");
					break;
		case 2:		System.out.println("일반회원");
					break;			
		case 3:		System.out.println("관리자");
					break;	
		default:	System.out.println("손님");
					break;
		}
		System.out.println("===========================");
		
		String id = "admin";
		//id가 admin이면 "관리자 로그인" 출력
		//id가 guest이면 "손님 로그인" 출력
		//그 외의 경우에는 "일반회원 로그인" 출력
		String result;
		
		switch (id) {
		case "admin":	result = "관리자";	break;
		case "guest":	result = "손님";		break;
		default		:	result = "일반회원";	break;
		}
		System.out.println(result + " 로그인");
		

	}//End main

}//End class
