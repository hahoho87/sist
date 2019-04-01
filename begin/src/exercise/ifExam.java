package exercise;

public class ifExam {

	public static void main(String[] args) {
		// 정보처리기사 필기 시험 합격 여부 판정 프로그램
		// 각 과목명 변수 작성 및 임의의 점수 저장
		// 평균 60점 이상이고
		// 각 과목별 과락 40점 아니면 합격
		// 그렇지 않으면 불합격 처리
		// 출력 형태 : 각 과목별 점수 및 평균과 합격 여부
		//			단. 평균은 소숫점 이하 6자리까지만 표시
		

		int A = 45;
		int B = 45;
		int C = 75;
		int D = 75;
		int E = 75;
		float F = ((A+B+C+D+E)/5.0f);	//5.0f로 입력해서 float값으로 변경

		if ((F >= 60) 
				&& (A >= 40) && (B >= 40) && (C >= 40) && (D >= 40) && (E >= 40)) {
			System.out.println("과목 A : " + A + "점");
			System.out.println("과목 B : " + B + "점");
			System.out.println("과목 C : " + C + "점");
			System.out.println("과목 D : " + D + "점");
			System.out.println("과목 E : " + E + "점");
			System.out.println("평균 " + F + "점으로" + " 합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
			System.out.println("--------------------------");

			
		//영문자 여부 판정 프로그램
		//임의의 변수에 영문자 하나를 입력
		//변수의 값이 대문자이면
		//	'대문자입니다'를 출력
		//변수의 값이 소문자이면
		//	'소문자입니다' 출력
		//영문자가 아니면
		//	'영문자로 입력해주세요' 를 출력
		
		
		char ha = 'a';
		String result = "";
		  if ((ha >= 'A' ) && (ha <= 'Z')) {
			result = "대문자입니다.";
		} else if ((ha >= 'a') && (ha <= 'z')) {
			result = "소문자입니다.";
		} else {
			result = "영문자로 입력해 주세요.";
		}
		System.out.println(result);
	}

}
