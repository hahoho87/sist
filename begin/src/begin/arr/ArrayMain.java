package begin.arr;

public class ArrayMain {

	public static void main(String[] args) {
		//배열
		//	같은 자료형끼리 모아두는 하나의 묶음
		//	여러개의 저장 공간을 하나의 이름으로 엑세스
		//	저장된 데이터의 위치는 인덱스를 사용
		//
		//	한 번 생성된 이후에 크기 변경 불가
		//
		//	자바에서 배열은 객체로 인식
		//	-> 멤버 변수(lenth)와 메서드를 가짐
		//
		//	1차원부터 무한대 다차원 배열 생성 가능 
		//	-> [5][4]는 5행 4열 짜리 2차원 배열
		
		//1차원 배열 선언
		//선언	데이터타입[] 변수명;
		//		데이터타입     변수명[];
		int[] datas;
		
		//1차원 배열 생성
		//	배열변수명 = new 데이터타입[배열의크기];
		datas = new int[5];
		
		//1차원 배열의 초기화
		datas[0] = 3;
		datas[1] = 4;
		datas[2] = 5;
		datas[3] = 6;
		datas[4] = 7;
//		datas[5] = 8;	//5개의 데이터를 0번부터 생성했기 때문에 n-1까지 존재
		
		//1차원 배열의 선언 및 생성
		char[] chs = new char[4];
		
		//생성된 배열의 초기화
		chs[0] = 'j';
		chs[1] = 'a';
		chs[2] = 'v';
		chs[3] = 'a';
		
		
		///////////////////////////////////////////////////////////
		//1차원 배열의 선언, 생성 및 초기화
		double[] doubles = new double[]	{1.1, 2.2, 3.3}	;
		
		boolean[] tf = {true, false};
		
//		doubles = { 4.4, 5.5 };		//생성과 초기화를 동시에 할 때에는 추가가 불가능
		
		///////////////////////////////////////////////////////////
		
		
		//for문 사용으로 화면에 java출력
		for(int j=0 ; j<4 ; j++)	{
			System.out.print(chs[j]);			
		}	System.out.println();
			System.out.println();
		
		
		
//		System.out.println(datas);	//배열은 이름만으로는 쓸 수 없음
		System.out.println(datas[0]);
		System.out.println(datas[1]);
		System.out.println(datas[2]);
		System.out.println(datas[3]);
		System.out.println(datas[4]);
		System.out.println();
		
		//for문을 사용해서 출력
		for(int i=0 ; i<5 ; i++)	{
			System.out.println(datas[i]);
		}
		System.out.println();
		
		
		//배열의 길이(length) 출력
		
		System.out.println("datas : " + datas.length);
		System.out.println("chs : " + chs.length);
		System.out.println("doubles : " + doubles.length);
		System.out.println("tf : " + tf.length);
		
		/////////////////////////////////////////////
		System.out.println("---------------------------");
		System.out.println();
		
		//2차원 배열
		//데이터타입[][]	변수형;
		//데이터타입		변수명[][];
		
		//고정 길이 2차원 배열
		//선언	int[][] test;
		//생성	test = new int[행의 갯수][열의 갯수];
		//초기화 test[행번호][열번호] = 값;
		
		
		int[][] test;
		test = new int[2][3];
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		test[1][0] = 500;
		test[1][1] = 600;				
		test[1][2] = 700;		
		
		
		//2차원 배열의 선언 및 생성
		int[][] nums = new int[2][3];
		
		//2차원 배열의 선언, 생성 및 초기화
		int[][] numArr = new int[][] { {100, 200, 300},
									   {500, 600, 700} };
		int[][] numArrs = { {100, 200, 300},
				            {500, 600, 700} };
		
		
		for(int i=0 ; i<numArr.length ; i++)	{
			
		}
		
										 
		System.out.println(numArr.length);			//행의 개수
		System.out.println(numArr[0].length);		//각 행의 열의 개수
		System.out.println(numArr[1].length);
		
		for (int i=0 ; i<numArr.length ; i++)	{
			for (int j=0 ; j<numArr[i].length ; j++)	{	//numArr[i]행의 길이를 기준
				System.out.print(numArr[i][j]+" ");
			}
			System.out.println(); 							//밖에서 한칸 띄워주면 다시 i로 돌아가기 전에 한칸 띔
		}
			
		
		////////////////////////////////////////
		System.out.println("---------------------");
		
		//가변 길이 2차원 배열
		//2차원 배열에서
		//각 1차원배열들의 길이를 다르게 지정하여 배열 생성
		
		//선언	데이터타입[][]	변수명;
		//생성	변수명 = new 데이터타입[행의 개수][];
		//		변수명 [행번호] = new int[열의 개수];
		//		변수명 [행번호] = new int[열의 개수];
		//초기화 	변수명 [행번호][열번호]	= 데이터;
		//		변수명 [행번호][열번호]	= 데이터;
		
		
		String[][] list;
		list = new String[2][];
		list[0] = new String[3];
		list[1] = new String[4];
		
		list[0][0] = "Kim";
		list[0][1] = "Lee";
		list[0][2] = "Ahn";
		
		list[1][0] = "Red";
		list[1][1] = "Yellow";
		list[1][2] = "Blue";
		list[1][3] = "Green";
		
		
		//선언 및 생성	데이터타입[][] 변수명 = new 데이터타입[행의 개수][];
		String[][] lists = new String[2][];
		lists = new String[][] { {"Kim", "Lee", "Ahn"}, 
								 {"Red", "Yellow", "Blue", "Green"} };
								
		//선언, 생셩 및 초기화
		String[][] listt = { {"Kim", "Lee", "Ahn"}, 
							 {"Red", "Yellow", "Blue", "Green"} };
		
		
		for(int i=0 ; i<list.length ; i++)	{
			for(int j=0 ; j<list[i].length ; j++)	{
				System.out.print(list[i][j] + "\t");
			}	System.out.println();
			
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//End main

}//End class
