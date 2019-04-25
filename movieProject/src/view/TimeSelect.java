package view;

import java.util.List;
import java.util.Scanner;

import dao.MovieScheduleDAO;
import vo.MovieScheduleVO;

public class TimeSelect {
	private Scanner scan = new Scanner(System.in);
	private MovieScheduleDAO msdao = new MovieScheduleDAO();
//	MovieSelect movieselect = new MovieSelect();
	SeatReserve seat = new SeatReserve();

	public void list1(int movieID) {
		System.out.println("        <상영 일자 선택>");
		System.out.println("-----------------------------");
		List<MovieScheduleVO> mslist = msdao.date(movieID);
		for (MovieScheduleVO msvo : mslist) {
			System.out.println("                   ▶  " + msvo.getScreenDate() + " ◀");
		}
		System.out.println("-----------------------------");
		System.out.println("(OO/OO/OO 형태로 기입 해주세요)");
		System.out.print(">> 선택 : ");
		String input = scan.nextLine();
		list2(input);
	}
	
	public void list2(String input) {
		System.out.println("        <상영 시간 선택>");
		System.out.println("-----------------------------");
		List<MovieScheduleVO> mslist = msdao.time(input);
		for (MovieScheduleVO msvo : mslist) {
			System.out.println("." + msvo.getScreenDate());
		}
		System.out.println("-----------------------------");
		System.out.println(">> 선택 : ");
//		int input = scan.nextInt();
//		list2(input);
	}

}










