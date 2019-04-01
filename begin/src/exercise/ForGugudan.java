package exercise;

public class ForGugudan {

	public static void main(String[] args) {
		// for문을 이용하여 구구단 출력
		
		

		int dan = 5;
		System.out.println("구구단 " + dan + "단을 출력합니다.");

		for (int i = 1; i <= 9; i++) {
			int s = dan * i;
			System.out.println(dan + " * " + i + " = " + s);
		}

		// 이중 for문을 사용하여 구구단 출력

		for (int i = 2; i <= 9; i++) {
			System.out.println("=== " + i + "단 ===");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}

		// 2 3 4 5
		// 6 7 8 9 단 형식으로 만들기

		for (int i = 2; i <= 9; i += 4) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " * " + j + " = " + i * j);
				System.out.print("\t");
				System.out.print((i + 1) + " * " + j + " = " + ((i + 1) * j));
				System.out.print("\t");
				System.out.print((i + 2) + " * " + j + " = " + ((i + 2) * j));
				System.out.print("\t");
				System.out.print((i + 3) + " * " + j + " = " + ((i + 3) * j));
				System.out.println();
			}
			System.out.println();
		}
		
		
	} // End Main

} // End Class
