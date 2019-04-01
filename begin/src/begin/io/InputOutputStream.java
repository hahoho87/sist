package begin.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputOutputStream {
	
	private static void testOutputStream() throws IOException {
		System.out.write(65);
		System.out.write('A');
		System.out.write(97);
		System.out.write('a');
		
		OutputStream os = System.out;
		os.write('Z');
		os.flush();		//출력스트림 버퍼 비우기
		os.close();		//출력스트림 닫기
		
		System.err.println("error!!!");	//표준 에러
	}

	public static void testInputStream2() throws IOException {
		System.out.print("단어를 입력하고 엔터를 누르세요. (종료는 Ctrl + z) : ");
		InputStream is = System.in;
		int input = 0;
		while ((input = is.read()) != -1) {
			if (input == 10) { // Carriage return
				System.out.print("단어를 입력하고 엔터를 누르세요. (종료는 Ctrl + z) : ");
				continue;
			} else if (input == 13) { // Line feed
				continue;
			}
			System.out.println((char) input + " : " + input);
		}
		is.close();
	}

	public static void testInputStream() {
//		System.out.print("문자 하나를 입력하세요 : ");
//		InputStream is = System.in;
//		int input = 0;
//		try {
//			input = is.read();
//			System.out.println("입력 값 : " + input);
//			System.out.println("입력 문자 : " + (char)input);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally	{
//			try {
//				if (is != null) is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

	public static void main(String[] args) throws IOException {
//		testOutputStream();
		testInputStream2();
//		testInputStream();
		
//		System.out.print("문자 하나를 입력하세요 : ");
//		byte[] inputBytes = new byte[5];
//		int input = System.in.read(inputBytes);
//		for (byte b : inputBytes ) {
//			System.out.println(b + " : " + (char)b);
//		}


	}// End main



}// End class
