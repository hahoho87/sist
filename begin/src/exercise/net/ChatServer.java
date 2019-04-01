package exercise.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatServer {
	private Socket socket; // 클라이언트 소켓
	private BufferedReader br; // 클라이언트의 메시지 읽기
	private PrintWriter pw; // 클라이언트에게 메시지 쓰기
	private ServerSocket serverSocket;

	public ChatServer() {
		// 클라이언트 접속시간, IP, 닉네임, 대화내용을 콘솔로 출력
		// 클라이언트에게 전송시간[00:00:00]#닉네임#대화내용을 전송
		int port = 5000; // 서버 포트
		try {// 서버 소켓 생성
			serverSocket = new ServerSocket(port);
			System.out.println("=== this is server ===");
			socket = serverSocket.accept(); // 클라이언트 접속 승인
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			System.out.println(">> 클라이언트 접속!!");
			System.out.println(">> IP  :" + socket.getInetAddress());
			System.out.println(">> REMOTE IP : " + socket.getPort());
			while (true) { // 클라이언트 요청 대기

				String msg = br.readLine(); // 클라이언트 메시지 읽기
				if (msg == null) {
					System.out.println(">> 클라이언트 접속 종료");
					break;
				}
				// 클라이언트의 메시지를 #으로 구분하여 배열에 저장
				String[] msgs = msg.split("#");

				System.out.println(">> 클라이언트 메시지 : " + msg);
				pw.println(getTime() + msgs[1] + "#" + msgs[2]); // 클라이언트로 메시지 전송
				pw.flush();
			} // END while
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
				if (socket != null)
					socket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// END 생성자

	public String getTime() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("[hh:mm:ss]#");
		return simpleDate.format(new Date());
	}

	public static void main(String[] args) {
		new ChatServer();
	}

}
