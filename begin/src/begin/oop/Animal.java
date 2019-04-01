package begin.oop;

public class Animal {

	int age = 1; // 동물의 나이 저장
	String name = "Lion"; // 동물의 이름 저장
	static String food;
	

	// 동물의 이름과 나이를 매개변수로 넘겨 받아
	// 멤버변수를 초기화하고
	// 출력하는 메서드
	public void printAnimal(int age, String name) {
	
		this.age = age;
		this.name = name;

		System.out.println("이름 : " + age);
		System.out.println("나이 : " + name);
	}

}
