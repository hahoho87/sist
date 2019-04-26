package view;

import java.util.Scanner;

import common.Exit;

public class Main {
	private Scanner scan;

	public Main() {
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main user = new Main();
		user.UserSelect();
	}

	private void UserSelect() {
		CustomerLogin customerlogin = new CustomerLogin();
		AdminMenu adminmenu = new AdminMenu();
		
		System.out.println("--------------------------------------");
		System.out.println("     ※ 쌍용영화관에 오신 것을 환영합니다 ※ ");
		System.out.println("--------------------------------------");
//		System.out.println("(관리자이시면 관리자 로그인을, \n  회원이시면 회원 로그인을 선택해주세요.)");
		System.out.println("1.관리자 로그인   2.회원 로그인  3.종료 ");
		System.out.println("--------------------------------------");
		System.out.print(">> 선택 : ");
		int input = scan.nextInt();

		switch (input) {
		
		case 1 : 
			adminmenu.login(); 
			break;
		case 2 :
			customerlogin.select();
			break;
		case 3 :
			System.out.println(">> 프로그램 종료");
			Exit.exit();
		default:
			System.out.println("1 - 3 까지의 숫자를 입력하세요.");
			UserSelect();
		}

	}

}