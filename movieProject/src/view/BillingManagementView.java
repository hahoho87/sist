package view;

import java.util.Scanner;

import dao.BillingDAO;
import vo.PaymentVO;

public class BillingManagementView {

	Scanner scan = new Scanner(System.in);
	BillingDAO billingDAO = new BillingDAO();
	
	public void searchBookingNumber() {
		System.out.println("------ 예매 관리 ------");
		System.out.println("예매 번호를 입력하세요.");
		System.out.print(">> ");
		int bookingNo = scan.nextInt();
		scan.nextLine();
		
		PaymentVO pvo = billingDAO.searchBookingNumber(bookingNo);
		
		if(pvo != null) {
			System.out.println("예매번호\t예매일자\t결제여부");
			System.out.println(pvo.getBookingNo());
			System.out.println(pvo.getBookingDate());
			System.out.println(pvo.getPaymentConfirm());
			System.out.println();
			paymentConfirm();
		}
	}
	
	public void paymentConfirm() {
		System.out.println("결제 완료 상태로 변경하시겠습니까?");
		System.out.print(">> ( Y  /  N ) :");
		String yes = scan.nextLine();
		
		while (true) {
			if (yes.equals("Y") || yes.equals("y")) {

			} else if (yes.equals("N") || yes.equals("n")) {

			} else {
				System.out.println("알맞은 값을 입력하세요.");
				paymentConfirm();
			}
		}		
	}



	public static void main(String[] args) {
		BillingManagementView billingManageView = new BillingManagementView();
		billingManageView.searchBookingNumber();
	}

}
