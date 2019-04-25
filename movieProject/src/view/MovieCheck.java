package view;

import java.util.Scanner;

public class MovieCheck {

	public static void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 예매 내역 확인 ===");
		
		
		System.out.println("1~3번호중에 하나를 선택해주세요.");
		System.out.println("1.예매 현황 2.내가 본 영화 3.예매취소");
		System.out.println(" >> 선택 : ");
		
		switch(sc.nextLine()) {
		case "1" :NowTicket.main(); break;
		case "2" :MyMovie.main(); break;
		case "3" :MovieCancle.main(); break;
		
		}

	}}

	