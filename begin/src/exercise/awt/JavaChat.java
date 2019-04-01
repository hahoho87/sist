package exercise.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class JavaChat {
	
	JavaChat(String name){	
		
	Frame f = new Frame();
	Button clearBtn = new Button("clear");
	TextArea ta = new TextArea();
	TextField tf = new TextField("대화 내용을 입력해 주세요", 35);
	Label lb = new Label(name + " : ", Label.LEFT);
	Panel p = new Panel();
	
	//clearBtn에 액션 리스너 추가
		//ta의 내용을 지우기
	clearBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ta.setText("");
		}
	});
	
	//tf에 마우스 리스너 추가
		//클릭시에
		//대화 내용이 있으면 내용 지우기
	tf.addMouseListener(new MouseListener() {
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			tf.setText("");
		}
	});
	
	//tf에 키 리스너 추가
		//대화 내용을 입력하고 엔터키를 치면
		//대화 내용을 ta에 추가하고 내용 지우기
	tf.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
               //TextField에서 Enter를 치면, tf에 입력된  text를 TextArea에 추가한다.
               ta.append(name + " : " + tf.getText() + "\n");
               tf.setText("");     //tf의 text를 지운다.
               tf.requestFocus();
        }
 });

	ta.setEnabled(false);//TextArea의 text를 편집하지 못하게 한다. 
	
	p.add(lb);	//패널 컨테이너에 레이블 추가
	p.add(tf);	//패널 컨테이너에 텍스트필드 추가
	p.add(clearBtn);	//패널 컨테이너에 버튼 추가
	
   	f.add(new Label("JAVA CHAT v. 0.1", Label.CENTER), "North");
   	f.add(ta, BorderLayout.CENTER);
   	f.add(p, BorderLayout.SOUTH);	
   	 
	f.setTitle("이것이 프레임!!");
	f.setSize(400, 500);
	f.setVisible(true);
	f.setLocation(500, 300);
	
	//f에 윈도우 리스너 추가 - 창 닫기 처리
	f.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			f.dispose();
			System.exit(0);
		}
	});
	
	}//End 기본 생성자

	public static void main(String[] args) {
		new JavaChat("abc");
		//센터엔 입력 할 수 없게
		//텍스트필드 -> 클리어버튼 클릭하면 지워지게
	}//End main

}//End class