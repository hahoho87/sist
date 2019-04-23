package view;

import java.util.Scanner;

public class billingManagement {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("----- 예매 관리 -----");
		System.out.println("회원 아이디를 입력해주세요.");
		System.out.print(" >> ");
		String input = scan.nextLine();
		
		
		
		System.out.println("입금 완료 상태로 변경하시겠습니까?");
		System.out.print(">> ( Y  /  N ) : ");
		input = scan.nextLine();
		
		
		System.out.println("변경이 완료되었습니다.");
		System.out.println("계속 하시겠습니까??");
		System.out.println("( N 입력시 상위 메뉴)");
		System.out.print(">> 선택 ( Y  /  N ) : ");
		input = scan.nextLine();
		
		if(input.equals("Y") || input.equals("y")) {
			
			
		} else if(input.equals("N") || input.equals("n")) {
			
		} else {
			System.out.println();
		}
		
		
	}

}
