package begin.oop;

public class AnimalMain {
	
	//Animal 클래스의 참조 변수(객체)를
	//매개변수로 받는 changeName 메서드 작성
	
	public static void changeName(Animal ani)	{
		ani.name = "Kong";
	}

	public static void main(String[] arg) {
		Animal a = new Animal();
		System.out.println(a.age);
		System.out.println(a.name);
		//a.food
		
		Animal.food = "사료";
		
		changeName(a);//changeName method 호출
		System.out.println();
		
		System.out.println("---------------");
		Animal m = new Animal();
		m.printAnimal(7, "Mong");

	}

}
