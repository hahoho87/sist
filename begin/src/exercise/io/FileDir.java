package exercise.io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDir {

	public void dir() {
		File f = new File(".");
		File f2 = new File("c:\\");
		String[] list = f.list();
		int fileCount = 0;
		int dirCount = 0;
		long fileSum = 0;
		// 해당 디렉토리의 파일과 디렉토리들의 목록
		// 단, 디렉토리일 경우 <DIR>을 표시하고
		// 파일인 경우 파일의 크기를 표시
		for (String s : list) {
			File file = new File(s);
			long lastModified = file.lastModified();
			String pattern = "yyyy-MM-dd   aa hh:mm";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date lastModifiedDate = new Date(lastModified);
			System.out.print(simpleDateFormat.format(lastModifiedDate) + "\t");
			if (file.isDirectory()) {
				System.out.print("<DIR>\t\t");
				dirCount++;
			} else if (file.isFile()) {
				System.out.print("\t" + file.length() + "\t");
				fileCount++;
				fileSum = file.length() + fileSum;
			}
			System.out.printf("%-12s\t", s);
			System.out.println();
		}
		System.out.print("\t\t\t" + fileCount + "개 파일");
		System.out.println("\t\t" + fileSum + " 바이트");
		System.out.print("\t\t\t" + dirCount + "개 디렉터리");
		System.out.println("\t" + f2.getTotalSpace() + "바이트 남음");

	}

	public static void main(String[] args) {
		new FileDir().dir();

	}

}
