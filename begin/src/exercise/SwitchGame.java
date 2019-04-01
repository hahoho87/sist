package exercise;

public class SwitchGame {

	public static void main(String[] args) {

		//가위 바위 보 게임 구현
		

		System.out.println("가위 바위 보 게임!!");
		System.out.println("1. 사람 vs 컴퓨터");
		System.out.println("2. 사람 vs 사람(준비중)");
		System.out.println(">> 선택 : 1 " );
		
		int com = (int)(Math.random()*3);			//컴퓨터가 내는 수
		int user = Integer.parseInt(args[0]);		//사람이 내는 수
		
		String[] gababo = {"가위", "바위", "보"};			//user가 0일때 자동으로 가위 꺼내 쓸 수 있도록(?)
		
		String A, B, C;
		A = "가위"; B = "바위"; C = "보";
		
		System.out.println("컴퓨터와 가위 바위 보!");
		System.out.println("(가위 = 0, 바위 = 1, 보 = 2)");
	    System.out.println("--------------------------");

		if(user == 0) System.out.println("you :  "+ A);
		else if (user == 1) System.out.println("you  : "+ B);
		else System.out.println("you :  " + C);
		
		if(com == 0) System.out.println("컴퓨터 : "+ A);
		else if (com == 1) System.out.println("컴퓨터 : "+ B);
		else System.out.println("컴퓨터 : " + C);
		System.out.println("=== 결과 ===");
		
		if(user == com)	{
			System.out.println("비겼습니다.");
		} else if ((user-com==-2) || (user-com==1))	{
			System.out.println("you win!!!");
		} else System.out.println("you lose!!!");
		
	}

}
