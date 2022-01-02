package Day13_levelup;

import java.util.Scanner;

public class Levelup_01 {
	// 별출력 프로그램
	// - 별 또는 공백이 반복 한번에 한개씩 출력
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main01(String[] args) {
		// *		: 0, 1
		// **		: 1, 2
		// ***		: 2, 3
		// ****		: 3, 4
		// *****	: 4, 5
		
//		for(int i = 0; i < 5; i++) {
//			for(int j = 0; j < 5; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		// 앞의 이중for문과 동일
//		for(int i = 1; i <= 25; i++) {
//			System.out.print("*");
//			if(i % 5 == 0) {
//				System.out.println();
//			}
//		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main02(String[] args) {
		// *****	0 : 5
		// ****		1 : 4
		// ***		2 : 3
		// **		3 : 2
		// *		4 : 1
		
		for(int i = 5; i > 0; i--) {
			for(int j = 0; j <= i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main03(String[] args) {
		// *		0 : 1
		// **		1 : 2
		// ***		2 : 3
		// ****		3 : 4
		// *****	4 : 5
		// ****		5 : 4
		// ***		6 : 3
		// **		7 : 2
		// *		8 : 1
		
		int end = 1;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < end; j++) {
				System.out.print("*");
			}
			System.out.println();
			end = i < 4 ? end + 1 : end - 1;
		}
		
		// 내가 한것
/*		int i = 0;
		while(true) {
			if(i < 5) {
				for(i = 0; i < 5; i++) {
					for(int j = 0; j < i + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			} else if(i == 5) {
				for(i = 5; i > 0; i--) {
					for(int j = 0; j <= i - 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			}
		}
*/		
	}
	
	public static void main04(String[] args) {
		// ^^^^*
		// ^^^**
		// ^^***
		// ^****
		// *****
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(j < 4 - i ? " " : "*");
			}
			System.out.println();
		}
	}
	
	public static void main06(String[] args) {
		// *****	0 : 0
		// ^****	1 : 1
		// ^^***	2 : 2
		// ^^^**	3 : 3
		// ^^^^*	4 : 4
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(j < i ? " " : "*");
			}
			System.out.println();
		}
	}
	
	public static void main07(String[] args) {
		// ^^^^*	0 : 4
		// ^^^**	1 : 3
		// ^^***	2 : 2
		// ^****	3 : 1
		// *****	4 : 0
		// ^****	5 : 1
		// ^^***	6 : 2
		// ^^^**	7 : 3
		// ^^^^*	8 : 4
		
		int end = 4;
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(j < end ? " " : "*");
			}
			end = i < 4 ? end - 1 : end + 1;
			System.out.println();
		}
	}
	
	public static void main08(String[] args) {
		// 		*		0 : 1
		//	   ***		1 : 3
		//	  *****		2 : 5
		//	 *******	3 : 7
		//  *********	4 : 9
		
		for(int i = 0; i < 5; i++) {
			// 공백출력
			for(int j = 0; j < 4 - i + i * 2 + 1; j++) {
				System.out.print(j < 4 - i ? " " : "*");
			}
			System.out.println();
		}
		
/*		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(j < 5 - i ? " " : "*");
			}
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
*/
	}
	
	public static void main09(String[] args) {
		//  *********	4 : 9
		//	 *******	3 : 7
		//	  *****		2 : 5
		//	   ***		1 : 3
		// 		*		0 : 1
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 9 - i; j++) {
				System.out.print(j < i ? " " : "*");
			}
			System.out.println();
		}
		
/*		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 9 - i*2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
*/

/*		for(int i = 0; i < 5; i++) { // 열
			for(int j = 0; j < 5; j++) { // 행
				System.out.print(j < i ? " " : "*");
			}
			for(int j = 0; j < 4 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
*/
	}
	
	public static void main10(String[] args) {
		// 		*		0 : 1
		//	   ***		1 : 3
		//	  *****		2 : 5
		//	 *******	3 : 7
		//  *********	4 : 9
		//	 *******	5 : 7
		//	  *****		6 : 5
		//	   ***		7 : 3
		// 		*		8 : 1
		
/*		int end = 1;
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 5 - end; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < end * 2 - 1; j++) {
				System.out.print("*");
			}
			end = i < 4 ? end + 1 : end - 1;
			System.out.println();
		}
*/
		int end = 4;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9 - end; j++) {
				System.out.print(j < end ? " " : "*");
			}
			System.out.println();
			end = i < 4 ? end - 1 : end + 1;
		}
	}
	
	public static void main11(String[] args) {
		//  *********	4 : 9
		//	 *******	3 : 7
		//	  *****		2 : 5
		//	   ***		1 : 3
		// 		*		0 : 1
		//	   ***		1 : 3
		//	  *****		2 : 5
		//	 *******	3 : 7
		//  *********	4 : 9

		
	}

	public static void main(String[] args) {
		//  *********	4 : 9
		//  **** ****	4 : 9
		//	***   ***	3 : 7
		//	**     **	2 : 5
		//	*       *	1 : 3
		// 	**     **	0 : 1
		//	***   ***	1 : 3
		//	**** ****	2 : 5
		//	*********	3 : 7
		
		int size = 0;
		while (true) {
			try {
				System.out.print("크기입력(홀수만)>>> ");
				size = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력 하세요!");
				scan.next();
				continue;
			}
		}
		// 유효성 검사 : 5이상 15이하 값만 허용, 홀수만 입력 받을것.
		while(size%2==0 || (size < 5 || size >15)) {
			try {
				if(size < 5 || size >15){
					System.out.println("5이상 15이하 값만 입력하세요!");
					System.out.print("크기입력(홀수만)>>> ");
					size = scan.nextInt();
					continue;
				}
				System.out.println("홀수만 입력 하세요!");
				System.out.print("크기입력(홀수만)>>> ");
				size = scan.nextInt();
			} catch (Exception e) {
				System.out.println("숫자만 입력 하세요!");
				scan.next();
				size = 0;
				continue;
			}
		}
		int end = size/2 + 1;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(j>=end && j<size-end? " " : "*");
			}
			System.out.println();
			end = i<size/2 ? end-1:end+1;
		}
		
/*		int em = 0;
	      for (int i = 0; i < 9; i++) {
	         for (int j = 0; j < 9; j++) {
	            // 4열을 기준으로 em만큼 떨어진 범위를 &&연산으로 지정하여
	            // 그 범위만큼 공백을 출력하고 그외에는 별을 출력
	            System.out.print((j > (4 - em)) && (j < (4 + em)) ? " " : "*");
	         }
	         System.out.println();
	         // i가 보다 작을땐 em이 0부터 1씩 증가하고 4초과일때 1씩 감소하도록 정의
	         em = i < 4 ? em + 1 : em - 1;
	      }
*/
		
/*		while(true) {
			if(size > 15 || size < 5 || size % 2 != 1) {
				System.out.println("범위에 없는 숫자 입니다");
				System.out.println("5이상 15이하 값만 입력하세요!");
				System.out.print("크기입력(홀수만)>>> ");
				size = scan.nextInt();
			} else {
				int end = size / 2 + 1;
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						System.out.print(j >= end && j < size - end ? " " : "*");
					}
					System.out.println();
					end = i < size / 2 ? end - 1 : end + 1;
				}
				break;
			}
		}
*/
	}
}
