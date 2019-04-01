package begin.util;

import java.util.*;

public class ListMain {

	public static void main(String[] args) {
		//List 인터페이스의 객체 list 생성
//		List list = new List();	//인터페이스는 객체 생성 불가
		List<Object> list = new ArrayList<Object>();
		System.out.println(list.size());
		list.add('1');
		list.add(2);
		list.add(3.0);
		list.add("넷");
		list.add(true);
		System.out.println(list.size());
		System.out.println(list);
		
		System.out.println("세 번째 요소 : " + list.get(2));
		
		System.out.println("------  for  ------");
		for (int i = 0 ; i < list.size(); i++)	{
			System.out.println(list.get(i));
		}			
		System.out.println("------for each------");
		for (Object o : list)	{
			System.out.println(o);
		}
		System.out.println("------iterator------");
		Iterator<Object> iterator = list.iterator();
		while(iterator.hasNext())	{
			Object o = iterator.next();
			System.out.println(o);
	}

}
}
