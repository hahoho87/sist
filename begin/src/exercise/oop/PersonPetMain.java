package exercise.oop;

public class PersonPetMain {

	public static void main(String[] args) {
		// 이름은 Kim 나이는 20
		// 애완동물의 이름은 Mong
		// 종류는 고양이의 정보를 갖는 객체 k 생성
		Person k = new Person();
		
		k.setName("Kim");
		k.setAge(20);
		k.setPet(new Pet());
		k.getPet().setKind("고양이");
		k.getPet().setName("Mong");
		
		k.printPerson();
		k.getPet().printAnimal();
		
//		k.name = "Kim";
//		k.age = 20;
//		k.pet = new Pet();
//
//		k.pet.kind = "고양이";
//		k.pet.name = "Mong";

		// 이름은 Lee 나이는 30
		// 애완동물의 이름은 Kong
		// 종류는 강아지의 정보를 갖는 참조 변수 lee 생성
		Person lee = new Person();
//		lee.name = "Lee";
//		lee.age = 30;
//		lee.pet = new Pet();
//
//		lee.pet.kind = "강아지";
//		lee.pet.name = "Kong";
//
//		// k와 lee를 이용하여 각각 print method 호출
//		k.printPerson();
//		k.pet.printAnimal();
//		System.out.println();
//		lee.printPerson();
//		lee.pet.printAnimal();

	}

}
