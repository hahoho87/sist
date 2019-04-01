package begin.lang;

class Product	{
	String code, name, material;
	Season season;
	
	//멤버변수들을 매개변수로 받아 초기화하는 생성자 작성
	Product(String code, String name, String material, Season season)	{
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season;
		
	}
	
}

public class EnumClass {

	public static void main(String[] args) {
		//임의의 값으로 Product 객체 p 생성
		Product p = new Product("1234", "티", "면", Season.SPRING);
		
		System.out.println("상품코드 : " + p.code);
		System.out.println("상품명 : " + p.name);
		System.out.println("소재 : " + p.material);
		System.out.println("계절구분 : " + p.season);
		System.out.println("---------------------");
		
		for (Season s : Season.values())	{
			System.out.println(s);
		}
		System.out.println("---------------------");
		
		Season season = Season.SUMMER;
		
		switch	(season)	{
			case SPRING : System.out.println("계절 : 봄");		break;
			case SUMMER : System.out.println("계절 : 여름");	break;
			case FALL :   System.out.println("계절 : 가을");	break;
			case WINTER : System.out.println("계절 : 겨울");	break;
			default :	  System.out.println("계절 : 모두");	break;
		}
		
		
		System.out.println(System.currentTimeMillis());
		
		
		
	}//End main

}//End class
