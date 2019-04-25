package view;

import java.util.Scanner;

import vo.CustomerVO;
import vo.TicketingVO;

public class SeatReserve {
	public static String[][] seat = new String[6][11];
	private Scanner scan;
	
	public void selectNum() {
		System.out.println("-----------------------------");
		System.out.println("                        인원 수 선택");
		System.out.println("-----------------------------");
		System.out.println("            [요금]");
		System.out.println("성인 : 10,000원 / 청소년 이하 : 8,000원");
		System.out.println("(숫자만 입력 가능. 선택하지 않을 시 0 기입)");
		System.out.println("-----------------------------");
		
		System.out.print("  성인   : ");
		String adult = scan.nextLine();
		System.out.print("  청소년 이하   : ");
		String child = scan.nextLine();
		
		TicketingVO tvo = new TicketingVO();
		
		
		
		
	}//selectNum

	public void resetSeat() {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 11; j++) {
				seat[i][j] = "___";
			}
		}
	}// resetSeat

	 public void reference(){
	      char row = 'A';
	      for(int i=1; i < 6; i++){
	         System.out.print("\n"+row+"열  ");row++;
	         for(int j=1; j < 11; j++){
	            String seat = (this.seat[i][j].equals("___"))?"◻︎":"◼︎";
	            System.out.print((j)+seat+"  ");
	         }
	      }
	      System.out.println();
	      System.out.println("----------------------------");
	   }//reference
	 
	 
	 public static boolean checkRowCol(int num) {
			if (num <= 0 || num >= 10) {
				return true;
				
			} else {
				return false;
			}
		}
	 

	public static void main() {
		SeatReserve cr = new SeatReserve();
		
		cr.selectNum();
		
		cr.resetSeat();
		int row, col;
		boolean flag = true ;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("-----------좌석 선택-----------");
	    System.out.println("예매를 원하는 좌석을 선택해주세요");
	    System.out.print("----------------------------");
		cr.reference();
		
        do{
            System.out.print("열을 선택하세요(숫자만 입력) > ");
            row = scan.nextInt();
            System.out.print("좌석 번호를 선택하세요(숫자만 입력) > ");
            col = scan.nextInt();
            if(seat[row][col].equals("___")){
              seat[row][col] = "a";
              System.out.println(row + "번째 줄 " + col + "번째 자리가 예약되었습니다.");
              System.out.println();
              flag = false;
            }else if (checkRowCol(row) || checkRowCol(col)) {
    			System.out.println("존재하지 않는 좌석입니다.");
    			return;
    		}else{
              System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
            }
            System.out.print("-----------좌석 확인-----------");
            cr.reference();
        }while(flag);
	}
}






