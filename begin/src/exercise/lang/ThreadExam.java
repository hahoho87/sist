package exercise.lang;

import javax.swing.JOptionPane;

//Thread 클래스를 상속받는 ClassA 작성
class ClassA extends Thread {
	static boolean inputCheck;
//	= false;						//기본이 false이기 때문에 굳이 선언해주지 않아도 가능

	public void run() {
		System.out.println("10초 안에 정답을 입력해 주세요");
		String input = JOptionPane.showInputDialog("자바의 최상위 클래스의 이름은?");

		// 값이 입력되면 inputCheck를 true로 변경
		if (input != null || input.length() > 0) {		//공백이 아니고 값이 입력이 되면
			ClassA.inputCheck = true;					//inputChenk - true
		} else if (input == null || input.length() == 0)	{ 
			System.out.println("값을 입력해 주세요.");
			
		}
		System.out.println("입력 : " + input);

		if (input.equals("Object")) {
			System.out.println("정답입니다!!");
		} else {
			System.out.println("오답입니다...정답은 Object 입니다.");
		}
	}
}

//Runnable 인터페이스를 구현하는 ClassB 작성
class ClassB implements Runnable {

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			if (ClassA.inputCheck == true)
				return;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (ClassA.inputCheck != true) {
			System.out.println("--- Time Out ---");
			System.exit(0);
		}
	}
}
// 스레드로 처리 할 내용
// 1초에 1씩 10 부터 1 까지 카운트다운 형태로 출력하고
// 10초 경과 후에 프로그램 종료

public class ThreadExam {

	public static void main(String[] args) {
		ClassA cA = new ClassA();
		ClassB cB = new ClassB();
		// ClassA, ClassB의 스레드 시작 시키기
		cA.start();
		new Thread(cB).start();

	}// End main

}// End class
