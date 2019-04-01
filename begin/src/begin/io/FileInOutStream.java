package begin.io;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileInOutStream {

	public static void readFile() throws IOException {
		String file = ".classpath";
		FileInputStream fis = new FileInputStream(file);
		int input = 0;
		while ((input = fis.read()) != -1) {
			System.out.print((char) input);
		}
		fis.close();
	}

	private static void writeFile() throws IOException {
		String file = "out.txt";
		String contents = "file write stream 파일에 쓰기";
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(contents.getBytes());
		fos.close();
	}

	private static void writeFile2() throws IOException {

		
	
		// 입력된 파일명으로 입력된 내용을 저장한 후

		byte[] inputBytes = new byte[100];
		InputStream is = System.in;
		System.out.print("파일명 : ");
		is.read(inputBytes);	//파일명 입력받기
		String file = new String(inputBytes).trim();
		FileOutputStream fos = new FileOutputStream(file);
		
		
		System.out.println("저장할 내용을 입력해주세요.(종료는 Ctrl + z)");
		int input = 0;
		while ((input = is.read()) != -1) {	//키보드에서 하나 읽어서
			fos.write(input);	//파일에 쓰기
		}
		fos.close();
		System.out.println("저장이 완료되었습니다.");
		
		FileInputStream fis = new FileInputStream(file);
		input = 0;
		while ((input = fis.read()) != -1) {
			System.out.print((char) input);
		}
		fis.close();
		
	}

	public static void main(String[] args) throws IOException {
//		readFile();
//		writeFile();
		writeFile2();

	}

}
