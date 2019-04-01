package begin.control;

public class Return {

	public static void main(String[] args) {
		//return문
		//현재 수행중인 method를 중단하고
		//method를 호출한 곳으로 제어를 반환
		
		for(int i=1 ; i<=5 ; i++)	{
			System.out.println(i);
			if (i==3)	return;			//break 사용 시, for문만 정지 (반복을 그만해)
										//return 사용 시, method 중단 (끝)
		}
		System.out.println("main end");

	}

}
