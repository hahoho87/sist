package exercise.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiServer {
	private Socket socket; // 클라이언트 소켓
//	private BufferedReader br;	//클라이언트의 메시지 읽기
//	private PrintWriter pw;		//클라이언트에게 메시지 쓰기 
	private ServerSocket serverSocket;
	private Map<String, PrintWriter> clientMap; // 0.
	private String nickname;

	public MultiServer() {
		clientMap = new HashMap<String, PrintWriter>();
		// 1. clientMap 동기화 처리
		Collections.synchronizedMap(clientMap);

		int port = 5000;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("=== this is server ===");
			while (true) {
				socket = serverSocket.accept();
				System.out.println(">> 클라이언트 접속!!");
				System.out.println(">> IP  :" + socket.getInetAddress());
				System.out.println(">> REMOTE IP : " + socket.getPort());

				// 2. ServerThread 클래스의 객체 생성
				ServerThread st = new ServerThread();
				st.start(); // 접속한 클라이언트 스레드 처리 시작
			} // END while
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// END 생성자

	// 3.Thread 클래스 상속
	class ServerThread extends Thread {
		private BufferedReader br;
		private PrintWriter pw;

		public ServerThread() { // 4.기본 생성자 작성
			try { // 각 클라이언트에서 사용할 스트림 생성
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				// 서버 접속 안내 메시지를 클라이언트로 전송
				pw.println(getTime() + " 서버에 접속되었습니다. ");
				pw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// END 생성자

		// 5.스레드로 처리할 내용
		@Override
		public void run() {
			try {
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				nickname = br.readLine();
				broadcast(nickname + "님이 접속하셨습니다.");
				// 닉네임을 키로, pw를 값으로 맵에 클라이언트 저장
				clientMap.put(nickname, pw);
				// 클라이언트 입장 안내 메시지 출력
				// 클라이언트의 데이터를 읽어서
				// 전체 클라이언트에게 전송
				// 클라이언트 퇴장 안내 메시지 출력
				String line = null;
				while ((line = br.readLine()) != null) {
					String[] msgs = line.split("#");
//					broadcast(nickname + " : " + line);
					broadcast(getTime() + " " + msgs[1] + " > " + msgs[2]);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				clientMap.remove(nickname);
				broadcast(nickname + "님이 접속을 종료했습니다.");
				try {
					if (socket != null) {
						socket.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}// END class ServerThread

	public void broadcast(String msg) { // 전체 발송 메시지
		synchronized (clientMap) {
			Collection<PrintWriter> collection = clientMap.values();
			Iterator iter = collection.iterator();
			while (iter.hasNext()) {
				PrintWriter pw = (PrintWriter) iter.next();
				pw.println(msg);
				pw.flush();
			}
		}
	}

	// 시간 설정 메서드
	public String getTime() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("[hh:mm:ss]");
		return simpleDate.format(new Date());
	}

	public static void main(String[] args) {
		new MultiServer();
	}

}