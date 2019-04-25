package view;

import java.util.List;
import java.util.Scanner;

import common.Exit;
import vo.MovieVO;
import dao.AdminDAO;
import dao.MovieManageDAO;

public class MovieManagementView {
	Scanner scan = new Scanner(System.in);
	AdminDAO adminDAO = new AdminDAO();
	MovieManageDAO movieManageDAO = new MovieManageDAO();

	public void movieManagement() {
		System.out.println("------ 영화 관리 ------");
		System.out.println(" 1. 영화 조회");
		System.out.println(" 2. 영화 등록");
		System.out.print(">> 선택 : ");
		int input = scan.nextInt();
		scan.nextLine();

		while (true) {
			if (input == 1) {
				movieSearchList();
				break;
			} else if (input == 2) {
				movieRegist();
				break;
			} else {
				System.out.println("1 혹은 2를 입력해주세요.");
				System.out.print(">> 선택 : ");
				input = scan.nextInt();
				scan.nextLine();
			}
		}
	}// end movieManagement

	public void movieSearchList() {

		System.out.println("찾으실 영화의 제목을 입력하세요.");
		System.out.print(">> ");
		String title = scan.nextLine();

		List<MovieVO> movieList = movieManageDAO.movieSearchList(title);

		if (movieList.size() > 0) {
			System.out.println();
			System.out.println("ID\t영화 제목\t개봉일자");
			System.out.println("---------------------------------");
			for (MovieVO movieVO : movieList) {
				System.out.print(movieVO.getMovieID());
				System.out.print("\t" + movieVO.getMovieTitle());
				System.out.print("\t\t" + movieVO.getMovieOpenday().substring(0, 10));
				System.out.println();
			}
			movieSelect();
		} else {
			System.out.println("DB에 해당 영화가 존재하지 않습니다.");
			System.out.println("등록 하시겠습니까?");
			System.out.println("( N 입력시 영화 검색 메뉴로 이동)");
			System.out.print(">> 선택 ( Y  /  N ) : ");
			String input = scan.nextLine();

			while (true) {
				if (input.equals("Y") || input.equals("y")) {
					movieRegist();
					break;
				} else if (input.equals("N") || input.equals("n")) {
					movieSearchList();
					break;
				} else {
					System.out.println("Y 혹은 N을 입력해주세요.");
					System.out.print(">> 선택 ( Y  /  N ) : ");
					input = scan.nextLine();
				}
			}
		}
	}// end movieSearchList

	public void movieSelect() {
		System.out.println();
		System.out.println("영화의 id를 입력하세요.");
		System.out.print(">> ");
		int movieID = scan.nextInt();
		scan.nextLine();
		MovieVO mvo = movieManageDAO.movieSelect(movieID);

		if (mvo != null) {
			System.out.println();
			System.out.println("ID\t영화 제목\t감독\t배우\t상영등급\t개봉일\t러닝타임\t줄거리");
			System.out.println(
					"-------------------------------------------------------------------------------------------");
			System.out.print(mvo.getMovieID());
			System.out.print("\t" + mvo.getMovieTitle());
			System.out.print("\t" + mvo.getMovieDirector());
			System.out.print("\t" + mvo.getMovieActor());
			System.out.print("\t" + mvo.getMovieAge());
			System.out.print("\t" + mvo.getMovieOpenday().substring(0, 10));
			System.out.print("\t" + mvo.getMovieRunningTime());
			System.out.print("\t" + mvo.getMovieSummary());
			System.out.println();
			System.out.println();
			System.out.println("1.변경  2.삭제  3.상위  4.종료 ");
			System.out.print(">> 선택 : ");
			int input = scan.nextInt();
			scan.nextLine();

//			while (true) {
			switch (input) {
			case 1:
				movieUpdate(movieID);
				break;
			case 2:
				movieDelete(movieID);
				break;
			case 3:
				movieManagement();
				break;
			case 4:
				Exit.exit();
				break;
			default:
				System.out.println("1 - 4 까지의 숫자를 입력하세요");
				System.out.print(">> 선택 : ");
				input = scan.nextInt();
				scan.nextLine();
			}
//			}
		}
	}// END movieSearch

