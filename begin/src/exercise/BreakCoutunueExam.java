package exercise;

public class BreakCoutunueExam {

	public static void main(String[] args) {
		// 1-100 사이의 정수 중 가장 큰 7의 배수 출력
		// 출력형태 : 1-100 사이의 정수 중 가장 큰 7의 배수는 ~~~

		// 1부터 가지 말고, 100부터 내려오면서 하나를 찾은 후에 break 걸면 된다.

		for (int i = 100; i >= 1; i--) {
			if (i % 7 == 0) {
				System.out.println("1 ~ 100 사이의 정수 중 가장 큰 7의 배수는 " + i);
				break;
			}
		}
		System.out.println("--------------------------");
		
		//1 - 10 사이의 정수 중에서
		//3. 6. 9를 제외하고 출력
		
		for (int i = 1 ; i <=10 ; i++)	{
			if(i%3==0)	continue;
			System.out.println(i);
		}
		System.out.println();
		
		//1 - 10 사이의 정수 중에서
		//3 ~ 6을 제외하고 출력
		
		for (int i=1 ; i<=10 ; i++)	{
			if((i>=3) && (i<=6))	continue;
			System.out.println(i);
		}
		

	}
}