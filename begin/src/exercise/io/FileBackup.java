package exercise.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileBackup {

	private String file;
	private String path;

	// 파일명과 경로명을 입력받아 file 변수에 저장하는
	// readName 메소드 작성
	public void readName() throws IOException {

		byte[] inputBytes = new byte[100];
		InputStream is = System.in;
		System.out.print("파일명 : ");
		is.read(inputBytes); // 파일명 입력받기
		file = new String(inputBytes).trim();

		// 입력 배열 초기화
		inputBytes = new byte[100];
		System.out.print("경로명 (미입력 시 c:\\javawork) : ");
		is.read(inputBytes);
		path = new String(inputBytes).trim();

		// 경로명 확인
		if (path == null || path.equals("")) {
			path = "."; // 현재 디렉토리
		}
		System.out.println(path + "\\" + file);
	}

	// 입력받은 파일명으로 백업파일을 생성하는 makeBackup 메소드 작성
	// 단, 경로명에 지정하지 않은 경우 현재 디렉토리를 기본으로 처리
	// c:\javawork를 기본으로 처리
	// 백업된 파일은 원파일명.bak로 생성
	// ex) 원본 : abc.txt >> 백업 : abc.txt.bak
	private void makeBackup() {
		System.out.println("파일 백업을 시작합니다.");
		try {
			readName();
		} catch (IOException e) {
			e.printStackTrace();
		} // 이름과 경로명을 입력받는 메소드 호출
			// 지정된 파일을 읽어서

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(path + "\\" + file);
			// 읽어 올 파일과 연결된 스트림
			// 백업 파일 생성
			fos = new FileOutputStream(path + "\\" + file + ".bak"); // 쓸 파일과 연결된 스트림

			int input = 0;
			while ((input = fis.read()) != -1) {
				fos.write(input);
			}
			System.out.println("파일 백업이 완료되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("지정하신 파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// makeBackup 메소드 호출
		FileBackup f = new FileBackup();
		f.makeBackup();

	}

}
