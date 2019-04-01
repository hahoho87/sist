package begin.util;

import java.util.ArrayList;
import java.util.List;

public class PetList {

	public static void main(String[] args) {
		//printPet 메소드를 호출하여 반환값을 저장
		List<Pet> petList = addPet();
		//반환값을 화면에 출력
		//애완동물 이름 : ~~
		//애완동물 종류 : ~~
		System.out.println("애완동물 이름 : " + petList.get(0).getName());
		System.out.println("애완동물 종류 : " + petList.get(0).getKind());
		
		System.out.println("====== for ======");
		List<Pet> petLists = addPets();
		for (int i = 0 ; i < petLists.size() ; i++)	{
			Pet pet = petLists.get(i);
			System.out.println("애완동물 이름 : " + pet.getName());
			System.out.println("애완동물 종류 : " + pet.getKind());
		}
		System.out.println("====== for each ======");
		for (Pet p : petLists) {
			System.out.println("애완동물 이름 : " + p.getName());
			System.out.println("애완동물 종류 : " + p.getKind());
		}
		
	}

	private static List<Pet> addPets() {
		//임의의 값으로 Pet 객체 3개를 생성한 후
		//List 객체에 저장한 후 반환
		Pet pet1 = new Pet();
		pet1.setName("Mong");
		pet1.setKind("cat");
		
		Pet pet2 = new Pet();
		pet2.setName("Song");
		pet2.setKind("cow");
		
		Pet pet3 = new Pet();
		pet3.setName("Jong");
		pet3.setKind("dog");
		
		List<Pet> list = new ArrayList<Pet>();
		List<Pet> list1 = new ArrayList<>();

		list.add(pet1);
		list.add(pet2);
		list.add(pet3);
		return list;
		
	}

	private static List<Pet> addPet() {
		Pet pet = new Pet();	//Pet 객체 pet을 생성하여 
		pet.setName("Kong");	//객체의 이름 지정
		pet.setKind("dog");		//객체의 종류 지정
				
		List<Pet> list = new ArrayList<Pet>();
		list.add(pet);	//List에 pet추가	
		return list;	//List의 pet 객체를 반환
		
	}

}
