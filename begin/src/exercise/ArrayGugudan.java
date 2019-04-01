package exercise;

public class ArrayGugudan {

	public static void main(String[] args) {
		//프로그램 실행 시 특정 단 수 하나를 입력받아
		//해당 구구단을 출력
		
		int dan = Integer.parseInt(args[0]);	//String을 int로 변환
		
		System.out.println("=== "+ dan +"단 ===" + "\n");

		for (int i = 1; i <= 9; i+=2) {
			int s = dan * i;
			System.out.print(dan + " * " + i + " = " + s + "\t");
			if(i==9) break;
			System.out.print((dan) + " * " + (i+1) + " = " + (s+4) );
			System.out.println();
		}
	}

}
