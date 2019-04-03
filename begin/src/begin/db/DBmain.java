package begin.db;

import java.util.List;
import java.util.Scanner;

public class DBmain {

	public static void main(String[] args) {
		RegionsDAO rdao = new RegionsDAO();
		Scanner scan = new Scanner(System.in);
		System.out.println("Regions 테이블 조회");
		System.out.println("1. region id");
		System.out.println("2. 전체 목록 출력 ");
		System.out.println(">> 선택 : ");

		int input = 1;
		if (input == 2) {
			Regions region = rdao.selectOne(4);
			System.out.println("region id : " + region.getRegionID());
			System.out.println("region name : " + region.getRegionName());
		} else if (input == 1) {
			List<Regions> r = rdao.selectAll();
			System.out.println();
//				System.out.println(region);
//				System.out.println("region id  : " + region.getRegionID());
//				System.out.println("region name : " + region.getRegionName());
		}
	}
}
