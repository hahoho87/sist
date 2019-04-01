package begin.oop2.abst;

public class ShapeMain {

	public static void main(String[] args) {
//		Shape s = new Shape();	//abstract 클래스는 new로 인스턴스 생성 불가
//		Shape s = new ShapeChild();	// 다시 ShapeGrandchild를 상속하기 때문에 이중상속
		Shape s = new ShapeGrandChild(); // 자식 클래스로 생성
		ShapeChild t = new ShapeGrandChild();
			s.draw();
			s.write();	
			t.write();	
			
	}

}
