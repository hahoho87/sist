package begin.control;

public class ForDouble {

	public static void main(String[] args) {
		// 이중 for문
		// for( 초기식; 조건식; 증감식 ) {
		// for( 초기식; 조건식; 증감식 ) {
		// 반복한 내용들;
		// }
		// }

		for (int i = 1; i <= 5; i++) {
			System.out.println("");
			for (int j = 1; j <= i; j++) { // i의 갯수만큼 찍는것이기 때문에 기준은 i
				System.out.print("*");
			}
		}
		System.out.println();
		System.out.println("-----------------------");

		// A B C D E F
		// G H I J K L
		// M N O P Q R
		// S T U V W X
		// Y Z
		
		char ch = 'A';
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 6; j++) {
				System.out.print(ch++ + " ");
				if (ch > 'Z')	break;
				}
			System.out.println("");
			}
		

	}

}
