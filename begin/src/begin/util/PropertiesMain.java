package begin.util;

import java.util.Properties;
import java.awt.List;
import java.util.*;

public class PropertiesMain {
	//운영체제의 경로 구분자를 반환하는 printSeparator 메소드 작성
	//매개변수는 없음
	private static String printSeparator() {
		String sep = System.getProperty("file.separator");	//운영체제의 경로 구분자를 가지고 오는 명령어
		return sep;
	}
	
	//DB의 계정 정보와 비밀번호를 설정하는 setDatabase 메소드 작성
	//단, 게정 정보와 비밀번호는 매개변수로 넘겨받아서 처리
	//반환값은 Properties 객체
	private static Properties setDatabase(String dbID, String dbPW)	{
		Properties prop = new Properties();
		prop.put("DB_ID", dbID);
		prop.setProperty("DB_PW", dbPW);
		return prop;
	}
	
	//현재 시스템에 설정되어 있는 property 값들을 화면에
	//출력하는 printSystemProp 메소드 작성
	private static void printSystemProp() {
		Properties printProp = System.getProperties();
		printProp.list(System.out);
	}
	
	public static void main(String[] args) {
		//setDatabase 메소드를 호출하여 반환값을 넘겨받아 다음을 출력
		//db id : ~~, pw : ~~
		Properties p = setDatabase("dev", "1111");
		System.out.println("db id : " + p.get("DB_ID"));
		System.out.println("db pw : " + p.getProperty("DB_PW"));
		System.out.println("----- list() -----");
		p.list(System.out);
		printSystemProp();
		
		
		//운영체제의 구분자를 반환하는 스태틱 메소드를 호출하여
		//반환값을 문자열 변수 sep에 저장
		String sep = printSeparator();
		System.out.println(sep);		//sep 값을 화면에 출력
		
	}//End main

	

	
}//End class
