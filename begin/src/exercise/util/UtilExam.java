package exercise.util;

import java.util.*;

public class UtilExam {

	public static void printCapital(String country)	{
		//대한민국, 캐나다, 영국, 일본, 중국의 나라 이름을 키로하고
		//각 수도를 값으로 갖는 Map 객체를 생성
		Map<String , String> capital = new HashMap<>();
		capital.put("대한민국", "서울");
		capital.put("캐나다", "오타와");
		capital.put("영국", "런던");
		capital.put("일본", "도쿄");
		capital.put("중국", "베이징");
		
		//메인 메소드 실행 시 (run configuration) 명령형 매개변수로 입력된 나라를
		//매개변수로 넘겨받아 해당 국가의 수도를 출력

		//단, 국가 이름이 입력되지 않은 경우
		//이 메서드를 호출하지 않고 다음을 출력
		//"국가명을 입력해 주세요" 출력
		
		//키가 존재하는 경우
		//국가 : ~~~
		//수도 : ~~~
		
		//키가 존재하지 않는 경우
		//입력하신 국가는 등록되어 있지 않습니다.
		if (capital.containsKey(country)==true) 	{
			System.out.println("국가 : " + country);
			System.out.println("수도 : " + capital.get(country));
		} else { System.out.println("입력하신 국가는 등록되어 있지 않습니다.");
		}
	}//End printCapital 

	public static void main(String[] args) {
		if (args.length < 1)	{
			System.out.println("국가명을 입력해주세요.");
		} else	{
		printCapital(args[0]);
		}

	}//End main

}//End class
