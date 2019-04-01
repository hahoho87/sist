package begin.oop2;

public class OuterMain {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.InstanceInner instInner = outer.new InstanceInner();
		
		System.out.println("inst's value : " + instInner.inst);
		System.out.println("stat's value : " + Outer.StaticInner.stat);
		outer.outerMethod();	//메소드 안의 클래스 호출
		
		outer.abs.abstMethod();
		
	}

}
