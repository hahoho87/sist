package begin.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
//	private String serverIP = "211.238.142.212";
	private String serverIP = "localhost";
	private int serverPort = 5000;
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	
	public Client()	{
		System.out.println("=== this is a client ===");
		try {
			//소켓 생성
			socket = new Socket(serverIP, serverPort);
			
			//서버로 연결된 스트림 생성
			pw = new PrintWriter(socket.getOutputStream());
			pw.println("hello server");		//서버로 메시지 전송
			pw.flush();
			
			//서버의 메시지 수신 콘솔로 출력
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 서버부터 메시지 입력받음
			String receive = br.readLine();
			// 입력받은 내용을 서버 콘솔에 출력
			if (receive != null || receive.length() > 0) {
				System.out.println("서버가 보내온 내용 : " + receive);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally	{
			try {
				if(socket != null)
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//End try
		
	}//End 생성자
	
	
	public static void main(String[] args) {
		new Client();
	}

}
