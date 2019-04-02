package exercise.net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChatClientFrame {
	private String serverIP = "localhost";
	private int serverPort = 4000;
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	private Scanner scan;
	private String nickname = "abc";

	public ChatClientFrame() {
		// 키보드로 입력한 대화 내용을 서버로 전송하고
		// 서버에서 보내 온 내용을 화면에 출력
		// 단, "서버로 전송 시간#닉네임#대화내용"의 형태로 전송
		// 출력형태
		// === CLIENT CHAT ===
		// [접속 날짜 표시]
		// [00:00:00] ~~~ 서버에 접속되었습니다.
		// >> 입력(채팅 종료는 /q) : 대화내용
		// [00:00:00] 닉네임 > 대화내용
		// >> 입력(채팅 종료는 /q) :

		

		System.out.println("=== CLIENT CHAT ===");
		SimpleDateFormat today = new SimpleDateFormat("[YY-MM-DD]");
		System.out.println(today.format(new Date()));
		SimpleDateFormat now = new SimpleDateFormat("[hh:mm:ss] ");
		System.out.println(now.format(new Date()) + "서버에 접속되었습니다.");
		try {
			socket = new Socket(serverIP, serverPort);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			scan = new Scanner(System.in);
			// 스캐너가 아니라 tf에 입력된 값을 받아옴

			while (true) {
				System.out.print(">> 입력(종료는 /q) : ");
				String msg = scan.nextLine();

				if (msg == null || msg.equalsIgnoreCase("/q")) {
					System.out.println(">>채팅 종료");
					break;
				}
				pw.println(getTime() + nickname + "#" + msg); // 서버로 메시지 전송
				pw.flush();
				msg = br.readLine();// 서버 메시지 수신
				System.out.println("수신 : " + msg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (scan != null)
					scan.close();
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // END try
	}// END 생성자

	// 시간 설정 메소드
	public String getTime() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("[hh:mm:ss]#");
		return simpleDate.format(new Date());
	}

	public static void main(String[] args) {
		new ChatClient();
	}

}
