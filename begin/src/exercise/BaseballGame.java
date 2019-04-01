package exercise;

public class BaseballGame {

	public static void main(String[] args) {

		System.out.println("1 - 9 사이의 숫자 3개를 입력해 주세요.");
		
		// 중복일땐 "중복되지 않는 숫자를 입력해주세요" 출력
		// 중복이 아니면 "게임 시작!!"

		int[] man = new int[3]; // 나의 배열 3개
		int[] com = new int[3]; // 컴의 배열 3개
		
		int strike = 0;
		int ball = 0;
		
		man = new int[] { 3, 6, 9 }; // 내가 선택한 숫자
		System.out.println("{"+man[0]+", "+man[1]+", "+man[2]+"}" + "\n");
		
		if (man[0] == man[1] || man[0] == man[2] || man[1] == man[2]) {
			System.out.println("중복되지 않는 숫자로 입력해 주세요."); return; 		//break 사용 불가, 메소드 멈추고 싶을 때 return
		} else
			System.out.println("게임 시작!" + "\n");

		System.out.println("JAVA BASEBALL GAME");
		System.out.println("------------------");

		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--;
					break;								//중복되지 않는 난수 3개 뽑기
				}
			}
		}
		System.out.print("         " + "컴 vs. 나" + "\n");

		for (int i = 0; i < com.length; i++) {
			java.util.Arrays.sort(com);
			System.out.println("     " + com[i] + "  |  "  + man[i]);	// 컴퓨터 숫자i번째와 내 숫자 i번째 출력
		}
		System.out.println("------------------");
		for (int i = 0; i < man.length; i++) {
			for (int j = 0; j < com.length; j++) {
				if (man[i] == com[j] && i == j) {
					strike++;
					break;
				} else if (man[i] == com[j] && i != j) {
					ball++;
					break;
				}
			}
		}
		
		System.out.println("     "+strike + " strike " +"\n" +"     "+ ball + " ball !!");
		

		
		//새로운 규칙 : 스트라이크 2점, 볼 1점 -> 3스트라이크가 될 때까지 반복
		//			3스트라이크가 됐을 때의 점수와 
		//			3스트라이크가 될 때 까지 몇번 반복했는지 출력
		

	}// End main
}// End class
