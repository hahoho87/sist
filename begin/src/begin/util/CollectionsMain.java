package begin.util;

import java.util.*;

public class CollectionsMain{
	
	public static void usingCollections()	{
		//List 객체 list에 "Eee", "Bbb", "Aaa", "ddd", "aaa", "ccc" 값을 저장
		List<String> list = new ArrayList<>();
		list.add("Eee");
		list.add("Bbb");
		list.add("Aaa");
		list.add("ddd");
		list.add("aaa");
		list.add("ccc");
		//list의 값을 화면에 출력
		for (String a : list) {
			System.out.println(a);
		}
		System.out.println(list.toString());
		//list의 값을 정렬
		Collections.sort(list);	//list의 값을 정렬
		System.out.println(list);
	}

	public static void main(String[] args) {
		//usingCollections 메소드 호출
		usingCollections();
	}

}
