package exercise;

public class TypeCastEx {

	public static void main(String[] args) {
		/* 소스파일 패키지
		소스파일명 : TypeCastEx
		기능 : 임의 문자의 아스키코드값을 10진수로 출력
		필요 변수 1 : 문자 저장
		필요 변수 2 : 출력 10진수 아스키코드 값
		출력 형태 1 : 문자 ~~의 아스키코드값 : ~~	
		출력 형태 2 : 아스키코드 ~~의 문자 : ~~	*/
		
		char ch = 'A';
		int code = ch;		//큰 메모리에 작은 메모리가 들어가는 것이므로 신경쓰지 않아도 됨
							//묵시적 형변환 - 자동
		System.out.println("문자 "+ ch +"의 아스키코드값 : " + code);
		
		code = 65;
		ch = (char) code;	//code는 4byte, ch는 2byte이므로 형변환을 해야한다
							//명시적 형변환 - 강제
							//질문 - code가 65로 2byte 이내라 값손실이 일어나지 않는 것ㅇㅇ
		System.out.println("아스키코드 " + code +"의 문자 : " + ch);
		
		// 'A' ~ 'Z', 'a' ~ 'z', '0' ~ '9' 라고 작은 따옴표로 
		// 설정해 주어야 이 범위 안에서 사용 가능
	}

}
