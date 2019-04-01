package begin.oop;

public class ConstructorCar {
	private String name;
	private String color;
	private int door;

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setdoor(int door) {
		this.door = door;
	}

//	// Constructor
		ConstructorCar() { // 기본생성자 - 클래스 내에 생성자를 전혀 정의하지 않았을 경우에만
//										컴파일러에 의해 자동 추가됨
//										아래에 Constructor(String color) 등으로
//										생성자를 정의 했기 때문에  기본 생성자를 적용하지 않으면
//										에러가 발생
		// 멤버변수의 초기화 - 최초 1회 실행
		// 이름 : 새차, 색 : 회색: 문 : 4개
		name = "newCar";
		color = "Gray";
		door = 4;
	}

	//색상을 매개변수로받아 초기화하는 생성자 오버로딩
	ConstructorCar(String color) {
		this();//기본생성자 호출
		//생성자 내부에서 다른 생성자 호출 가능
		//단, 첫 줄에 표시해야 함
		this.color = color;
		
	}
	
	//멤버변수의 값들을 매개변수로 받아 초기화하는 생성자 오버로딩
	ConstructorCar(String name, String color, int door)	{
		this.name = name;
		this.color = color;
		this.door = door;
	}
	
	

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getDoor() {
		return door;
	}

	// 객체를 문자열로 반환하는 toString 메소드 재정의
	public String toString() {
		return "이름 : " + name + ", 색깔 : " + color + ", 문 개수 : " + door;
	}

}
