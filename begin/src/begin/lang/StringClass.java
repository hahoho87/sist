package begin.lang;

public class StringClass {
	//String
	//내부적으로 char 배열의 객체 형태
	//저장된 문자열은 수정 불가능
	// -한번 생성된 문자열은 읽기만 가능
	// -문자열이 변경되면 새로운 인스턴스가 만들어지기 때문에
	//	문자열 결합이나 변경 등의 작업이 많은경우는
	//	StringBuilder 또는 StringBuffer 사용 권장
	
	public static void main(String[] args) {
		String a = "hahaha";
		String b = "hahaha";
		String c = new String("hahaha");
		String d = new String("hahaha");
		
		//삼항연산자로 처리
		// A ? B : C -> A가 참이면 B 아니면 C
		System.out.println(a==b ? "a == b" : "a != b");
		System.out.println(c==d ? "c == d" : "c != d");	//c와 d는 다른 주소에 저장되어 있기 때문에 false
		System.out.println(a.equals(b)? "a equals b" : "a !equals b");
		System.out.println(c.equals(d)? "c equals d" : "c !equals d");
		System.out.println("------------");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		System.out.println("------------");
		
		a = "ha";
		b = "haha";
		c = "hahaha";
		d = "hahahaha";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		System.out.println("------------");
		
}
	
}
