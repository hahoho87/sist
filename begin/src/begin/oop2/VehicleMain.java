package begin.oop2;

public class VehicleMain {

	public static void main(String[] args) {
		Car car = new Car();
		
		// 속성 4개를 매개변수로 Car 클래스의 객체 c 생성
		Car c = new Car("Bumblebee", false, 0, 4);
		c.setKey(true);
		c.go(5);
		
		
	}

}