	public void movieDelete(int movieID) {
		boolean result = movieManageDAO.movieDelete(movieID);
		
		if (result == true) {
			System.out.println("삭제 완료");
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 프로그램 종료 )");
			System.out.println(">> 선택 ( Y  /  N ) : ");
			String input = scan.nextLine();
			if (input.equals("Y") || input.equals("y")) {
				movieManagement();
			} else if (input.equals("N") || input.equals("n")) {
				Exit.exit();
			} else {
				System.out.println("알맞은 값을 입력하세요.");
				movieSelect();
			}

		} else {
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 프로그램 종료 )");
			System.out.println(">> 선택 ( Y  /  N ) : ");
			String input = scan.nextLine();
			if (input.equals("Y") || input.equals("y")) {
				movieManagement();
			} else if (input.equals("N") || input.equals("n")) {
				Exit.exit();
			} else {
				System.out.println("알맞은 값을 입력하세요.");
				movieSelect();
			}
		}
	}

	public void movieUpdate(int movieID) {
		boolean result = movieManageDAO.movieDelete(movieID);
		if (result == true) {
			System.out.println("------ 영화 변경 ------");
			System.out.print("  제목   : ");
			String title = scan.nextLine();
			System.out.print("  감독   : ");
			String director = scan.nextLine();
			System.out.print("  주연   : ");
			String actor = scan.nextLine();
			System.out.print("  관람 등급   : ");
			int age = scan.nextInt();
			scan.nextLine();
			System.out.print("  개봉일(숫자만 입력)   : ");
			String openday = scan.nextLine();
			System.out.print("  러닝타임(분)   : ");
			int runningTime = scan.nextInt();
			scan.nextLine();
			System.out.print("  줄거리 (500자 이내)  : ");
			String summary = scan.nextLine();
			MovieVO mvo = new MovieVO(title, director, actor, age, openday, runningTime, summary);

			movieManageDAO.movieRegist(mvo);
			if (mvo != null) { // 등록 성공
				System.out.println("변경이 완료되었습니다.");
				System.out.println("종료 하시겠습니까?");
				System.out.println("( N 선택시 상위메뉴로 이동");
				System.out.print(">> 선택 ( Y  /  N ) : ");
				String input = scan.nextLine();
				while (true) {
					if (input.equals("Y") || input.equals("y")) {
						Exit.exit();
					} else if (input.equals("N") || input.equals("n")) {
						movieManagement();
					} else {
						System.out.println("Y 혹은 N 을 입력해주세요.");
					}
				}
			}
		} else {
			System.out.println("등록 실패");
			System.out.println();
		}
	}

	public void movieRegist() {
		System.out.println("------ 영화 등록 ------");
		System.out.print("  제목   : ");
		String title = scan.nextLine();
		System.out.print("  감독   : ");
		String director = scan.nextLine();
		System.out.print("  주연   : ");
		String actor = scan.nextLine();
		System.out.print("  관람 등급   : ");
		int age = scan.nextInt();
		scan.nextLine();
		System.out.print("  개봉일(숫자만 입력)   : ");
		String openday = scan.nextLine();
		System.out.print("  러닝타임(분)   : ");
		int runningTime = scan.nextInt();
		scan.nextLine();
		System.out.print("  줄거리 (500자 이내)  : ");
		String summary = scan.nextLine();

		MovieVO mvo = new MovieVO(title, director, actor, age, openday, runningTime, summary);

		movieManageDAO.movieRegist(mvo);
		if (mvo != null) { // 등록 성공
			System.out.println("등록이 완료되었습니다.");
			System.out.println("계속 하시겠습니까?");
			System.out.println("( N 선택시 상위메뉴로 이동 )");
			System.out.print(">> 선택 ( Y  /  N ) : ");
			String input = scan.nextLine();
			while (true) {
				if (input.equals("Y") || input.equals("y")) {
					movieRegist();
				} else if (input.equals("N") || input.equals("n")) {
					movieManagement();
				} else {
					System.out.println("Y 혹은 N 을 입력해주세요.");
				}
			}
		}
	}// End movieRegist

	public static void main(String[] args) {
		MovieManagementView movieManage = new MovieManagementView();
		movieManage.movieManagement();
	}

}
