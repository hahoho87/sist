package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {
	private int pageNum;	//페이지 번호
	private int amount;		//한 페이지  당 출력 개수
	private String type;	//검색 조건
	private String keyword;	//검색어
	
	//페이지 번호와 개수를 지정하지 않은 경우
	public Criteria() {
		this(1, 5);	//기본 pageNum은 1, amount는 10개로 지정\\
	}
	
	//페이지 번호와 개수를 지정한 경우
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//검색 조건을 배열로 만들어서 한 번에 처리하기 위한 메서드
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
		
	}
	
}
