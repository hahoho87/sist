package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {
	private int pageNum;	//페이지 번호
	private int amount;		//한 페이지  당 출력 개수
	
	//페이지 번호와 개수를 지정하지 않은 경우
	public Criteria() {
		this(1, 10);	//기본 pageNum은 1, amount는 10개로 지정\\
	}
	
	//페이지 번호와 개수를 지정한 경우
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
