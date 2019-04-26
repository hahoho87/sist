package view;

import java.util.List;
import java.util.Scanner;

import common.Exit;
import dao.AdminDAO;
import dao.MovieManageDAO;
import dao.ScheduleManagementDAO;
import vo.MovieScheduleListVO;
import vo.MovieScheduleVO2;
import vo.MovieVO;

public class ScheduleManagementView {
	AdminDAO adminDAO = new AdminDAO();
	MovieManageDAO movieManageDAO = new MovieManageDAO();
	ScheduleManagementDAO scheduleManagementDAO = new ScheduleManagementDAO();
	MovieManagementView movieManage = new MovieManagementView();
	MovieScheduleVO2 msvo2 = new MovieScheduleVO2();
	
	Scanner scan = new Scanner(System.in);

	public void menu() {
		System.out.println();
		System.out.println("------ 상영 정보 관리 ------");
		System.out.println(" 1. 상영 영화 조회");
		System.out.println(" 2. 상영 영화 등록");
		System.out.print(" >> 선택 : ");
		int input = scan.nextInt();
		scan.nextLine();

		while (true) {
			if (input == 1) {
				movieScheduleList();
				movieScheduleSubmenu();
				break;
			} else if (input == 2) {
				movieSchedulRegistList();
				break;
			} else {
				System.out.println("1 혹은 2를 선택해주세요.");
				System.out.print(">> 선택 : ");
				input = scan.nextInt();
				scan.nextLine();
			}
		}
	}// END menu

