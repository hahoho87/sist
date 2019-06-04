package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	private List<SampleDTO> list;
	
	//lombok으로 list를 작성할 수 없기 때문에 생성자를 통해 list를 작성
	public SampleDTOList() {
		list = new ArrayList<>();
	}
}
