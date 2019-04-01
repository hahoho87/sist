package begin.oop2;

//탈것 클래스
public class Vehicle {

	int power; // 속성 1
	String name; // 속성 2
	boolean key; // 속성 3

	public Vehicle() {  // 원래는 자동으로 호출되지만
						// 자식 클래스에서 매개변수 3개를 가져오는
						// 부모 클래스 생성자를 사용하려 했기 때문에
						// 부모 클래스에도 기본생성자를 생성해야 함
		}

	public Vehicle(String name, boolean key, int power) {
		this.power = power;
		this.name = name;
		this.key = key;
	}

	public void go(int power) { // 기능1
		this.power += power;
		System.out.println(name + " 출발!");
	}

	public void stop(int power) { // 기능2
		if (power <= 0) {
			this.power = 0;
			System.out.println(name + " 정지!");
		} else {
			System.out.println();
		}
	}
}// End Vehicle class

//탈 것 클래스를 상속받는 자식 클래스 1
class Car extends Vehicle {
	int wheel; // 추가 속성 1

	public Car() {
		super(); // 명시적으로 호출 했지만, 원래는 묵시적으로 자동 호출
	}

	// 속성 4개를 매개변수로 하는 생성자 작성
	public Car(String name, boolean key, int power, int wheel) {
//		this.name = name;
//		this.key = key;
//		this.power = power;

		// 부모클래스의 생성자에서 받아오기
		// 부모클래스에서 생성자를 새로 만들어 오고 super로 받아온다
		// 부모클래스에 생성자를 새로 만들었기 때문에
		// 부모클래스에도 기본생성자 또한 만들어주어야 한다
		// *부모클래스 Vehicle(){ }
		super(name, key, power);
		this.wheel = wheel;
	}

	public void setKey(boolean key) {// 추가 기능 1
		if (key)
			super.key = true;
		else
			this.key = false;
	}

	// 부모 클래스(Vehicle)의 go 메소드 오버라이딩(재정의)
	public void go(int power) { // 기능1
		// key가 꽂혀 있으면 출발 가능
		// power가 1 이상이어야 출발 가능
		// power가 1 미만이면 출발 불가능

		if (key == true && power >= 1) {
//			this.power += power;
//			System.out.println(name + " 출발!!");
			super.go(power); // 부모의 go메소드를 가져옴
		} else if (!key) {
			System.out.println("키를 꽂아주세요!");
		} else {
			System.out.println("파워를 올려주세요!");
		}
	}
}// End class Car

//탈 것 클래스를 상속받는 자식 클래스 2
class Airplane extends Vehicle {
	int wing; // 추가 속성 1

	public void escape() { // 추가 기능 2

	}
}// End class Airplane
