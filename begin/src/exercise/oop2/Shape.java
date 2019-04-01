package exercise.oop2;

public class Shape {
	String tool;
	String name;

	public void drawShape() {
		System.out.println("Shape's drawShape()");
	}

}// End class

//Shape class를 상속받는 ShapeCircle class 작성
class ShapeCircle extends Shape {
	// 3.14를 클래스 외부에서 접근할 수 없는 상수로 선언하고 초기화
	private final double PI = 3.14;

	// name과 tool을 매개변수로 넘겨받아 초기화하는 생성자 작성
	public ShapeCircle(String name, String tool) {
		this.name = name;
		this.tool = tool;
	}
	// 부모 클래스의 메소드를 오버라이딩하여
	// "ShapeCircle이 ~~~(툴)로 ~~~~(이름)을 그리다" 출력
	public void drawShape() {
		System.out.println(tool + "로 " + name + "을 그리다.");
	}

	// 원의 면적을 구하는 공식을 출력하는 drawCircleFormula 메소드 작성
	public void drawCircleFormula() { // 원의 넓이
		System.out.println("원의 면적 : 반지름 * 반지름 * " + PI);
	}

}// End ShapeCircle

// Shape 클래스를 상속받는 ShapeRectangle 클래스 작성
class ShapeRectangle extends Shape {
	// 사각형의 가로, 세로의 값을 정수로 넘겨받아 초기화하는 생성자 작성
	public ShapeRectangle() {
	}

	public ShapeRectangle(String name, String tool) {
		this.name = name;
		this.tool = tool;
	}

	// 부모 클래스의 메소드를 오버라이딩하여
	// "ShapeCircle이 ~~~(툴)로 ~~~~(이름)을 그리다" 출력
	public void drawShape() {
		System.out.println(tool + "로 " + name + "을 그리다.");
	}

	// 사각형의 넓이를 구하는 공식을 출력하는 drawRectangleFormula 메소드 작성
	public void drawRectangleFormula() { // 원의 넓이
		System.out.println("사각형의 면적 : 가로 * 세로 ");
	}

}// End ShapeRectangle
