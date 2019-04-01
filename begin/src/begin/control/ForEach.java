package begin.control;

public class ForEach {

	public static void main(String[] args) {

		// 값만 갖고와서 뿌리면 될 때는 for each 사용

		String[] subjects = { "JAVA", "JSP", "DB", "HTML" };

		for (int i = 0; i < subjects.length; i++) {
			System.out.print(subjects[i] + "\t");
		}
		System.out.println();
		System.out.println("--------------------------------");

		for (String s : subjects) {
			System.out.print(s + "\t");
		}

		System.out.println();
		System.out.println("--------------------------------");

		//임의의 정수형 배열 i에 
		//1, 3, 5, 7, 9를 저장하고
		//foreach를 이용하여 화면에 출력

		int[] i = {1, 3, 5, 7, 9};
		for (int j : i) {						
			System.out.print(j + "\t");
			
		}
	

	
	}

}
