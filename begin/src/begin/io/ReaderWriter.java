package begin.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {

	public void reader() {
		// FileInputStream을 이용하여 abc.txt 파일의 내용을 화면에 출력
		FileInputStream fis = null;
		System.out.println("-----------");
		FileReader reader = null;
		int input = 0;
		try {
			reader = new FileReader(".\\abc.txt");
			while ((input = reader.read()) != -1) {
				System.out.print((char) input);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close(); // finally 사용해서 예외가 발생하거나 하지 않거나 항상 닫음
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// End reader

	public void writer()	{
		FileWriter fw = null;
		try	{
			fw = new FileWriter(".\\abc.txt");
			fw.write("안녕?????");
			fw.close();
		} catch (IOException e)	{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ReaderWriter rw = new ReaderWriter();
		rw.reader();
		rw.writer();
	}
}
