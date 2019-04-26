package view;

import java.util.List;
import java.util.Scanner;

import dao.HistoryDAO;
import vo.HistoryVO;

public class MyMovie {

   public static void main() {
	   HistoryDAO hdao = new HistoryDAO();
	   List<HistoryVO> historyList = hdao.historylist();
      System.out.println("==== 2.내가 본 영화 ====");
      
      for (HistoryVO historyVO : historyList) {
    	  System.out.print("영화 제목 : ");
    	  System.out.println(historyVO.getMovieTitle());
    	  System.out.print("관람일 :\t ");
    	  System.out.println(historyVO.getScreenDate());
    	  
      }    
      
      System.out.println("==================");
      
      Scanner sc = new Scanner(System.in);
      
      System.out.println("원하는 번호를 눌러주세요.");
      System.out.println("1. 상위메뉴로 돌아가기");
      System.out.println("2. 시스템 종료");
      System.out.println(">> 선택 : ");
      switch(sc.nextLine()) {
      case "1" : MovieCheck.main(); break;
      case "2" : System.out.println("프로그램 종료"); System.exit(0);
      default : break;
      }

   }

}