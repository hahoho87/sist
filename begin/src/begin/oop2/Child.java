package begin.oop2;


//자바의 상속
//클래스 선언 시에 클래스명 뒤에 extends 키워드를 사용하여
//상속 받으려는 클래스명을 명시한다.
//단, 단일 상속만 가능

//Parent 클래스를 상속
public class Child extends Parent {
	private int age;
	
	public void printName()	{
		System.out.println("Child's printName()");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
