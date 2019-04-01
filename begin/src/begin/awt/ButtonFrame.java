package begin.awt;

import java.awt.*;			//awt 패키지 사용
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


//Frame을 상속받아 기본 생성자를 이용하여
//화면에 가로 300, 세로 200 크기의 프레임 작성
//화면의 타이틀은 생성자에서 매개변수로 넘겨받아 
//"버튼 추가"로 지정
//프레임은 창닫기 이벤트 처리
//(단, WindowListener 인터페이스를 구현)

//ActionListener 인터페이스를 구현하여
//버튼이 클릭되면 창닫기 이벤트 처리

class ButtonListener implements ActionListener	{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼이 눌렸습니다");
	}
}//ButtonListener class End 

public class ButtonFrame extends Frame implements WindowListener{

	ButtonFrame(String title) {
		super(title);
		
		//버튼 객체 closeBtn 생성
		Button closeBtn = new Button("close");
		add(closeBtn);	//프레임에 버튼 추가
		closeBtn.addActionListener(new ButtonListener());	// ButtonListener 클래스를 객체로 생성해서 가져옴
		
		setSize(300,200);
		setVisible(true);
		setLocation(300, 200);
		
		
		addWindowListener(this);	//WindowListener를 implement하고 있으니
									//this로 자신을 참조하게 한다
	}

	public static void main(String[] args) {

		new ButtonFrame("버튼 추가!");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
		System.exit(0);		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	


}
