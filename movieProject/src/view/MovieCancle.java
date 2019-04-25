package view;

import java.util.Scanner;

public class MovieCancle {

	public static void main() {
		System.out.println("=== 3.예매 취소 ===");
		System.out.println("현재 예매한 영화");
		//현재 예매한 영화목록 출력
		
		System.out.println("취소할 영화의 번호를 선택해주세요.");
		//취소번호 입력받기
		System.out.println("---취소가 완료되었습니다.---");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원하는 번호를 눌러주세요.");
		System.out.println("1. 예매 내역 확인메뉴로 돌아가기");
		System.out.println("2. 예매하기");
		System.out.println("3. 시스템 종료");
		switch(sc.nextLine()) {
		case "1" : MovieCheck.main(); break;
		case "2" : MovieSelect.main();
		case "3" : System.out.println("프로그램 종료"); System.exit(0);
		default : break;
		}
	}

}
