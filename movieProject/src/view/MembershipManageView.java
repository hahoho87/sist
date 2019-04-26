package view;

import java.util.List;
import java.util.Scanner;

import common.Exit;
import dao.AdminDAO;
import vo.CustomerVO;

public class MembershipManageView {
	Scanner scan = new Scanner(System.in);
	AdminDAO adminDAO = new AdminDAO();
	AdminMenu adminMenu = new AdminMenu();

	public void membershipManagement() {
		System.out.println();
		System.out.println("------- 회원 관리 -----------------------------------");
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
		System.out.println();
		System.out.println("상위메뉴로 이동하시겠습니까??");
		System.out.println("(N 선택시 시스템 종료)");
		System.out.print(">> 선택 ( Y  /  N ) : ");
		String input = scan.nextLine();
		if (input.equals("Y") || input.equals("y")) {
			adminMenu.menu();
		}
		if (input.equals("N") || input.equals("n")) {
			Exit.exit();
		}
	}
	
	public static void main(String[] args) {
		MembershipManageView mmv = new MembershipManageView();
		mmv.membershipManagement();
	}
}
