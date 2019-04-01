package begin.control;

public class BreakContinue {

	public static void main(String[] args) {
		//반복문에서 continue문
		//continue 이하를 수행하지 않고
		//다음 회차의 반복을 수행
		//주로 for 문에서 사용

		for (int i = 0; i <= 4; i++) {
			if (i == 2)		continue;	//2면 출력하지 않고 다시 위로 올라가서 i++
			System.out.println(i);
		}
		System.out.println("-------------------");
		
		
		// 반복문에서 break문
		// 가장 가까운 반복문을 종료할 때 사용
		// label을 사용하면
		// 중첩된 반복문에서 지정한 반복문을 종료가능

		for (int i = 0; i <= 4; i++) {
			System.out.println(i);
			if (i == 2)
				break;
		}
		System.out.println("-------------------");

		// 1
		// 12
		// 123
		// 1234
		// 12345

		OUTER:
		for (int i = 1; i <= 5; i++) {
			
			INNER:
			for (int j = 1; j <= i; j++) { // i의 갯수만큼 찍는것이기 때문에 기준은 i
				System.out.print(j);
				if(i==3)	break OUTER;	//여기서 break를 걸면 세번째줄만 break 걸림
									//따라서 두번째 for문 밖에서 break를 걸어주거나
									//라벨을 달아준다
			}
//			if(i==3)	break;
			System.out.println("");
			
		}
	}

}
