package begin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderWriter {

	public static void main(String[] args) {
		String file = "bbb.txt";
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write("This is BufferedFileWriter");
			bw.newLine();
			bw.write("한글도 되니?");
			bw.newLine();
			bw.append("이것은 추가 문장");
			
			bw.close();
			fw.close();
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String input = null;
			while ((input = br.readLine()) != null)	{
				System.out.println(input);
			}
			
			br.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("----------------");
		//키볻 입력을 BufferdReader로 연결
		System.out.print("입력 : ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String data = null;
		try {
			data = br2.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("입력값 : " + data);
		
		

	}//End main()

}//End class
