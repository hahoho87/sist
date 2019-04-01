package begin.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	//소켓 프로그래밍
	//클라이언트					//서버
								//1. 서버 소켓 생성
								//2. 서버 소켓으로 클라이언트 요청 대기
	//3. 소켓 생성			
	//4. 소켓을 이용 스트림 생성		//4. 소켓을 이용 스트림 생성
	//5. 서버로 메시지 전송			//6. 클라이언트 메시지 수신
								//7. 클라이언트로 메시지 전송
	//8. 서버의 메시지 수신
	//9. 소켓 종료					//9. 소켓 종료
	
	private Socket socket;		//클라이언트 소켓
	private BufferedReader br;	//클라이언트의 메시지 읽기
	private PrintWriter pw;		//클라이언트로 메시지 쓰기
	private ServerSocket serverSocket;
	
	public Server()	{
		int port = 5000;	//서버 포트
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("=== this is server ===");
			while (true) {	//클라이언트의 요청 대기
				socket = serverSocket.accept();		//클라이언트 접속 승인
				System.out.println(">> 클라이언트 접속!!");
				System.out.println(">> IP : " + socket.getInetAddress());
				System.out.println(">> PORT : " + socket.getLocalPort());
				System.out.println(">> REMOTE PORT : " + socket.getPort());
				
				//클라이언트와 연결된 스트림 생성
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//클라이언트가 전송한 메시지를 읽어서 콘솔로 출력
				String receive = br.readLine();
				if (receive != null || receive.length() > 0) {
					System.out.println(">> 클라이언트 메시지 : " + receive);
				}
					
				//클라이언트에게 메시지 전송
				pw = new PrintWriter(socket.getOutputStream());
				String send = ">> Welcome Client!!";
				pw.println(send);
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}

}

