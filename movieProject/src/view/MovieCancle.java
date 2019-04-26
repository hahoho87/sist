package view;

import java.util.List;
import java.util.Scanner;


import vo.MovieCancleVO;
import dao.MovieCancleDAO;

public class MovieCancle {
	
	
	public static void main() {
		
		//현재 예매한 영화목록 출력
		
		MovieCancleDAO cdao = new MovieCancleDAO();
		List<MovieCancleVO> moviecancleList = cdao.moviecancleList();
		
		System.out.println("======= 3.예매 취소 =======");
		System.out.println(" -----예매 취소 가능 영화-----");
		
		for(MovieCancleVO moviecancleVO : moviecancleList) {
			
			System.out.print("예매 번호 : ");
			System.out.println(moviecancleVO.getBookingNO());
			System.out.print("영화 제목 : ");
			System.out.println(moviecancleVO.getMovieTitle());
			System.out.print("관람예정일 : ");
			System.out.println(moviecancleVO.getScreenDate());
			System.out.println("------------------------");
		}
		System.out.print("취소를 진행하시겠습니까? (Y/N) ");
		System.out.println("(N은 상위화면으로 이동)");
		System.out.println(" >> 입력 : ");
			
		Scanner scan = new Scanner(System.in);
		  String input = scan.nextLine();
	         if (input.equals("Y") || input.equals("y")) {
	            MovieCancle2.main();
	         } else if (input.equals("N") || input.equals("n")) {
	           MovieCheck.main();

		
	}
}
}
