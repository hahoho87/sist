package begin;

public class Typecast {

	public static void main(String[] args) {
		
		
		byte a = 10;		//정수형 10을 변수 a에 저장
		byte b = 20;		//정수형 20을 변수 b에 저장
		byte c = 10 + 20;	//10과 20을 더한 값을 변수 c에 저장
	//	byte cc = a + b; 	<<<< 얘는 에러 (int로 계산 후에 변환하기 때문에 에러)
		byte cc = (byte)(a + b);	//변환은 더한 후에 일어나기 때문에 더한 후에 변환
		
		int i = a + b;
		
		double d = 85.4;	//85.4를 임의의 변수 d에 저장
		int ii = (int)d;	//d를 int형 변수 ii에 저장(필요 시 에러 대응)
		float f;			//변수 f 선언
		
		d = 85.0123456789;
	//	f = 85.0123456789F;
	//	f = 85.0123456789;
		f = (float) 85.0123456789;
		
		//변수 a, b, c의 값을 화면에 출력
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println(cc); 
	    System.out.println(i);
	    System.out.println(ii);
	    
	    System.out.println(d);
	    System.out.println(f);
	}

}
