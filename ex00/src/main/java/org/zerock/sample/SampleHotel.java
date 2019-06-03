package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	
	@NonNull
	private Chef chef;

//	@AllAgrsConstructor-> 인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자를 작성
	
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
}
