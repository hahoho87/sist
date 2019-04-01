package begin.oop;

public class SetterGetterMain {

	public static void main(String[] args) {
		SetterGetter sg = new SetterGetter();

		// sg.age = 5;
		// sg.name = "K"; //private로 선언 되었으므로 외부에서 access 할 수 없다

		sg.setName("K");
		sg.setAge(5);

		System.out.println("이름 : " + sg.getName());
		System.out.println("나이 : " + sg.getAge() + "세");
	}

}
