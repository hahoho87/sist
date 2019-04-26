package view;

import java.util.Scanner;

import dao.MovieCancleDAO2;

public class MovieCancle2 {
	public static MovieCancleDAO2 edao;
	private static  Scanner sc;

	public MovieCancle2() {
		edao = new MovieCancleDAO2();
		sc = new Scanner(System.in);

	}

	public static void main() {
		
		edao = new MovieCancleDAO2();
		sc = new Scanner(System.in);
		//
		System.out.println("취소할 영화의 예매번호를 입력하세요.");
		System.out.print(">> 입력  : ");
		
		sc = new Scanner(System.in);

		int select = sc.nextInt();


		boolean result = edao.delete(select);
		
		 System.out.println("--------------------------");
	      
	      
	      
	      Scanner sc = new Scanner(System.in);
	      System.out.println("1. 예매 내역 확인메뉴로 돌아가기");
	      System.out.println("2. 예매하기");
	      System.out.println("3. 시스템 종료");
	      System.out.println(">> 선택 : ");
	      switch(sc.nextLine()) {
	      case "1" : MovieCheck.main(); break;
	      case "2" : MovieSelect.main();
	      case "3" : System.out.println("프로그램 종료"); System.exit(0);
	      default : break;
	      }


	}

}
