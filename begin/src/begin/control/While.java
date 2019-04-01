package begin.control;

public class While {

	public static void main(String[] args) {
		//반복문 while
		//
		//while(조건식){
		//	반복 처리할 내용들
		//}
		
		//while(true){
		//	무한 반복 처리
		//}
		
		int i = 1;
		
		while (i<=5) {
			System.out.println(i);
			i++;
		}
		
		//1~10 까지 누적 합계를 화면에 출력---왜 안되지???
		
		i = 1;
		int sum = 0;
		sum = sum + i;
		
		while (i<=10) {
			System.out.println(i+" 까지의 합 : " + sum);
			i++;
		}

	}

}
