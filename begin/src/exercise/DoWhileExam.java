package exercise;

public class DoWhileExam {

	public static void main(String[] args) {
		
		
//		do {
//			System.out.println("게임을m 시작합니다.");
//			System.out.println("게임이 종료되었습니다.");
//			System.out.println("계속하시겠습니까? (y/n)");
			//그냥 진행하면 무한루프
		
		
		char result = 'y';		// 따라서 변수를 하나 지정한 후에						
		do {
			System.out.println("게임을 시작합니다.");
			System.out.println("게임이 종료되었습니다.");
			System.out.println("계속하시겠습니까? (y/n)");
		}while(result == 'y');	// 변수의 조건을 정해주면 제어 가능
		
		

	}

}
