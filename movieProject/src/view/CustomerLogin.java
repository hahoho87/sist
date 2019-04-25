package view;

import java.util.Scanner;

import common.DBconnect;
import dao.CustomerDAO;
import vo.CustomerVO;

public class CustomerLogin {
	private CustomerDAO customerdao;
	private Scanner scan;
	private boolean loginChk;
	private DBconnect dbcon;
	

	public CustomerLogin() {
		customerdao = new CustomerDAO();
		scan = new Scanner(System.in);
	}
	

	
	public void select() {
		System.out.println("-----------------------------");
		System.out.println("                        회원 로그인");
		System.out.println("-----------------------------");
		System.out.println("1.쌍용영화관의 회원이십니까?");
		System.out.println("2.쌍용영화관의 회원이 아니십니까? \n  (회원가입 화면으로 이동합니다.)");
		System.out.println("3.종료");
		System.out.println("-----------------------------");
		System.out.print(">> 선택 : ");
		int input = scan.nextInt();

		switch (input) {
		case 1:
			login();
			break;
		case 2:
			insert();
			break;
		case 3:
			System.out.println(">> 프로그램 종료");
			System.exit(0);
		default:
			break;
		}

	}

	
	public void login() {
		scan = new Scanner(System.in);
		
		System.out.println("-----------------------------");
		System.out.println("                            로그인");
		System.out.println("-----------------------------");
		System.out.print("  ID   : ");
		String id = scan.nextLine();
		System.out.print("  PW   : ");
		String pw = scan.nextLine();

		boolean result = customerdao.login(id, pw);
		if (result == true) { // 로그인 성공
			System.out.println("\n>> 로그인 성공");
			System.out.println("-----------------------------");
			loginChk = true; // 로그인 완료 설정
			menu();
		} else { // 로그인 실패
			System.out.println("아이디 또는 비밀번호 불일치 또는 미등록 ");
			select();
		}
	}
	
	

	public void insert() {// 회원가입
		scan = new Scanner(System.in);
		
		System.out.println("-----------------------------");
		System.out.println("                        회원 가입");
		System.out.println("-----------------------------");
		System.out.print("아이디 : ");
		String customerID = scan.nextLine();
		System.out.print("비밀번호(10자리 이내) : ");
		String customerPW = scan.nextLine();
		System.out.print("이름 : ");
		String customerName = scan.nextLine();
		System.out.print("H.P(숫자만 기입) : ");
		String customerPhone = scan.nextLine();
		System.out.print("생년 월일(숫자만 기입) : ");
		String birth = scan.nextLine();

		CustomerVO cvo = new CustomerVO(customerID, customerPW, customerName, customerPhone, birth);

		boolean result = customerdao.insert(cvo);
		if (result == true) { // 등록 성공
			System.out.println("환영합니다! 쌍용영화관의 회원이 되셨습니다");
			System.out.println("로그인 페이지로 이동합니다.");
			login();
		} else { // 등록 실패
			System.out.println("등록 실패 ");
		}
	}// join()

	public void menu() {
		MovieSelect movieselect = new MovieSelect();
		System.out.println("                        회원 메뉴");
		System.out.println("-----------------------------");
		System.out.println(" 1. 예매 내역 확인");
		System.out.println(" 2. 영화 예매");
		System.out.println();
		System.out.print(">> 선택 : ");
		int input = scan.nextInt();
//		common.DBconnect.getConnection();

		switch (input) {
		case 1:
//			예매 내역 확인();
			break;
		case 2:
//			영화 예매();
			movieselect.main();
			break;
		default:
			System.out.println("1 - 2 까지의 숫자를 입력하세요.");
			menu();
		}
	}

}