package begin.control;

public class For {

	public static void main(String[] args) {
		//반복문 for
		//
		//for(  초기식; 조건식; 증감식 ){
		//		반복한 내용들;
		//}
		//for(  ; true; )	{ } // 무한반복문
		//for(  ;  ;  )		{ } //	  "
		
		System.out.println(1);	
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);	//(초기식 - int i =1 ; 조건식 - i <= 5, 증감식 - i++)
		System.out.println("---------------------");
				
		for(int i = 1 ; i <= 5 ; i++) {
		System.out.println(i);
		}
		System.out.println("---------------------");
		
		//1~10 까지 누적 합계를 화면에 출력
		int i;
		int sum = 0;	//for문 바깥에서 선언을 해야 for문 안에서 다시 0으로 지정하지 않음
		
		for (i = 1 ; i <= 10 ; i++) {
			sum = sum + i;	//sum += i
			System.out.println(i + "까지의 합 : " + sum);
		}
		System.out.println(i + "까지의 합 : " + sum);		//값만 구하고 싶을 땐 for문 밖에서
		System.out.println("---------------------------");
		
		
		
		
	}//End main

}//End class
