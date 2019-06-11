package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;		//시작 페이지 번호
	private int endPage;		//마지막 페이지 번호
	private boolean prev, next;	//이전, 이후
	private int total;			//전체 게시물 개수
	private Criteria cri;		//페이지 번호, 한 페이지당 게시물 개수
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//마지막 페이지 계산 - 한 화면에 10개씩 페이지 번호를 출력한다고 가정
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		//시작 페이지 계산
		this.startPage = this.endPage - 9;
		
		//전체 페이지 수를 반영한 실제 마지막 페이지 계산
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		//이전 페이지
		this.prev = this.startPage > 1;
		//다음 페이지
		this.next = this.endPage < realEnd;
	}
	

}
