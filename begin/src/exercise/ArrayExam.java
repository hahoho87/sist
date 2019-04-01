package exercise;

public class ArrayExam {

	public static void main(String[] args) {
		// 임의의 문자열 배열 strs에
		// java, jsp, db, html을 저장하고
		// 각 값을 화면에 출력

		String[] strs = new String[] { "java", "jsp", "db", "html" };

		for (int i = 0; i < strs.length; i++) { // 배열이름. 입력시 객체의 정보가 화면에 표시.
			System.out.println(strs[i]); 		// length는 배열의 길이
		}
		System.out.println();

		// 임의의 변수 scores에 99, 88, 77, 66, 33
		// === SCORE ===
		// 1번 : 99
		// 2번 : 88
		// 3번 : 77
		// 4번 : 66
		// 5번 : 33
		// -------------
		// 전체 인원 수 : 5
		// 총점 :
		// 평균 :
		// 형식으로 출력

		int[] scores = new int[] { 99, 88, 77, 66, 33 };
		int sum = 0;		// sum을 0으로 초기화 시켜줘야...

		System.out.println("=== SCORE ===");
		for (int i = 0; i < scores.length; i++) {
			System.out.println(i + "번 : " + scores[i] + "점");
			sum += scores[i];
		}
		System.out.println("-----------------");
		System.out.println("전체 인원 수 : " + scores.length);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (float)sum /scores.length);
		System.out.printf("평균 : %.2f" , (float)sum /scores.length);		//printf 는 +대신 콤마 사용
		
		
	}//End main

}//End class