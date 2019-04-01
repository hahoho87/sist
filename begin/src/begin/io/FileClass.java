package begin.io;

import java.io.File;
import java.io.IOException;

public class FileClass {

	public static void main(String[] args) {
		File f = new File(".");
		String[] list = f.list();
		// 해당 디렉토리의 파일과 디렉토리들의 목록
		// 단, 디렉토리일 경우 <DIR>을 표시하고
		// 파일인 경우 파일의 크기를 표시
		for (String s : list) {
			System.out.printf("%-12s\t",s);
			File file = new File(s);
			if (file.isDirectory()) {
				System.out.print("<DIR>");
			} else if (file.isFile()) {
				System.out.print("\t" + file.length());
			}
			System.out.println();
		}
	}// End main

}// End class
