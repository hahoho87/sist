package exercise.oop2;

public class ShapeMain {

	public static void main(String[] args) {
		// Shape 클래스의 인스턴스 shape 생성
		Shape shape = new Shape();

		// 원, 브러쉬를 매개변수로 ShapeCircle 클래스의 참조변수 circle 생성
		Shape circle = new ShapeCircle("원", "브러쉬");
		// 사각형, 연필을 매개변수로 ShapeRectangle 클래스의 객체 rect 생성
		Shape rect = new ShapeRectangle("사각형", "연필");
		// 위에서 생성한 변수들을 이용하여 각각
		shape.drawShape(); // Shape 클래스의 drawShape 메소드 호출
		circle.drawShape(); // ShapeCircle 클래스의 오버라이딩 메소드 호출
		rect.drawShape(); // ShapeRectangle 클래스의 오버라이딩 메소드 호출

		System.out.println("UP casting-----------");
		shape = circle;
		shape.drawShape();

		shape = rect;
		shape.drawShape(); // 물려준거라 쓸 수 있다
//		shape.drawCircleFormula();	// 물려주지 않아서 쓸 수 없다

		System.out.println("DOUN casting---------");

//		circle = (ShapeCircle) new Shape();	// 자식을 부모로 사용할 수 없다

	}// End main

}// End class
