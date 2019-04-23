package view;

import java.util.List;
import java.util.Scanner;

import vo.CustomerVO;
import vo.MovieVO;
import dao.AdminDAO;

public class MovieManagement {
	private Scanner scan = new Scanner(System.in);
	private AdminDAO adminDAO;	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		MovieManagement movieManage = new MovieManagement();
		System.out.println("------ 영화 관리 ------");
		System.out.println(" 1. 영화 조회");
		System.out.println(" 2. 영화 등록");
		System.out.print(">> 선택 : ");
		int input = scan.nextInt();

		while (true) {
			if (input == 1) {
				movieManage.movieSearch();
				break;
			} else if (input == 2) {
				movieManage.movieRegist();
				break;
			} else {
				System.out.println("1 혹은 2를 입력해주세요.");
				System.out.print(">> 선택 : ");
				input = scan.nextInt();
			}
		}
	}

	public void movieSearch() {
		List<MovieVO> movieList = adminDAO.movieSearch();
		System.out.println("영화id\t영화 제목\t개봉일자");
		for (MovieVO movieVO : movieList) {
			System.out.println(movieVO.getMovieID());
			System.out.println(movieVO.getMovieTitle());
			System.out.println(movieVO.getMovieOpenday());
			System.out.println();
		}
		
	}

	public void movieRegist() {

	}
}
