package exercise;

public class ArrayExam2 {

	public static void main(String[] args) {
		// 번호 JAVA JSP DB HTML 평균
		// 1번 99 90 80 70 ~~.~
		// 2번 88 80 70 60 ~~.~
		// 3번 77 70 60 50 ~~.~
		// -------------------------------------------
		// 평균 ~~.~ ~~.~ ~~.~ ~~.~

		String[] subjects = { "JAVA", "JSP", "DB", "HTML" };
		int[][] scores = { { 99, 90, 80, 70 }, { 88, 80, 70, 60 }, { 77, 70, 60, 50 } };

		int[] sumS = new int[4]; // 과목별 총점

		System.out.print("번호");
		for (int i = 0; i < subjects.length; i++) {
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t" + "평균");

		for (int i = 0; i < scores.length; i++) {
			int sumP = 0; // for문이 시작하고 변수를 저장해야 누적이 안됨
			System.out.print((i + 1) + "번" + "\t");
			for (int j = 0; j < scores[i].length; j++) {

				System.out.print(scores[i][j] + "\t");
				System.out.print("");

				sumP = (sumP + scores[i][j]);

				sumS[j] += scores[i][j]; // 과목별 합계를 sumS 배열에 저장

			}
			System.out.printf("%.2f", (float) sumP / scores[i].length);

			System.out.println();
		}
		System.out.println("----------------------------------------------");
		System.out.print("평균" + "\t");

		
		for (int j = 0; j < 4; j++) { // 4말고 length 쓰는 방법 없는지 질문
			int sumsS = 0;
			for (int i = 0; i < scores.length; i++) {
				sumsS = sumsS + scores[i][j];

			}
			System.out.printf("%.2f \t", (float) sumsS / 3);

		}

	}// End main

}// End class
