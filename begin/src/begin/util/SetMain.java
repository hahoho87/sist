package begin.util;

import java.util.*;

public class SetMain	{

	public static void main(String[] args) {
		//Set 인터페이스의 인스턴스 s생성
//		Set s = new Set();	//인터페이스는 객체 생성 불가
		Set<Object> s = new HashSet<Object>();	// 부모 = 자식으로 사용할 수 있음
		System.out.println("size : " + s.size());
		s.add('1');
		s.add(2);
		s.add(3.0);
		s.add("넷");
		s.add(true);
		System.out.println("size : " + s.size());
		
		System.out.println(s);
		System.out.println(s.toString());
		System.out.println("------for each------");
		
		for (Object o : s) {
			System.out.println(o);
		}
		System.out.println("------iterator------");
		Iterator<Object> iterator = s.iterator();
		while(iterator.hasNext())	{
			Object o = iterator.next();
			System.out.println(o);
			
			if(o.equals("넷"))	{
				iterator.remove();	//"넷 삭제
			}
		}
		System.out.println(s);
		
		
	}//End main


}//End class
