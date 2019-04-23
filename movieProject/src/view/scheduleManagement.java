package view;

import java.util.Scanner;

public class scheduleManagement {

	Scanner scan = new Scanner(System.in);

	public void menu() {
		System.out.println("------ 상영 정보 관리 ------");
		System.out.println(" 1. 상영 영화 조회");
		System.out.println(" 2. 상영 영화 등록");
		System.out.println();
		System.out.print(" >> 선택 : ");
		int input = scan.nextInt();

		while (true) {
			if (input == 1) {
				scheduleSearch();
				break;
			} else if (input == 2) {
				scheduleRegister();
				break;
			} else {
				System.out.println("1 혹은 2를 선택해주세요.");
				System.out.print(">> 선택 : ");
				input = scan.nextInt();
			}
		}
	}// END menu

	public void scheduleSearch() {
		System.out.println("------ 영화 조회 ------");
		System.out.println("영화의 제목을 입력하세요. ");
		System.out.print("Title : ");
		String input = scan.nextLine();
		
		
	}

	public void scheduleRegister() {
		
	}

}
