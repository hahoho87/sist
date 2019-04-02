package exercise.net;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JavaChat {
	private String serverIP = "localhost";
	private int serverPort = 5000;
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	private Scanner scan;
	private String nickname = "abc";
	private String msg;
	private BufferedReader reader;
	private FileWriter fw;
	private BufferedWriter bw;

	private TextArea ta;
	Frame f;
	Button clearBtn;
	Button saveBtn;
	TextField tf;
	Label lb;
	Panel p;

	private String filename;
	private String path;

	JavaChat() {
		this.nickname = nickname;

		f = new Frame();
		clearBtn = new Button("clear");
		saveBtn = new Button("save");
		ta = new TextArea();
		tf = new TextField("대화 내용을 입력해 주세요", 30);
		lb = new Label("abc" + " : ", Label.LEFT);
		p = new Panel();

		clearBtn.addActionListener(new EventHandler());

		saveBtn.addActionListener(new EventHandler());

		tf.addMouseListener(new EventHandler());

		tf.addActionListener(new EventHandler());

		tf.addKeyListener(new EventHandler());

		ta.setEnabled(false);// TextArea의 text를 편집하지 못하게 한다.

		p.add(lb); // 패널 컨테이너에 레이블 추가
		p.add(tf); // 패널 컨테이너에 텍스트필드 추가
		p.add(clearBtn); // 패널 컨테이너에 버튼 추가
		p.add(saveBtn); // 패널 컨테이너에 종료 버튼 추가

		f.add(new Label("JAVA CHAT v. 0.1", Label.CENTER), "North");
		f.add(ta, BorderLayout.CENTER);
		f.add(p, BorderLayout.SOUTH);

		f.setTitle("이것이 프레임!!");
		f.setSize(400, 500);
		f.setVisible(true);
		f.setLocation(500, 300);

		// f에 윈도우 리스너 추가 - 창 닫기 처리
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 열어놓은 스트림들 닫기
				try {
					if (scan != null)
						scan.close();
					if (pw != null)
						pw.close();
					if (br != null)
						br.close();
					if (socket != null)
						socket.close();
				} catch (IOException ie) {
					ie.printStackTrace();
				}
				f.dispose();
				System.exit(0);
			}
		});
		doChat();

	}// End 기본 생성자

	private void doChat() { // 채팅 처리 메소드
		try {
			socket = new Socket(serverIP, serverPort);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			// 스캐너가 아니라 tf에 입력된 값을 받아옴

			msg = br.readLine();
			// 서버에서 전송된 메시지가 있으면 추가
			ta.append(msg + "\n");

			while (true) {
				msg = br.readLine();
				if (msg != null || msg.length() > 0) {
					ta.append(msg + "\n");
				} else {
					ta.append("메시지를 입력해주세요.");
				}
				// 서버 메시지 수신
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			System.err.println("서버에 연결되지 않았습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// End doChat();

	// 시간 설정 메소드
	public String getTime() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("[hh:mm:ss]#");
		return simpleDate.format(new Date());
	}

	// 이벤트 처리 클래스
	class EventHandler implements MouseListener, KeyListener, ActionListener {

		// tf에 마우스 리스너 추가
		// 클릭시에
		// 대화 내용이 있으면 내용 지우기
		@Override
		public void mouseClicked(MouseEvent e) {
			tf.setText("");
			tf.requestFocus();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// tf에 키 리스너 추가
			// 대화 내용을 입력하고 엔터키를 치면
			// 대화 내용을 서버에 전송하고
			// 내용 지우기
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				String msg = tf.getText();
				if (msg != null || msg.length() > 0) {
					pw.println(getTime() + nickname + "#" + msg);
					pw.flush();
					tf.setText(""); // tf의 text를 지운다.
					tf.requestFocus();
				} else {
					ta.append("메시지를 입력해주세요");
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
//			e.getSource()		//발생한 이벤트 객체
			if (e.getSource().equals(saveBtn)) {
				// saveBtn에 액션 리스너 추가
				// ta의 내용을 파일로 저장
				// 파일명은 중복되지 않도록 하고, 확장자는 txt로 지정

				FileDialog fd = new FileDialog(f, "파일 저장", FileDialog.SAVE);
				fd.setVisible(true);
				String filepath = fd.getDirectory() + fd.getFile();
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(filepath));
					StringTokenizer st = new StringTokenizer(ta.getText(), "\n");
					while (st.hasMoreTokens()) {
						bw.write(st.nextToken());
						bw.newLine();
					}
					bw.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						if (bw != null)
							bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			} else if (e.getSource().equals(clearBtn)) {
				// clearBtn에 액션 리스너 추가
				// ta의 내용을 지우기
				ta.setText("");
				ta.requestFocus();
			}
		}

	}// End EventHandler

	public static void main(String[] args) {
		new JavaChat();
	}// End main

}// End class