package begin.awt;


import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LambdaFrame {

	public static void main(String[] args) {
		// 가로 200, 세로 200 크기의
		// 타이틀이 "Lambda"인 프레임을 만들어서
		// 바탕화면은 분홍색으로 설정하고
		// "OK"라는 라벨의 버튼을 추가하여
		// 화면에 표시
		// 단, 프레임과 버튼 모두 창닫기 이벤트 구현

		Frame f = new Frame("Lambda!");
		Button b = new Button("OK");
		
		//버튼 액션 이벤트 처리
//		b.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				f.dispose();
//				System.exit(0);
//			}
//		});
		
		//람다식으로 변환 1.
//		b.addActionListener((ActionEvent e)-> {System.exit(0);}	);
		
		//람다식으로 변환 2.
//		b.addActionListener((e)-> {System.exit(0);}	);
		
		//람다식으로 변환 3.
		b.addActionListener(e-> System.exit(0));

		f.add(b); // 프레임에 버튼 추가
		b.setSize(3, 5);		//버튼 크기 조정
		b.setLocation(75, 75);	//버튼 위치 조정
		

	    f.setSize(500, 300);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
				System.exit(0);
			}
		});
		f.setBackground(Color.PINK);
		f.setLocation(200,300);
	}

}
