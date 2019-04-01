package begin.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;

public class ChatServer
{
	// 프레임 선언
	private JFrame jFrame = new JFrame("채팅");
	
	//서버 소켓 및 소켓 선언
	private ServerSocket serverSocket;
	private Socket socket;
	
	//소켓들을 담을 ArrayList 선언
	private ArrayList<Socket> socketList = new ArrayList<Socket>();

	public ChatServer()
	{
		// 프레임 크기 및 보이기 설정
		jFrame.setSize(500, 400);
		jFrame.setVisible(true);
		
		// swing에만 있는 X버튼 클릭시 종료
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		try
		{
			serverSocket = new ServerSocket(8000); // 서버소켓 선언

			while( true )
			{
				//소켓이 생성될 때까지 대기
				socket = serverSocket.accept();
				
				// 소켓이 생성되면,
				if( socketList.add(socket) )
				{
					new Thread()
					{
						@Override
						public void run()
						{
							BufferedReader bufferedReader = null;

							try
							{
								// 이 내용을 while문 안에 넣었을 때 문제가 생겼다.
								// 다름아닌 계속해서 소켓을 새로 생성하는 문제였는데,
								// 다행히 클라이언트는 소켓이 변화되지 않는다. 따라서
								// 문제가 없었지만, 서버에서는 소켓이 새로 생성될 때마다 달라졌으므로 문제가
								// 커졌다.
								bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

								while( true )
								{
									// 클라이언트로부터 메시지 입력받음
									String clientMessage = bufferedReader.readLine();

									// 입력받은 메시지가 길이가 0 이상이면,
									if( clientMessage.trim().length() > 0 )
									{
										//클라이언트 하나로부터 전달받은 메시지를 전파
										ChatServer.this.spreadMessage(clientMessage);
									}
									
									if( clientMessage.contains("님이 퇴장하셨습니다.　　　"))
									{
										System.out.println("퇴장했을 경우 버퍼리더 정리");
										break;
									}
								}
							}
							catch (Exception e)
							{
								System.out.println(e + "=>server run");
							}
							finally
							{
								// 읽어오기 종료
								try
								{
									bufferedReader.close();
								}
								catch (IOException e)
								{
									System.out.println(e + "=> ");
								}
							}
						}

					}.start(); // 스레드 실행

				}
			}

		}
		catch (Exception e)
		{
			System.out.println(e);
		}

	}

	//메시지를 전파하는 메소드
	public void spreadMessage(String message)
	{
		for( int i = socketList.size() - 1 ; i > -1 ; i-- )
		{
			// 클라이언트에게 보내기 위한 준비
			try
			{
				if( !socketList.get(i).isClosed() )
				{
					BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socketList.get(i).getOutputStream()));
					bufferedWriter.write(message);
					bufferedWriter.newLine();
					bufferedWriter.flush();
				}
				else
				{
					socketList.remove(i);
				}

			}
			catch (Exception e)
			{
				System.out.println("소켓 에러");
			}
		}
	}

	public static void main(String[] args)
	{
		new ChatServer();
	}
}