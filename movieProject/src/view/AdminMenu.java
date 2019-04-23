package view;

import java.util.List;
import java.util.Scanner;

import common.DBconnect;
import dao.AdminDAO;
import vo.CustomerVO;

public class AdminMenu {
	private AdminDAO adminDAO;
	private Scanner scan;
	private boolean loginChk;
	private DBconnect dbcon;

	public AdminMenu() {
		adminDAO = new AdminDAO();
		scan = new Scanner(System.in);
//		dbcon = new DBconnect();
	}

	public static void main(String[] args) {
		AdminMenu adminMenu = new AdminMenu();
		adminMenu.login();
	}

	public void login() {
		System.out.println("---- Admin Login ----");
		System.out.print("  id   : ");
		String id = scan.nextLine();
		System.out.print("  pw   : ");
		String pw = scan.nextLine();

		boolean result = adminDAO.login(id, pw);
		if (result == true) { // 로그인 성공
			System.out.println("로그인 성공");
			loginChk = true; // 로그인 완료 설정
			menu();
		} else { // 로그인 실패
			System.out.println("아이디 또는 비밀번호 불일치 또는 미등록 ");
		}
	}

	public void menu() {
		System.out.println(" --- Admin Menu ---");
		System.out.println(" 1. 회원 관리");
		System.out.println(" 2. 영화 관리");
		System.out.println(" 3. 상영 정보 관리");
		System.out.println(" 4. 예매 관리");
		System.out.println();
		System.out.print(">> 선택 : ");
		int input = scan.nextInt();
		common.DBconnect.getConnection();

		switch (input) {
		case 1:
			membershipManagement();
			break;
		case 2:
			movieManagement();
			break;
		case 3:
			scheduleManagement();
			break;
		case 4:
			billingManagement();
			break;
		default:
			System.out.println("1 - 4 까지의 숫자를 입력하세요.");
			menu();
		}
	}

	public void membershipManagement() {
		System.out.println();
		System.out.println("         ------ 회원 관리 ------");
		List<CustomerVO> customerList = adminDAO.customerAll();
		System.out.println("회원번호\t아이디\t이름\t전화번호\t\t생년월일");
		for (CustomerVO customerVO : customerList) {
			System.out.print(customerVO.getCustomerNo());
			System.out.print("\t" + customerVO.getCustomerID());
			System.out.print("\t" + customerVO.getCustomerName());
			System.out.print("\t" + customerVO.getCustomerPhone());
			System.out.print("\t" + customerVO.getCustomerBirth());
			System.out.println();
		}
		System.out.println("상위메뉴로 이동하시겠습니까??");
		System.out.println("(N 선택시 시스템 종료)");
		System.out.print(">> 선택 ( Y  /  N ) : ");
		String input = scan.nextLine();

		if (input == "Y" || input == "y") {
			menu();
		} if (input == "N" || input == "n")	{
//			exit();
		}

	}

	public void movieManagement() {
		System.out.println("------ 영화 관리 ------");

	}

	public void scheduleManagement() {
		System.out.println("------ 상영 정보 관리 ------");

	}

	public void billingManagement() {
		System.out.println("------ 예매 관리 ------");

	}

}
