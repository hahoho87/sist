package exercise.coffeeshop;

abstract class Beverage {
	protected String name;
	protected int price;

	public Beverage(String name) {
		this.name = name;
		calcPrice(); // 이해 잘 안됨
						// super에서 부모를 한 번 호출하기 때문에
						// 여기에 넣어주면 clac를 호출하게 됨
	}

	abstract public void calcPrice();

	public void print() {
		System.out.print("음료는 " + name + "이며, ");
		System.out.println("가격은 " + price + "원 입니다.");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}// End Beverage class

class Coffee extends Beverage {

	public static int amount;

	public Coffee(String name) {
		super(name);
		amount++;
	}

	@Override
	public void calcPrice() {
		switch (name) {
		case "Americano":
			price = 1500;
			break;
		case "CafeLatte":
			price = 2500;
			break;
		case "Cappuccino":
			price = 3000;
			break;
		}
	}

}// End Coffee class

class Tea extends Beverage {

	public static int amount;

	public Tea(String name) {
		super(name);
		amount++;
	}

	@Override
	public void calcPrice() {
		switch (name) {
		case "lemonTea":
			price = 1500;
			break;
		case "ginsengTea":
			price = 2000;
			break;
		case "redginsengTea":
			price = 2500;
			break;
		}
	}

}// End Tea class

public class CoffeeShop {
	public static void main(String[] args) {

	}
}// End CoffeeShop class
