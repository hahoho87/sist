package begin.lang;

import java.awt.Frame;

//Thread 클래스를 상속받는 ThreadExtends 클래스 작성
class ThreadExtends extends Thread {

	// 문자열을 매개변수로 받아서 부모에게 전달하는 생성자 작성
	ThreadExtends(String name) {
		super(name);
	}

	// 스레드로 1 ~ 5 까지 스레드의 이름과 반복 횟수 출력
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			yield();		
			System.out.println(getName() + " : " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}// End ThreadExtends

//Frame 클래스를 상속받고, Runnable 인터페이스를 구현하는
//ThreadRunnable 클래스 작성

class ThreadRunnable extends Frame implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i); // 상속 받은게 Frame이기 때문에 수정

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		ThreadExtends t1 = new ThreadExtends("첫 번째");
		ThreadExtends t2 = new ThreadExtends("두 번째");

		// 스레드 우선순위 지정
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();

//		t1.join(); // join()을 호출한 스레드 종료 시까지
					// 현재 스레드 대기

		ThreadRunnable t3 = new ThreadRunnable();
		ThreadRunnable t4 = new ThreadRunnable();
//		new Thread(t3, "third").start();
//		new Thread(t4, "fourth").start();

		// 현재 실행중인 스레드의 이름 출력
		System.out.println(Thread.currentThread().getName());
		System.out.println("End Main()");

		System.out.println("t1 우선순위 : " + t1.getPriority());
		System.out.println("t2 우선순위 : " + t2.getPriority());

	}// End main

}// End class
