package begin.util;

import java.util.*;

public class MapMain {

	public static void main(String[] args) {
		//Map 인터페이스의 객체 map 생성
//		Map map = new Map<Integer, String>();	// 인터페이스는 객체 생성 불가
		Map<Integer , String> map = new HashMap<Integer, String>();
		map.put(2, "서울");
		map.put(31, "경기");
		map.put(32, "인천");
		map.put(64, "제주");
		map.put(64, "제주제주");
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get(32));
		
		System.out.println("------ keySet() ------");
		Set<Integer> keys = map.keySet();	//map의 키셋을 keys 셋에 저장
		System.out.println("size : " + keys.size());
		for (Integer integer : keys) {
			System.out.println(map.get(integer));
		}
		System.out.println("------ iterator() ------");
		
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext())	{
			Integer key = iterator.next();
			
			System.out.println(key + " : " + map.get(key));
			}
		System.out.println("-------- remove --------");
		
		//map의 key가 2인 데이터 삭제
		map.remove(2);
		System.out.println("size : " + map.size());
		System.out.println(map);
		
		System.out.println("-------- clear --------");
		map.clear();
		System.out.println(map.size());
		System.out.println(map);
		
		
		}
		
	}


