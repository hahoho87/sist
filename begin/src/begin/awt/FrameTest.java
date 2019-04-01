package begin.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ButtonPrintListener implements ActionListener	{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼이 눌렸습니다.");
	}
}

//Frame을 상속
public class FrameTest extends Frame{

//	FrameTest() { // 기본 생성자를 오버로딩 하여
//		super("프레임 상속 완료!!"); // 가로 300, 세로 300 크기의 프레임을 작성하고
//		setSize(300, 300); // 화면에 표시
//		setVisible(true); // 단, 프레임의 타이틀은
//		setLocation(300, 200); // "프레임 상속 완료!!"로 표시
//
//		// 창닫기 이벤트 처리
//		addWindowListener(new WindowListener() {
//
//			@Override
//			public void windowOpened(WindowEvent e) {
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e) {
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//			}
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				dispose();
//				System.exit(0);
//			}
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//			}
//
//			@Override
//			public void windowActivated(WindowEvent e) {
//			}
//		});
//
//	}

	public static void main(String[] args) {
		// 현재 클래스의 기본 생성자 호출
//		new FrameTest();
				
		new ButtonListener();
		
		Frame f = new Frame();
		Button n = new Button("N");
		n.addActionListener(new ButtonListener());
		Button w = new Button("W");
		w.addActionListener(new ButtonListener());
		Button c = new Button("C");
		c.addActionListener(new ButtonListener());
		Button e = new Button("E");
		e.addActionListener(new ButtonListener());
		Button s = new Button("clear");
		s.addActionListener(new ButtonListener());
		
		
		TextArea ta = new TextArea();
		TextField tf = new TextField("여기는 텍스트필드");
		Label lb = new Label("ID : " );
		Panel p = new Panel();
		
		p.add(lb);	//패널 컨테이너에 레이블 추가
		p.add(tf);	//패널 컨테이너에 텍스트필드 추가
		p.add(s);	//패널 컨테이너에 버튼 추가
		
	   	f.add(new Label("JAVA CHAT v. 0.1", Label.CENTER), "North");
	   	f.add(ta, BorderLayout.CENTER);
	   	f.add(p, BorderLayout.SOUTH);	//프레임의 남쪽에 패널추가
//	   	f.add(e, BorderLayout.EAST);
//	   	f.add(w, BorderLayout.WEST);
	   	 
		f.setTitle("이것이 프레임!!");
		f.setSize(300, 200);
		f.setVisible(true);
		f.setLocation(300, 200);
		// windowAdapter클래스를 익명으로 구현하여
		// 창닫기 이벤트 처리
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
				System.exit(0);
			}
		});
		

	}

	
}
