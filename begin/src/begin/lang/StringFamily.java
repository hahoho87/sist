package begin.lang;

public class StringFamily {

	public static void main(String[] args) {
		String a = "abc";
		
//		StringBuilder b = "abc";	//Builder와 Buffer는 이런식으로 사용 불가
		
		StringBuilder b = new StringBuilder("abc");
		StringBuffer c = new StringBuffer("abc");
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		System.out.println("-------------");
		
		a += "def";
		b.append("def");
		c.append("def");
		
		System.out.println(a + " : " +a.hashCode());
		System.out.println(b + " : " +b.hashCode());
		System.out.println(c + " : " +c.hashCode());
	}

}
