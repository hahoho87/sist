package exercise.oop;

public class Person {

	private String name; // 이름
	private int age; // 나이
	private Pet pet; // 애완동물
	
	
	
	// 이름과 나이를 매개변수로 받아 초기화하는
	// 생성자 오버로딩
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Person() {	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public Pet getPet()	{
		return pet;
	}

	// 이름 나이를 출력하는
	// printPerson 작성
	public void printPerson() {

		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);

	}

}
