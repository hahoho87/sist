package begin.lang;

class MoneyBox	{
	//정수형 변수 money를 패키지와 클래스에 구분없이 접근할 수 있도록 선언
	public int money;
}
//Thread 클래스를 상속받는 MoneyMoa 클래스 작성
class MoneyMoa extends Thread	{
	//MoneyBox 클래스의 참조 변수를 타 클래스에서는 접근 할 수 없도록 선언
	private MoneyBox mBox;
	
	public MoneyBox getmBox() {
		return mBox;
	}

	public void setmBox(MoneyBox mBox) {
		this.mBox = mBox;
	}

	//이름과 MoneyBox 객체를 매개변수로 받아서
	MoneyMoa(String name, MoneyBox mBox){
		//이름은 부모의 생성자에게 전달하고
		//MoneyBox 객체는 멤버변수를 초기화하는 생성자 작성
		super(name);
		this.mBox = mBox;
		
	}//End 생성자
	
	//스레드로 실행할 내용
	//MoneyBox의 값을 1 ~ 10까지 1씩 증가 시키고
	//스레드의 이름과 함께 출력
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			synchronized (this.mBox) {
				System.out.println(getName() + " : " + ++mBox.money);
			}
		}
	}//End run
	
}//End MoneyMoa

public class ThreadSync {

	public static void main(String[] args) {
		//MoneyBox 클래스의 인스턴스 m 생성
		MoneyBox m = new MoneyBox();
		
		//MoneyMoa 클래스의 tom, jane 생성
		MoneyMoa tom = new MoneyMoa("Tom", m);
		MoneyMoa jane = new MoneyMoa("Jane", m);
		
		tom.start();
		jane.start();

	}
}
