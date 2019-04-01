package begin.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UrlTest {

	public static void main(String[] args) {
		String addr = "https://docs.oracle.com/javase/8/docs/api/";
		URL url = null;
		
		try {
			url = new URL(addr);
			URLConnection urlCon = url.openConnection();
			//URL의 헤더 필드들을 맵 객체로 넘겨 받아
			Map<String, List<String>> headerMap  = urlCon.getHeaderFields();
			//키와 값을 화면으로 출력
			
			Iterator<String> it = headerMap.keySet().iterator();
			//키의 값을 화면으로 출력
			while(it.hasNext()) {
				//키에 대한 값을 저장
				String key = it.next();
				List<String> value = headerMap.get(key);	//키가 List이기 때문에 한번 더 꺼내줘야 한다
				for (String s : value) {
					System.out.println(key + " : " + s);
				}
			}

			//url 정보
			//최종 수정 일자
			//content type
			
			long date = urlCon.getLastModified();
			if (date==0)
				System.out.println("No last modified information");
			else 
				System.out.println("최종 수정 날짜 : " + new Date(date));
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//End main

}//End class
