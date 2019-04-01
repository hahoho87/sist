package begin.oop2.abst;

//추상 클래스는
//일반적으로 사용할 수 있는 단계가 아닌
//미완성적 틀의 개념
//클래스 선언 시에 abstract 키워드를 명시하고
//
//추상화하고 싶은 메소드에 abstract 키워드를 추가
//구체적인 내용은 상속받는 자식 클래스에서 구현

//new 키워드로 인스턴스 생성 불가
//추상 메소드와 일반 메소드를 가질 수 있음
//abstract로 선언 된 추상메소드는 자식 클래스에서 반드시
//오버라이딩 필요

// 추상 클래스 Shape 
public abstract class Shape {
	// 추상 메소드
	public abstract void draw(); // {} 추상 메소드는 body를 특정하면 안됨
	
	public abstract void write();

	// 일반 메소드
	public void printShape() {
	}
}// End Shape class

abstract class ShapeChild extends Shape {

//	@Override
//	public void draw() {
//		System.out.println("ShapeChild의 draw()");
//	}
	
	//추상메서드 write 작성 - 매개변수 및 반환값 : 없음
	public abstract void write();

}// End ShapeChild class

//ShapeChild를 상속받는 ShapeGrandChild 클래스 작성
	//필요 시 메소드 재정의
class ShapeGrandChild extends ShapeChild	{

	@Override
	public void write() {
		System.out.println("ShapeGrandChild의 Write()");
	}

	@Override
	public void draw() {
		System.out.println("ShpaeChild의 draw()");
	}

	

	
}
