package edu.practice.view;

import java.util.Scanner;

import edu.practice.dao.EmpDao;

public class UserMain {
	private EmpDao edao;
	private Scanner scan;
	private boolean loginChk; //로그인 여부 확인
	
	public UserMain() {
		edao = new EmpDao();
		scan = new Scanner(System.in);
	}
	
	private void menu() {
		System.out.println("-- 사원 관리 시스템 --");
		System.out.println("1.로그인");
		// ID는 email PW는 employee_id
		System.out.println("2.사원 등록");
		System.out.println("3.사원 조회"); // 정보 변경 추가
		System.out.println("4.사원 삭제");
		System.out.println("5.사원 목록");
		System.out.println("6.종료");
		System.out.println(">> 선택 : 4");
		
		loginChk = true;	//로그인 완료 상태로 임의 설정
		delete();
//		login();
		
	}
	public static void main(String[] args) {
		UserMain umain = new UserMain();
		umain.menu();
	}// main end
	
	public void login() {
		System.out.print("  id   : ");
		String id = scan.nextLine();
		
		System.out.print("  pw(EMAIL): ");
		String pw = scan.nextLine();
		
		boolean result = edao.login(id, pw);
		if (result == true)	{	//로그인 성공
			System.out.println("로그인 성공");
			loginChk = true;	//로그인 완료 설정
		} else {
			System.out.println("아이디 또는 비밀번호 불일치 or 미등록 ");
		}
	}

	
	private void delete() {
		if(loginChk == false) {
			System.out.println("로그인 후 이용해주세요.");
			login();
		} else {
			//삭제할 아이디를 입력 받아
			//
			System.out.println("삭제할 사원의 id를 입력해주세요.");
			System.out.print("  id   : ");
			String id = scan.nextLine();
			
			
		}
		
	}
}// class end
