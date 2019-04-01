package exercise.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BuffuredInOutStream {

	public void bufferedInput() {
		// 파일명을 입력받아 화면에 출력

		byte[] inputBytes = new byte[100];
		InputStream is = System.in;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		// 입력한 파일이 존재하지 않는 경우 안내 메시지 출력
		// 스트림은 사용 후 예외 발생 여부 관계없이 닫기 처리
		try {
			System.out.print("파일명 : ");
			is.read(inputBytes);
			String file = new String(inputBytes).trim();
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			int input = 0;
			while ((input = bis.read()) != -1) {
				System.out.print((char) input);
			}
		} catch (FileNotFoundException e) {
			System.out.println("입력하신 파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { // 스트림을 열었을 때와 반대의 순서로 닫아줌
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// End bufferedInput()

	public void bufferedOutput() {
		String filename = ".\\buffered.txt";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream(filename);
			// 버퍼의 크기를 5로 지정
			bos = new BufferedOutputStream(fos, 5);
			
			for (int i = '1'; i <= '9'; i++) {	//char로 변환해서 써야 123456789로 출력
				bos.write(i);
			}
			bos.flush();//버퍼를 지정한 경우
						//버퍼가 꽉 차거나, 스트림을 닫지 않으면
						//버퍼를 스트림에 쓰지 않기 때문에
						//flush()를 사용		
			
			System.out.println("파일에 쓰기 완료!!");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			try { // 스트림을 열었을 때와 반대의 순서로 닫아줌
//				if (bos != null)
//					bos.close();
//				if (fos != null)
//					fos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}

	public static void main(String[] args) throws IOException {
		// bufferedInput 메소드 호출
		BuffuredInOutStream bis = new BuffuredInOutStream();
		bis.bufferedInput();

//		bis.bufferedOutput();
	}

}
