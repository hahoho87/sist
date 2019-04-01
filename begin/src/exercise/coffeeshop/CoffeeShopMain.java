package exercise.coffeeshop;

public class CoffeeShopMain {

	public static void main(String[] args) {

		System.out.println("****java nara CoffeeShop 영업개시****");
		Beverage[] beverage = new Beverage[5];
		beverage[0] = new Coffee("Cappuccino");
		// Coffee 클래스의 이름을 매개변수로 받는 생성자로 넘어감
		// super에 의해 beverage 클래스의 생성자로 넘어감
		// this.name = name 에 의해 이름을 지정하고
		// calcPrice 는 상속에 의해 coffee클래스의 calcPrice 로 이동
		// Cappuccino를 들고 switch문을 돌린 결과 price에 3000이 입력 됨
		// 그 후에 Coffee의 amount에 1추가 
		// 스태틱으로 만든 이유??
		// 각 배열이 하나의 객체를 같이 이용하기 때문
		
		beverage[1] = new Coffee("CafeLatte");
		beverage[2] = new Tea("ginsengTea");
		beverage[3] = new Coffee("CafeLatte");
		beverage[4] = new Tea("redginsengTea");

		printSalesInfo(beverage);
		System.out.println("총 판매 금액 \t==> " + getTotalPrice(beverage));
		System.out.println("Coffee의 판매 개수 \t==> " + Coffee.amount + "잔");
		System.out.println("Tea의 판매 개수 \t==> " + Tea.amount + "잔");

	}

	private static int getTotalPrice(Beverage[] beverage) {
		int sum = 0;
		
//		for (int i = 0 ; 1 < beverage.length; i++)	{
//			sum += beverage[i].price;
//		}	//for each -> for문으로 바꿔보자 잘 이해 안감
		
		for (Beverage b : beverage) { // 배열의 2번째 위치에 있는
			sum += b.price;
		}
		return sum;
	}

	private static void printSalesInfo(Beverage[] beverage) {
		for (int i = 0; i < beverage.length; i++) {
			System.out.print((i + 1) + "번째 판매");
			beverage[i].print();
		}
	}

}// End CoffeeShop class