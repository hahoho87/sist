package webex.dao;

import webex.vo.MyBeans;

public class MyBeansDAO {
	

	public boolean insert(MyBeans myBeans) {
		System.out.println("country : " + myBeans.getCountry());
		System.out.println("city : " + myBeans.getCity());
		System.out.println("name : " + myBeans.getName());
		
		// 회원가입 쿼리 실행
		return true;
	}
}
