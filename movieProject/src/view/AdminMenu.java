package view;

import java.util.Scanner;

import dao.AdminDAO;

public class AdminMenu {
	private AdminDAO adminDAO;
	private Scanner scan;

	public AdminMenu() {
		adminDAO = new AdminDAO();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		AdminMenu adminMenu = new AdminMenu();
		adminMenu.login();
	}

	public void login() {
		System.out.println();
		System.out.println("---- Admin Login ----");
		System.out.print("  id   : ");
		String id = scan.nextLine();
		System.out.print("  pw   : ");
		String pw = scan.nextLine();

		boolean result = adminDAO.login(id, pw);
		if (result == true) { // 로그인 성공
			System.out.println("로그인 성공");
			menu();
		} else { // 로그인 실패
			System.out.println("아이디 또는 비밀번호 불일치 또는 미등록 ");
			login();
		}
	}

	public void menu() {
		System.out.println();
		System.out.println(" --- Admin Menu ---");
		System.out.println(" 1. 회원 관리");
		System.out.println(" 2. 영화 관리");
		System.out.println(" 3. 상영 정보 관리");
		System.out.println(" 4. 예매 관리");
		System.out.print(">> 선택 : ");
		int input = scan.nextInt();
		common.DBconnect.getConnection();

		switch (input) {
		case 1:
			MembershipManageView.main(null);
			break;
		case 2:
			MovieManagementView.main(null);
			break;
		case 3:
			ScheduleManagementView.main(null);
			break;
		case 4:
			BillingManagementView.main(null);
			break;
		default:
			System.out.println("1 - 4 까지의 숫자를 입력하세요.");
			menu();
		}
	}
}
