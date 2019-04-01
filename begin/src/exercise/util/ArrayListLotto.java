package exercise.util;

import java.util.*;

public class ArrayListLotto {

	// 1. 로또 번호 7개를 중복되지 않게 추출 > 생성자 이용
	private List<Integer> lottoNums;// 당첨 번호 리스트
	private List<Integer> myLotto; // 내 번호 리스트
	private int bonusNum;    // 보너스 번호 리스트
	private int matchCnt; // 당첨 개수
	private String result; // 당첨 결과

	public ArrayListLotto() {
		lottoNums = new ArrayList<Integer>();

		for (int i = 0; i < 7; i++) {
			int nansu = (int) (Math.random() * 45) + 1;
			// int를 붙이기 전에 괄호로 묶어서 먼저 계산한 후에 정수로 변환
			// +1을 해줘야 0이 나오지 않는다
			if (lottoNums.contains(nansu) == true) { // 중복 체크
				i--;
			} else {
				lottoNums.add(nansu); // 중복이 아니면 난수를 리스트에 추가
			}
			// 6개 추출 후에 정렬
			if (i == 5)
				Collections.sort(lottoNums); // 앞의 6개 정렬 (끝의 하나는 보너스 번호)
		}
		System.out.println(lottoNums);

	}// End 생성자

	// 2. 나의 로또 당첨 여부 > checkLotto 메소드 작성
	public void checkLotto(String[] args) {
		myLotto = new ArrayList<Integer>();

		for (String s : args) { // 당첨 개수 확인
			if (lottoNums.contains(Integer.parseInt(s))) {
				matchCnt++; // 일치하면 당첨개수 증가
			}
			myLotto.add(Integer.parseInt(s));
		}
		Collections.sort(myLotto);

		switch (matchCnt) // 나의 등수 확인
		{
		case 6:
			result = "1등";
			break;
		case 5:
			result = myLotto.contains(lottoNums.get(6)) ? "2등" : "3등";
			break;
		case 4:
			result = "4등";
			break;
		case 3:
			result = "5등";
			break;
		default:
			result = "꽝";
			break;
		}
		printResult(); // 당첨 결과 출력 메서드 호출
	}// END checkLotto()

	// 3. 당첨 결과 출력 > printResult 메소드 작성
	 public void printResult() // 당첨결과 출력 - 메서드
	 {
	  System.out.println("로또 번호 : " + lottoNums + " 보너스 번호 : [" + bonusNum + "]");
	  System.out.println("나의 번호 : " + myLotto);
	  System.out.println("당첨 결과 : " + result);
	  System.out.println("당첨 개수 : " + matchCnt);
	 }
	 
	}// END class


