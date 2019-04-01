package begin.lang;

public class StringMethod {
	
	public static void main(String[] args) {
		String a = "java.world";
		String b = "   JAVA    WORLD   ";
		String c = "Hello&java,world,jsp-servlet";
		
		String[] result = a.split(".");
		for (int i = 0 ; i<result.length ; i++)	{
			System.out.println(result[i]);
		}
		String aab = a.substring(a.indexOf("."));
		System.out.println(a.replace(aab,"-복사본"+aab));
//		//변수 c에서 영단어들만 배열의 저장
//		String[] cResult = c.split("&|,|-");
//		//cResult의 길이 출력
//		System.out.println(cResult.length);
//		
//		//foreach를 사용하여  cResult의 값 출력
//		for (String s : cResult)	{
//			System.out.println(s);
//		}
//		
//		//변수 a를 공백으로 구분하여 자른 후 배열에 저장
//		String[] result = a.split(" ");
//		for (int i = 0 ; i<result.length ; i++)	{
//			System.out.println(result[i]);
//		}
//		
//		//번수 b의 공백제거
//		System.out.println(b.trim());
//		
//		//변수 a의 java를 Hello로 변경
//		System.out.println(a.replace("java", "Hello"));
//		System.out.println(a);
//		
//		//변수 a를 모두 대문자로
//		System.out.println(a.toUpperCase());
//		
//		//변수 a에서 java만 추출
//		System.out.println(a.substring(0, 4));	//index에 +1을 해야함
//		//변수 a에서 world만 추출
//		System.out.println(a.substring(5));
//		
//		//번수 a에서 world만 추출 + IndexOf사용
//		System.out.println(a.substring(a.indexOf("w")));
//		
//		//2번째 문자 추출
//		System.out.println(a.charAt(2));
//		//문자 a의 위치
//		System.out.println(a.indexOf("a"));
//		//문자 a의 마지막 위치
//		System.out.println(a.lastIndexOf("a"));
//		//문자열 a의 길이
//		System.out.println(a.length());
//		
//		if(a.equals(b)) System.out.println("a eq b");
//		if(a.equalsIgnoreCase(b)) System.out.println("a eq ignore case b");
//		
//		
		
		
	}
}
