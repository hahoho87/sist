package edu.practice.view;

import java.util.List;
import java.util.Scanner;

import edu.practice.dao.EmpDAO;
import edu.practice.vo.EmpVO;

public class UserMain {
	private EmpDAO edao;
	private Scanner scan;
	private boolean loginChk; // 로그인 여부 확인

	public UserMain() {
		edao = new EmpDAO();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		UserMain umain = new UserMain();
		umain.menu();
	}

	private void menu() {
		System.out.println("-- 사원 관리 시스템 --");
		System.out.println("1.로그인");
		System.out.println("2.사원 등록");
		System.out.println("3.사원 조회");
		System.out.println("4.사원 삭제");
		System.out.println("5.사원 목록");
		System.out.println("6.종료");
		System.out.println(">>선택 : 2");

		loginChk = true; // 로그인 완료 상태로 설정
//		delete();
//		login();
//		select();
//		insert();
//		selectAll();
		close();
	}

	public void close() {
		edao.close();
		scan.close();
		System.out.println(">>시스템 종료");
	}

	public void selectAll() {
		List<EmpVO> empList = edao.selectAll();
		System.out.println("아이디\t이름\t이메일\t직책\t입사일");

		for (EmpVO evo : empList) {
			System.out.print(evo.getEmployeeId());
			System.out.print("\t" + evo.getLastName());
			System.out.print("\t" + evo.getEmail());
			System.out.print("\t" + evo.getJobId());
			System.out.print("\t" + evo.getHireDate());
			System.out.println();
		}
	}

	public void select() {
		System.out.print("조회할 아이디  : ");
		int id = scan.nextInt();
		scan.nextLine();

		EmpVO evo = edao.select(id);
		if (evo != null) { // 조회 성공 //evo의 값을 화면에 출력
			System.out.println("아이디 : " + evo.getEmployeeId());
			System.out.println("이름    : " + evo.getLastName());
			System.out.println("이메일 : " + evo.getEmail());
			System.out.println("입사일 : " + evo.getHireDate());
			System.out.println("직책    : " + evo.getJobId());

			System.out.println("     1.이메일 수정    2.종료");
			System.out.print(">>선택 : ");
			int input = scan.nextInt();
			scan.nextLine();
			if (input == 1) {
				update(id);
			} else if (input == 2) {
				System.out.println(">>시스템 종료");
				// EmpDAO의 close 메서드 호출
			}
		} else { // 조회 실패
			System.out.println("아이디가 없거나 또는 미등록 아이디입니다.");
		}
	}

	public void insert() {
		System.out.println("--- 사원 등록 ---");
		System.out.print("  id   : ");
		String id = scan.nextLine();
		System.out.print("  last_name   : ");
		String lastName = scan.nextLine();
		System.out.print("  first_name   : ");
		String firstName = scan.nextLine();
		System.out.print("  email   : ");
		String email = scan.nextLine();
		System.out.print("  job_id   : ");
		String jobId = scan.nextLine();

		EmpVO evo = new EmpVO(Integer.parseInt(id), lastName, firstName, email, jobId);

		edao.insert(evo);
		if (evo != null) { // 등록 성공
			System.out.println("등록 완료");
		} else { // 등록 실패
			System.out.println("등록 실패 ");
		}
	}

	public void update(int id) {
		if (loginChk == false) {
			System.out.println("로그인 후 이용해주세요.");
			login();
		} else {
			System.out.println(">>변경하실 이메일을 입력해 주세요.");
			System.out.print("email   : ");
			String email = scan.nextLine();

			boolean result = edao.update(id, email);
			if (result == true) { // 변경 성공
				System.out.println("변경 완료");
				// 변경 내용 출력
			} else { // 변경 실패
				System.out.println("변경 실패 ");
			}
		}
	}

	public void delete() {
		if (loginChk == false) {
			System.out.println("로그인 후 이용해주세요.");
			login();
		} else {
			System.out.println(">>삭제할 아이디를 입력해 주세요.");
			System.out.print("  id   : ");
			String id = scan.nextLine();

			boolean result = edao.delete(id);
			if (result == true) { // 삭제 성공
				System.out.println("삭제 완료");
			} else { // 삭제 실패
				System.out.println("삭제 실패 ");
			}
		}
	}

	public void login() {
		System.out.print("  id   : ");
		String id = scan.nextLine();

		System.out.print("  pw(EMAIL):");
		String pw = scan.nextLine();

		boolean result = edao.login(id, pw);
		if (result == true) { // 로그인 성공
			System.out.println("로그인 성공");
			loginChk = true; // 로그인 완료 설정
		} else { // 로그인 실패
			System.out.println("아이디 또는 비밀번호 불일치 또는 미등록 ");
		}
	}

}
