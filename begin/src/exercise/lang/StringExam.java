package exercise.lang;

public class StringExam {

	public static void main(String[] args) {
		String birth = "19991231";	//생년월일	
		String idNo	= "991122-1234567";	//주민등록번호
		String file = "this.is.music.mp3";	//파일명
		
		//생년월일을 1999년 12월 13일로 출력
		System.out.println(birth.substring(0,4)+"년 " + birth.substring(4,6)+"월" + birth.substring(6,8)+"일");
		
		//주민등록번호로 성별 판단 후 출력
			//-의 위치를 찾은 후에, 그 뒤에 숫자를 이용해서 성별 판단, %연산자 이용
		int gender = idNo.charAt(idNo.indexOf("-")+1);
		if (gender%2 == 1) {
			System.out.println("성별  : 남자");
		} else System.out.println("성별  : 여자");
		
		//파일명에서 확장자를 추출
		System.out.println(file.substring(file.lastIndexOf(".")+1));

	}

}
