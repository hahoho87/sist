package org.zerock.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardAttachVO;
import org.zerock.mapper.BoardAttachMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	//어제 날짜의 폴더를 문자열로 만드는 메서드
	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String str = sdf.format(cal.getTime());
		
		return str.replace("-", File.separator);
	}
	
					 //초 분 시 일 월 dayOfWeek 년(생략가능)
	@Scheduled(cron = "0 0 13 * * *")	//매일 13시에 실행
	public void checkFile() throws Exception {
		Date now = new Date();
		log.warn("File Check Task Run............." + now.toLocaleString());
		log.warn("================================");
		
		//tbl_attach 테이블에서 어제 날짜의 첨부파일 목록 가져오기
		List <BoardAttachVO> fileList = attachMapper.getOldFiles();
		
		List<Path> fileListPaths	//c:\\upload 폴더의 첨부파일을 목록으로 만들기
				= fileList.stream()
					.map(vo -> Paths.get("c:\\upload",
										 vo.getUploadPath(),
										 vo.getUuid() + "_" +
									     vo.getFileName()))
					.collect(Collectors.toList());
		
		fileList.stream()			//섬네일 이미지가 있는 경우에는 첨부파일 목록에 추가
	 					.filter(vo -> vo.isFileType() == true)
	 					.map(vo -> Paths.get("c:\\upload",
					  			   			 vo.getUploadPath(),
					  			   			 "s_" + vo.getUuid() + "_" +
					  			   			 vo.getFileName()))
	 					.forEach(p -> fileListPaths.add(p));
		
		//c:\\upload 폴더의 실제 파일 가져오기
		File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
		//tbl_attach 테이블 첨부파일 목록에 없는 파일을 삭제 대상 배열에 추가
		File[] removeFiles = targetDir.listFiles(file -> 
													fileListPaths.contains(file.toPath()) == false);
		//삭제 대상 배열의 파일들 삭제
		log.warn("------------------------------");
		for (File file : removeFiles) {
			file.delete();			
		}
	}
}