	public void movieScheduleSubmenu() {
		System.out.println();
		System.out.println("1.변경  2.삭제  3.상위  4.종료");
		System.out.print(">> 선택 : ");
		int input = scan.nextInt();
		scan.nextLine();
		switch (input) {
		case 1:
			movieScheduleUpdate();
			break;
		case 2:
			movieScheduleDelete();
			break;
		case 3:
			menu();
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
	}

	public void movieScheduleUpdate() {		
		System.out.println();
		System.out.println("변경을 원하는 상영 일정 번호를 입력하세요.");
		System.out.print(">> ");
		int screenNo = scan.nextInt();
		scan.nextLine();
		System.out.println("변경할 상영 일자를 입력하세요.(YYMMDD)");
		System.out.print(">> ");
		String date = scan.nextLine();
		System.out.println("변경할 상영 일시를 입력하세요.(HH24:MI)");
		System.out.print(">> ");
		String time = scan.nextLine();
		msvo2 = new MovieScheduleVO2(screenNo, date, time);		
		boolean result = scheduleManagementDAO.movieScheduleUpdate(msvo2);
		if (result == true) {		
			System.out.println();
			System.out.println("변경이 완료되었습니다.");
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 프로그램 종료 )");
			System.out.println(">> 선택 ( Y  /  N ) : ");
			String yes = scan.nextLine();
			if (yes.equals("Y") || yes.equals("y")) {
				menu();
			} else if (yes.equals("N") || yes.equals("n")) {
				Exit.exit();
			} else {
				System.out.println("알맞은 값을 입력하세요.");
//				movieSelect();
			}

		} else {  
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 프로그램 종료 )");
			System.out.println(">> 선택 ( Y  /  N ) : ");
			String yes = scan.nextLine();
			if (yes.equals("Y") || yes.equals("y")) {
				menu();
			} else if (yes.equals("N") || yes.equals("n")) {
				Exit.exit();
			} else {
				System.out.println("알맞은 값을 입력하세요.");
//				movieSelect();
			}
		}
	}

	public void movieScheduleDelete() {
		System.out.println("삭제를 원하는 상영 일정 번호를 입력하세요.");
		System.out.print(">> ");
		int input = scan.nextInt();
		scan.nextLine();
		boolean result = scheduleManagementDAO.scheduleDelete(input);
		if (result == true) {
			System.out.println("삭제 완료");
			System.out.println();
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 프로그램 종료 )");
			System.out.print(">> 선택 ( Y  /  N ) : ");
			String yes = scan.nextLine();
			if (yes.equals("Y") || yes.equals("y")) {
				menu();
			} else if (yes.equals("N") || yes.equals("n")) {
				Exit.exit();
			} else {
				System.out.println("알맞은 값을 입력하세요.");
//				movieSelect();
			}

		} else {  
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 프로그램 종료 )");
			System.out.print(">> 선택 ( Y  /  N ) : ");
			String yes = scan.nextLine();
			if (yes.equals("Y") || yes.equals("y")) {
				menu();
			} else if (yes.equals("N") || yes.equals("n")) {
				Exit.exit();
			} else {
				System.out.println("알맞은 값을 입력하세요.");
//				movieSelect();
			}
		}
	}

	public void movieSchedulRegistList() {
		System.out.println();
		System.out.println("------ 상영 영화 등록 ------");
		System.out.println("영화의 제목을 입력하세요. ");
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

				System.out.println();
				System.out.println("등록할 영화의 ID를 입력하세요.");
				System.out.print(">> 선택 : ");
				int movieID = scan.nextInt();
				scan.nextLine();
				scheduleRegister(movieID);	
			}
		} else {
			System.out.println("DB에 해당 영화가 존재하지 않습니다.");
			System.out.println("등록 하시겠습니까?");
			System.out.println("( N 입력시 상위 메뉴로 이동 )");
			System.out.print(">> 선택 ( Y  /  N ) : ");
			String input = scan.nextLine();

			while (true) {
				if (input.equals("Y") || input.equals("y")) {
					movieManage.movieRegist();
					break;
				} else if (input.equals("N") || input.equals("n")) {
					movieSchedulRegistList();
					break;
				} else {
					System.out.println("Y 혹은 N을 입력해주세요.");
					System.out.print(">> 선택 ( Y  /  N ) : ");
					input = scan.nextLine();
				}
			}
		}
	}// end movieSchedulRegistList
		
	public void movieScheduleList() {
		System.out.println();
		System.out.println("-------- 상영 일정 ------------------------------------------------------------");
		List<MovieScheduleListVO> scheduleList = scheduleManagementDAO.movieScheduleList();

		System.out.println("상영일정번호\t상영일자\t\t시작시간\t\t종료시간\t\t영화ID\t영화제목");

		for (MovieScheduleListVO mslVO : scheduleList) {
			System.out.print(mslVO.getScreenNo());
			System.out.print("\t\t" + mslVO.getScreenDate());
			System.out.print("\t" + mslVO.getScreenTime());
			System.out.print("\t" + mslVO.getScreenEndTime());
			System.out.print("\t" + mslVO.getMovieID());
			System.out.print("\t" + mslVO.getMovieTitle());
			System.out.println();
		}
	}
	
	public void scheduleRegister(int movieID) {
		System.out.println();
		movieScheduleList();
		System.out.println();
		System.out.println("------ 상영 등록 ------");
		System.out.println("상영 일자를 입력하세요.(YYMMDD)");
		System.out.print(">> ");
		String date = scan.nextLine();
		System.out.println("상영 일시를 입력하세요.(HH24:MI)");
		System.out.print(">> ");
		String time = scan.nextLine();
		MovieScheduleVO2 msvo2 = new MovieScheduleVO2(date, time, movieID);
		scheduleManagementDAO.scheduleResister(msvo2);

		if (msvo2 != null) { // 등록 성공
			System.out.println("등록이 완료되었습니다.");
			System.out.println();
			System.out.println("상위메뉴로 이동하시겠습니까?");
			System.out.println("( N 선택시 종료 )");
			System.out.print(">> 선택 ( Y  /  N ) : ");
			String input = scan.nextLine();
			while (true) {
				if (input.equals("Y") || input.equals("y")) {
					menu();
				} else if (input.equals("N") || input.equals("n")) {
					Exit.exit();
				} else {
					System.out.println("Y 혹은 N 을 입력해주세요.");
				}
			}
		}
	}// End movieRegist

	public static void main(String[] args) {
		ScheduleManagementView scheduleManagementView = new ScheduleManagementView();
		scheduleManagementView.menu();
	}

}
