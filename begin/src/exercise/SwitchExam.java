package exercise;

public class SwitchExam {

	public static void main(String[] args) {
		//1 ~ 12의 숫자를 받아서 "그 달의 마지막 날은 며칠입니다." 출력
		
		int A = 11;
		int mon ;
		
		if ((A >= 1) && (A <= 12) ) {
			switch (A) {
			case 2: mon = 28;	break;
			case 4: case 6: case 9: case 11: 
					mon = 30;	break;
			default: mon = 31;	break;
			}
			System.out.println(A + "월의 마지막 날은 " + mon +"일 입니다.");
		}
		else {
			System.out.println("1에서 12의 값을 입력해 주세요.");
		}
	}

}
