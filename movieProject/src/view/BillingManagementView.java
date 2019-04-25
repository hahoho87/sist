package view;

import java.util.Scanner;

import dao.BillingManageDAO;
import vo.PaymentVO;
import common.Exit;

public class BillingManagementView {
	AdminMenu amenu = new AdminMenu();

	Scanner scan = new Scanner(System.in);
	BillingManageDAO billingDAO = new BillingManageDAO();

	public void searchBookingNumber() {
		System.out.println("------ 예매 관리 ------");
		System.out.println("예매 번호를 입력하세요.");
		System.out.print(">> ");
		int bookingNo = scan.nextInt();
		scan.nextLine();

		PaymentVO pvo = billingDAO.searchBookingNumber(bookingNo);

		if (pvo != null) {
			System.out.println("예매번호\t\t예매일자\t\t결제여부");
			System.out.println("----------------------------------------");
			System.out.print("  " +pvo.getBookingNo());
			System.out.print("\t\t" + pvo.getBookingDate());
			System.out.print("\t" + "   " + pvo.getPaymentConfirm());
			System.out.println();
			paymentConfirm(bookingNo);
		}
	}

	public void paymentConfirm(int bookingNo) {
		System.out.println("결제 완료 상태로 변경하시겠습니까?");
		System.out.print(">> ( Y  /  N ) : ");
		String yes = scan.nextLine();
		boolean result = billingDAO.billingManagement(bookingNo, yes);

		if (result == true) {
			System.out.println("변경이 완료되었습니다.");
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 프로그램 종료 )");
			System.out.println(">> 선택 ( Y  /  N ) : ");
			String input = scan.nextLine();
			if (input.equals("Y") || input.equals("y")) {
				amenu.menu();
			} else if (input.equals("N") || input.equals("n")) {
				Exit.exit();
			} else {
				System.out.println("알맞은 값을 입력하세요.");
				paymentConfirm(bookingNo);
			}

		} else {
			System.out.println("변경 실패");
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 프로그램 종료 )");
			System.out.print(">> 선택 ( Y  /  N ) : ");
			String input = scan.nextLine();
			if (input.equals("Y") || input.equals("y")) {
				amenu.menu();
			} else if (input.equals("N") || yes.equals("n")) {
				Exit.exit();
			} else {
				System.out.println("알맞은 값을 입력하세요.");
				paymentConfirm(bookingNo);
			}
		}
	}

	public static void main(String[] args) {
		BillingManagementView billingManageView = new BillingManagementView();
		billingManageView.searchBookingNumber();
	}

}
