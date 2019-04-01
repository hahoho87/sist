
package begin;

import java.util.Random;

public class YeonSanJa {

	public static void main(String[] args) {
		
		int a = 1;		//변수 a, b에 각각 1과 2를 저장
		int b = 2;		
		int c = a + b;	//a와 b를 더한 값을 c에 저장
		System.out.println(c);		//c의 값을 화면에 출력
		System.out.println(a/b);	//a 나누기 b를 화면에 출력
		System.out.println(a*b);	//a 곱하기 b
		System.out.println(a-b);	//a 빼기 b
		System.out.println(a%b);	//a 나누어 나머지 b
		
		a = 1000000;
		b = 2000000;
		long x = (long) a * b;	//a와 b를 곱한 결과를 임의의 변수 x에 저장
								//a와 b중 하나만 큰 값으로 변환시켜줘도 해결 가능
		System.out.println(x);	//x의 값을 화면에 출력
		
		//비교 연산자 : == != > < >= <=
		System.out.println(5 == 2);
		System.out.println(5 != 2);
		System.out.println(5 > 2);
		System.out.println(5 < 2);
		System.out.println(5 >= 2);
		System.out.println(5 <= 2);
		System.out.println("------------------------");
		
		char ch = 'A';				//임의의 변수 ch에 임의의 영문자 하나를 저장
		boolean result = ch <= 90;	//90은 대문자 Z 대문자(65~90), 소문자(97~122)
	    System.out.println(result);	//대문자이면 true 소문자이면 false
		System.out.println("------------------------");
		
		//논리 연산자 : && || !
		ch = 'A';
		result = (65 <= ch) && (ch <= 90);
		System.out.println("대문자 : " + result);
		
		ch = 'A';
		result = (97 <= ch) && (ch <= 122);
		System.out.println("소문자 : " + result);
		
		int avg = 60;
		int total = 100;	//평균 60점 이상이거나 총점이 200점 이상이면
		result = (60 <= avg) || (200 <= total);	
		System.out.println("합격 : " + result);	//합격 : true 출력
		System.out.println("------------------------");
		
		boolean power = false;
		System.out.println("전원 : " + power);
		System.out.println("전원이 켜졌습니다.");
		power = !power;
		System.out.println("전원 : " + power);
		power = !power;
		System.out.println("전원이 꺼졌습니다.");
		
		//비트 연산자 : & | ^ ~
		int i = 3;	// 0 0 1 1
		int ii = 7;	// 0 1 1 1
		System.out.println("3 & 7 : " + (i & ii));	//문장 안에서 쓸 때는 괄호 붙인다.
		System.out.println("3 | 7 : " + (i | ii));	//0111
		System.out.println("3 ^ 7 : " + (i ^ ii));	//0100 -> 비교해서 다를 때 1
		//쉬프트 연산자 - 바이너리 계산에서 비트의 자릿수를 이동할 때 사용
		int iii = 8;				//   1 0 0 0
		System.out.println(iii>>1);	//   0 1 0 0
		System.out.println(iii<<1);	// 1 0 0 0 0
		System.out.println(iii>>2); //   0 0 1 0
		System.out.println("------------------------");
		
		//단항 연산자 : ++ --
		int year = 2019;
		System.out.println(year);	//2019
		System.out.println(++year);	//1을 먼저 증가
		System.out.println(year++);	//year의 값을 출력 한 후에 1을 증가시킴
		System.out.println(year);	//2021
		
		year = year + 1;
		System.out.println(year);
		year += 1;
		System.out.println(year);
		System.out.println(year - 1);
		System.out.println(--year);
		year -= 1;
		System.out.println(year);
		
		//삼항(조건) 연산자
		//(조건식) ? 1 : 2
		//조건식의 결과가 true이면 1,
		//			  false이면 2 수행		

		int data = 4;
		char Holzzac = (data%2 == 0) ? '짝' : '홀';
		System.out.println("입력값은 " + Holzzac +"수");
		//data의 값이 짝수이면 '입력값은 짝수'를 출력
		//data의 값이 홀수이면 '입력값은 홀수'를 출력
		
		result  = (3>2) ? true : false;
		System.out.println(result);
		
		
		
		int t = 11;		
		char qm = ((0 <= t) && (t <= 100)) ? '!' : '?';
		char chk = (t%3 == 0) ? 'O' : 'X';
		char zz =  ((qm == '!') && (chk == 'O')) ? 'O' : chk;
		System.out.println("3의 배수 : " + zz);	// 수정해야 함
		
		int input= 11;
		char check = (input >=0 && input <=100 ) ? '!' : '?';
		char baesu = (check != '?' && (input%3) == 0) ? 'O' : 'X';
		System.out.println(input + "는 3의 배수 : " + baesu); // 강사님
		
		//0 ~ 100사이의 임의의 값을 입력받아
		//3의 배수인지 출력
		//출력 형태 : 3의 배수 : O
	    //         3의 배수 : X
		Random rand = new Random(System.currentTimeMillis());
		
		
		
		
	}

}
