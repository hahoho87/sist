package view;

import java.util.List;
import java.util.Scanner;

import dao.NowTicketDAO;
import vo.NowTicketVO;

public class NowTicket {

	public static void main() {
		
		NowTicketDAO ndao = new NowTicketDAO();
		List<NowTicketVO> nowticketList = ndao.nowticketlist();
		
		
		System.out.println("=== 1.예매 현황 ====");
		for(NowTicketVO nowticketVO : nowticketList) {
			
	
			System.out.print("영화 제목 : ");
			System.out.println(nowticketVO.getMovieTitle());
			System.out.print("관람예정일 : ");
			System.out.println(nowticketVO.getScreenDate());
			
		}
		
		
		
		
		
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("===================");
		System.out.println("원하는 번호를 눌러주세요.");
		System.out.println("1. 상위메뉴로 돌아가기");
		System.out.println("2. 시스템 종료");
		System.out.println("===================");
		System.out.println(" >> 선택 : ");
		
		switch(sc.nextLine()) {
		case "1" : MovieCheck.main(); break;
		case "2" : System.out.println("프로그램 종료"); System.exit(0);
		default : break;
		
		}
		
	}

}
