package exercise.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileEditor {

	private String file;
	private String path;

	private InputStream is; // 키보드 입력 스트림
	private int input; // 사용자 입력값

	public void menu() throws IOException {
		System.out.println("JAVA FILE EDITOR v. 0.1");
		System.out.println("1.신규   2.파일 열기   3.종료");
		System.out.print(">> 선택 : ");

		is = System.in;
		switch (is.read()) {
		case '1':
			newFile();
			break;
		case '2':
			openFile();
			break;
		case '3':
			System.out.println("> 프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("\n 1 ~ 4 중에 선택해 주세요.\n");
			break;
		}// End case
	} // End menu

	public void newFile() throws IOException { // 신규 파일 작성

		setFileName();

	}

	public void openFile() throws IOException { // 기존 파일 열기

		// 파일명을 입력 받고, 사용자가 입력한 내용을 화면으로 출력 >> FIS
		// 파일 내용 추가 or 변경(덮어쓰기) 선택 가능하도록 처리 후 구현 >> FOS
		setFileName();

		// 파일 존재여부 확인
		File f = new File(path + "\\" + file); // 파일 객체 생성

//		if (f.exists()) { // 파일이 존재하지 않으면 (기본값은 false 이기 때문)
//			System.out.println(">> 해당 디렉토리에 지정한 파일이 없습니다.");
//			return;
//		}
		System.out.println(">> 파일 내용 : ");
		
		FileInputStream fis = new FileInputStream(file);
		int input = 0;
		while ((input = fis.read()) != -1) {
			System.out.print((char) input);
		}
		fis.close();

		System.out.println(">> 1.내용 추가  2.내용 변경(덮어쓰기)  3.종료");
		System.out.print(">> 선택 : ");
		FileOutputStream fos = null;
		switch (is.read()) {
		case '1':		//파일에 내용 추가하기
			fos = new FileOutputStream(f, true);	//append 추가 true 설정
			System.out.println(">> 추가할 내용 입력(종료는 Ctrl+z)");
			break;
		case '2':		//파일 내용 변경(덮어쓰기)
			fos = new FileOutputStream(f);
			System.out.println(">> 변경할 내용 입력(종료는 Ctrl+z)");
			break;
		case '3':
			System.out.println("> 프로그램을 종료합니다.");
			System.exit(0);
			break;
		default: break; 
		}
		is.skip(2);
		int contents = 0;
		while ((contents = is.read()) != -1) {	//키보드에서 하나 읽어서
			fos.write(contents);	//파일에 쓰기
		}
		fos.close();
		System.out.println("파일 편집 완료!!");

	}// End openFile

	public void setFileName() throws IOException { // 파일명과 경로명 입력받기

//		is.read();	//입력 버퍼에 들어있는
//		is.read();	//CF, LF 값 처리하는 방식 1

		is.skip(2); // 방식 2 CF, LF 두 개를 무시한다

		System.out.print("파일명 : ");
		byte[] inputBytes = new byte[100];
		is.read(inputBytes); // 파일명 입력받기
		file = new String(inputBytes).trim();

		// 입력 배열 초기화
		inputBytes = new byte[100];
		System.out.print("경로명 (미입력 시 현재 디렉토리) : ");
		is.read(inputBytes);
		path = new String(inputBytes).trim();

		// 경로명 확인
		if (path == null || path.equals("")) {
			path = "."; // 현재 디렉토리
		}
	}

	public static void main(String[] args) throws IOException {
		// makeBackup 메소드 호출
		new FileEditor().menu();

	}
}