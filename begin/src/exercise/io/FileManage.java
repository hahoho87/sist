package exercise.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManage {

	private FileReader fr; // 파일에서 읽어올 캐릭터 스트림
	private FileWriter fw; // 파일에 저장할 캐릭터 스트림
	private BufferedReader br; // 파일 입력 스트림과 연결할 버퍼 스트림
	private BufferedWriter bw; // 파일 출력 스트림과 연결할 버퍼 스트림
	private BufferedReader reader; // 키보드 입력을 받을 버퍼 스트림

	private String filename;
	private String path;
	private String copyFilename;
	private String copyPath;
	private File file;
	private File copyFile;
	private File dir;
	private String input;
	private boolean copyFlag; // 복사 처리용 플래그 변수

	public void menu() { // A.메뉴출력
		reader = new BufferedReader(new InputStreamReader(System.in));

		// 1.신규 2.열기 3.복사 4.삭제 5.목록보기 6.종료
		System.out.println("------ JAVA FILE MANAGER v. 0.1 -----");
		System.out.println("1.신규   2.열기   3.복사  4.삭제  5.목록보기  6.종료");
		System.out.print(">> 선택 : ");

		try {
			switch (reader.readLine()) {
			case "1":
				newFile();
				break;
			case "2":
				openFile();
				break;
			case "3":
				copyFile();
				break;
			case "4": // 완료
				deleteFile();
				break;
			case "5": // 완료
				dir();
				break;
			case "6": // 완료
				System.out.println(">> 프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("\n 1 ~ 6 중에 선택해 주세요.\n");
				menu();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} // End case
	} // End menu

	public void setFileName() {// B.이름 입력받기
		reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("파일명 : ");

		if (copyFlag == false) {
			try {
				filename = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				copyFilename = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("경로명 (미입력 시 현재 디렉토리) : ");
		if (copyFlag == false) {
			try {
				path = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				copyPath = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			copyFlag = false; // 파일 사본명과 경로를 받은 후에 다시 false 설정
		}

		// 경로명 확인
		if (path == null || path.equals("")) {
			path = "."; // 현재 디렉토리
		}
		if (copyPath == null || copyPath.equals("")) {
			copyPath = "."; // 현재 디렉토리
		}
		if (copyFilename == null || copyFilename.equals("")) {
			copyFilename = filename;
		}
	}

	public void newFile() {
		// 입력받은 경로명이 존재하지 않는 경우
		// 해당 디렉토리에 생성 (mkr? 메소드)
		System.out.println(">> 신규 파일 작성");
		setFileName();

		dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		try {
			fw = new FileWriter(path + "\\" + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		System.out.println("저장할 내용을 입력해주세요. (종료는 Ctrl+Z)");

		try {
			while ((input = br.readLine()) != null) { // 키보드에서 하나 읽어서
				bw.write(input); // 파일에 쓰기
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.flush();
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("파일 생성이 완료되었습니다.");
	}

	public void openFile() {
		// 파일 내용 확인 후
		// 이름 변경 기능 추가

		setFileName();
		// 파일 존재여부 확인
		file = new File(path + "\\" + filename); // 파일 객체 생성

		if (!file.exists()) { // 파일이 존재하지 않으면
			System.out.println(">> 해당 디렉토리에 지정한 파일이 없습니다.");
			return;
		}
		System.out.println(">> 파일 내용 : ");
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while ((input = reader.readLine()) != null) {
				System.out.println(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println(">> 1.내용 추가  2.내용 변경(덮어쓰기)  3.이름 변경  4.종료");
		System.out.print(">> 선택 : ");

		reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			switch (reader.readLine()) {
			case "1": // 파일에 내용 추가하기
				fw = new FileWriter(file, true);
				bw = new BufferedWriter(fw);
				System.out.println(">> 추가할 내용 입력(종료는 Ctrl+z)");
				while ((input = reader.readLine()) != null) { // 키보드에서 하나 읽어서
					bw.append(input); // 파일에 쓰기
					bw.newLine();
				}
				System.out.println(">> 파일 내용 추가 완료");
				break;
			case "2": // 파일 내용 변경(덮어쓰기)
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				System.out.println(">> 변경할 내용 입력(종료는 Ctrl+z)");
				while ((input = reader.readLine()) != null) {
					bw.write(input);
					bw.newLine();
				}
				System.out.println(">> 파일 내용 변경 완료");
				break;
			case "3":
				System.out.println(">> 변경할 파일명 입력");
				file = new File(path + "\\" + filename);
				input = reader.readLine();
				file.renameTo(new File(input));
				System.out.println(">> 파일명 변경 완료!");
				break;
			case "4":
				System.out.println(">> 프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.flush();
				}
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void copyFile() throws IOException {

		// 다른 디렉토리면 원래 이름으로
		// 동일 경로 내에 동일명으로 복사하는 경우
		// "원본파일 - 복사본.확장자" 의 형태로 지정 (lastindex 어쩌구 사용)

		copyFlag = true; // 파일 복사 상태 설정
		System.out.println(">> 파일 복사를 시작합니다.");
		System.out.println("원본 ");
		setFileName(); // 원본 파일명과 경로명 입력
		System.out.println("사본 ");
		setFileName(); // 사본 파일명과 경로명 입력

		// 사본 경로가 존재하는지 확인
		// 경로가 존재하면
		// fr br 을 통해 읽어와서 fw bw를 통해 써서 복사완료
		dir = new File(copyPath);
		if (!dir.exists()) {
			System.out.println("입력하신 경로가 존재하지 않습니다.");
			return;
		}

		file = new File(path + "\\" + filename);

		String rename = filename.substring(filename.lastIndexOf("."));

		if (filename.equals(copyFilename) && path.equals(copyPath)) {
			copyFile = new File(copyPath + "\\" + copyFilename.replace(rename, "-복사본" + rename));
		} else {
			copyFile = new File(copyPath + "\\" + copyFilename);
		}

		fr = new FileReader(file); // 원본 파일
		br = new BufferedReader(fr);
		fw = new FileWriter(copyFile); // 사본 파일
		bw = new BufferedWriter(fw);

		// 파일명이 같고 디렉토리도 같은 경우 -> 복사본
		// 파일명이 다르고 디렉토리도 다른 경우
		// 파일명이 같고 디렉토리가 다른 경우
		// 파일명이 다르고 디렉토리는 같은 경우

		while ((input = br.readLine()) != null) {
			bw.write(input);
			bw.newLine();
		}
		System.out.println("파일 복사 완료");
		bw.close();
		fw.close();
		br.close();
		fr.close();

	}// End copyFile

	public void deleteFile() {
		// 지정한 파일과 경로가 존재하면 삭제
		System.out.println(">> 파일 삭제를 시작합니다.");
		setFileName();
		file = new File(path + "\\" + filename);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println(">> 파일 삭제가 완료되었습니다.");
			} else {
				System.out.println("지정하신 파일이 없습니다.");
			}
		}
	}

	public void dir() {
		// 현재 디렉토리도 표시
		reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("경로명 (미입력 시 현재 디렉토리) : ");
		try {
			path = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 경로명 확인
		if (path == null || path.equals("")) {
			path = "."; // 현재 디렉토리
		}

		File f = new File(path);
		File[] list = f.listFiles();

		int fileCount = 0;
		int dirCount = 0;
		long fileSum = 0;
		try {
			System.out.println(f.getCanonicalPath() + ">dir");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (File file : list) {
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			System.out.print(simpleDate.format(new Date(file.lastModified())) + "\t");

			if (file.isDirectory()) {
				System.out.print("<DIR>\t\t");
				dirCount++;
			} else if (file.isFile()) {
				System.out.print("\t" + file.length() + "\t");
				fileCount++;
				fileSum = file.length() + fileSum;
			}
			System.out.printf("%-12s\t", file.getName());
			System.out.println();
		}
		System.out.print("\t\t\t" + fileCount + "개 파일");
		System.out.println("\t\t" + fileSum + " 바이트");
		System.out.println("\t\t\t" + dirCount + "개 디렉토리");
		try {
			System.out.println(f.getCanonicalPath() + ">");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileManage().menu();

	}

}
