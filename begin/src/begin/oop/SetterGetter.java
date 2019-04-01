package begin.oop;

public class SetterGetter {

	private int age;
	private String name;

	// setter
	// 멤버 변수의 데이터타입과 같은 매개변수를 넘겨받아
	// 멤버 변수의 값을 설정하고 반환값은 없는 메소드
	// set으로 시작하고 멤버변수의 첫 자를 대문자로 변경하여 연결
	// 접근제한자는 보통 public으로 사용
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// getter
	// 멤버 변수의 값을 반환하는 메소드
	// 매개변수는 없음
	// get으로 시작하고 멤버변수의 첫 자를 대문자로 변경하여 연결
	// 접근제한자는 보통 public으로 사용
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
