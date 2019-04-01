package begin.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressClass {

	public static void main(String[] args) {
		
		try {
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println("호스트 이름 : " + ia.getCanonicalHostName());
			System.out.println("호스트 이름 : " + ia.getHostName());
			System.out.println("호스트 ip 주소 : " + ia.getHostAddress());
			System.out.println("-------------------------");
			
			ia = InetAddress.getByName("www.naver.com");
			System.out.println("호스트 이름 : " + ia.getHostName());
			System.out.println("호스트 ip 주소 : " + ia.getHostAddress());
			System.out.println("-------------------------");
			
			InetAddress[] iaList = InetAddress.getAllByName("www.daum.net");
			for (InetAddress i : iaList) {
				System.out.println("호스트 이름 : " + i.getHostName());
				System.out.println("호스트 ip 주소 : " + i.getHostAddress());
				System.out.println("-------------------------");
				
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//End main

}//End class
