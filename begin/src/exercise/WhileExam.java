package exercise;

public class WhileExam {

	public static void main(String[] args) {
		//while을 이용하여 10부터 1까지 카운트 다운 하는 프로그램
		//1이 출력 되면 
		//"Fire!!~"을 출력하고 종료
		
		int i=10;
		while (i>=1)	{
			System.out.println(i);
			i--;
			if(i==0)	{
				System.out.println("Fire!!!");
			}
		}

	}

}
