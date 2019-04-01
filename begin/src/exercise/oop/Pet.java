package exercise.oop;

public class Pet {

	private String name; // 애완동물의 이름
	private String kind; // 애완동물의 종류

	// 이름, 종류를 출력하는
	// printPet method 작성
	
	
	public void setName(String name)	{
		this.name = name;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	public String getName()	{
		return name;
	}
	
	public String getKind()	{
		return kind;
	}
	

	public void printAnimal() {
		System.out.println("애완동물 : " + kind);
		System.out.println("애완동물의 종류 : " + name);
	}

}
