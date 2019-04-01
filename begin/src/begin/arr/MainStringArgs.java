package begin.arr;

public class MainStringArgs {

	public static void main(String[] args) {		//배열이 선언까지 되어있음
//		System.out.println(args[0]);
//		System.out.println(args[1]);
		
		//프로그램 실행 시 문자열 하나를 매개변수로 입력받아
		//입력한 문자열이
		//"admin"이면 "관리자 페이지로 이동"을 출력하고
		//"user"이면 "사용자 페이지로 이동"을 출력
		
		String input = args[0];		
		if (input.equals("admin")) {
			System.out.println("관리자 페이지로 이동");
		}
		else if(input.equals("user"))	{
			System.out.println("사용자 페이지로 이동");	// 문자열 비교는 ==가 아니라 A.equals(B) 로 해야한다.		
			}
	}

}
