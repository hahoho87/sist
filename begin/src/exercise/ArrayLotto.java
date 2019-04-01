package exercise;

public class ArrayLotto {

	public static void main(String[] args) {

		// 1.로또 번호 7개를 중복되지 않게 추출하여
		// lottoNums 배열에 저장
		// 2.나의 당첨 여부
		// 6개 일치 : 1등
		// 5개 일치 및 보너스 번호 일치 : 2등
		// 5개 일치 : 3등
		// 4개 일치 : 4등
		// 3개 일치 : 5등

		// 출력 형태
		// 이번 주의 로또 번호 : ~ ~ ~ ~ ~ ~
		// 보너스 번호 : ~
		// 추첨 결과 : ~~

		// 1~45 사이의 로또 번호 7개를 저장할 배열
		int[] lottonums = new int[7];
		int[] myLotto = { 2, 7, 15, 22, 31, 44 };

		for (int i = 0; i < lottonums.length; i++) {
			lottonums[i] = (int) (Math.random() * 45) + 1;
			// int를 붙이기 전에 괄호로 묶어서 먼저 계산한 후에 정수로 변환
			// +1을 해줘야 0이 나오지 않는다
			for (int j = 0; j < i; j++) {
				if (lottonums[i] == lottonums[j]) {
					i--;
					break;
				}
				// 중복 확인

			}
		}
		System.out.print("이번주의 로또 번호 : ");

		for (int i = 0; i < lottonums.length; i++) {
			java.util.Arrays.sort(lottonums); // 오름차순 정렬 //보너스점수가 계속 제일 큰거 질문
			System.out.print(lottonums[i] + "  ");

		}
		System.out.println();
		System.out.println("보너스 번호 : " + lottonums[6]);

		System.out.println();
		for (int i = 0; i < lottonums.length; i++) {
			System.out.printf("%3d", lottonums[i]);
		}

		System.out.println();
		for (int i = 0; i < myLotto.length; i++) {
			System.out.printf("%3d", myLotto[i]);
		}

		int k = 0;
		for (int i = 0; i < lottonums.length; i++) {
			for (int j = 0; j < lottonums.length - 1; j++) {
				if (lottonums[i] == myLotto[j]) {
					k++;
					break;
				}
			}
		}
		System.out.println();
		System.out.println("=== 당첨 결과 ===");
		switch (k) {
		case 6:
			System.out.println("축하합니다. 1등 입니다!");
			break;
		case 5:
			System.out.println("축하합니다. 3등 입니다!");
			for (int i = 0; i < myLotto.length; i++) {
				if (myLotto[i] == lottonums[6])
					System.out.println("축하합니다. 2등 입니다!");
				break;
			}
		case 4:
			System.out.println("축하합니다. 4등 입니다!");
			break;
		case 3:
			System.out.println("축하합니다. 5등 입니다!");
			break;
		default:
			System.out.println("꽝..다음 기회에...");
			break;
		}
		System.out.println("당첨 개수 : " + k + " 개");

	}// End main

}// End class
