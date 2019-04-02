package exercise.net;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;


public class MultiClient {
	private String serverIP = "localhost";
	private int serverPort = 5000;
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	private TextArea ta;
	private TextField tf;
	private Button clearBtn;
	private Button saveBtn;
	private String nickname;
	private Frame f;

	public MultiClient(String nickname) {
		this.nickname = nickname;

		f = new Frame("JAVA CHAT PROGRAM v. 01");
		ta = new TextArea();
		Panel p = new Panel();
		Label lb = new Label(nickname + " : ");
		tf = new TextField("대화 내용을 입력해주세요.", 30);
		clearBtn = new Button("CLEAR");
		saveBtn = new Button("SAVE");

		// clearBtn에 액션 리스너 추가
		clearBtn.addActionListener(new EventHandler());

		// saveBtn에 액션 리스너 추가
		saveBtn.addActionListener(new EventHandler());

		// tf에 마우스 리스너 또는 액션 리스너 추가
		tf.addMouseListener(new EventHandler());

		// tf에 키 리스너 추가
		tf.addKeyListener(new EventHandler());

		p.add(lb);
		p.add(tf); // 패널 컨테이너에 텍스트필드 추가
		p.add(clearBtn); // " 버튼 추가
		p.add(saveBtn); // " 버튼 추가

		f.setSize(500, 400);
		f.setLocation(200, 200);
		f.setVisible(true);

		f.add(new Label("welcome! let's chat", Label.CENTER), "North");
		f.add(ta, "Center");
		f.add(p, "South");

		// f에 윈도우 리스너 추가 - 창닫기 처리
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 열어놓은 스트림들 닫기
				try {
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
	}// END 생성자

	// 이벤트 처리 클래스
	class EventHandler implements MouseListener, KeyListener, ActionListener {
		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// tf 클릭 시에 대화 내용이 있으면 지우기
			tf.setText("");
			tf.requestFocus();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// 대화 내용을 입력하고 엔터 키를 치면
			// 서버로 대화 내용을 전송하고 내용 지우기
			// 엔터키가 입력이 되면
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				String msg = tf.getText(); // 입력값 가져오기
				if (msg.length() > 0 || msg != null) {
					pw.println(getTime() + "#" + nickname + "#" + msg);
					pw.flush();
					tf.setText("");
					tf.requestFocus();
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
			Object btn = e.getSource(); // 발생한 이벤트 객체 받아오기
			if (btn == clearBtn) { // clearBtn이 눌린 경우
				ta.setText(""); // ta의 내용을 지우기
			}
			if (btn == saveBtn) { // saveBtn이 눌린 경우
				// ta의 내용을 파일로 저장
				// 파일명은 중복되지 않도록 하고, 확장자는 txt로 지정
				FileDialog fd = new FileDialog(f, "파일 저장", FileDialog.SAVE);
				fd.setVisible(true);
				String filePath = fd.getDirectory() + fd.getFile();
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(filePath));
					StringTokenizer st = new StringTokenizer(ta.getText(), "\n");
					while (st.hasMoreElements()) {
						bw.write(st.nextToken());
						bw.newLine();
					}
					bw.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (bw != null)
							bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

	}// END EventHandler

	// 채팅 처리 메서드
	private void doChat() {
		try {
			socket = new Socket(serverIP, serverPort);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			// 서버로 닉네임 전송
			
			pw.println(nickname);
			pw.flush();

			while (true) {
				String msg = br.readLine();
				if (msg.length() > 0 || msg != null) {
					// 서버에서 전송된 메시지가 있으면 추가
					ta.append(msg + "\n");
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			System.err.println("서버에 연결되지 않았습니다.");
		} catch (SocketException e) {
			System.err.println("서버와의 연결이 종료되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} // END try
	}// END doChat()

	// 시간 설정 메서드
	public String getTime() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("[hh:mm:ss]");
		return simpleDate.format(new Date());
	}// END getTime()

	public static void main(String[] args) {
		new MultiClient("bb");
	}

}
