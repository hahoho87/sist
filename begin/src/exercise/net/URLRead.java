package exercise.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLRead {

	public static void main(String[] args) {
		String address = "https://docs.oracle.com/javase/8/docs/api/";

		URL url = null;
		try {
			url = new URL(address);
			URLConnection urlCon = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			String input;
			while ((input = reader.readLine()) != null) {
				System.out.println(input);
				reader.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		// 지정된 주소의 문서를 읽어서 콘솔로 출력

	}// End main
}// End class
