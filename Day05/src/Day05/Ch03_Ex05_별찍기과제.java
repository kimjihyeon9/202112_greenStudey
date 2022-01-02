package Day05;

import java.util.Scanner;

public class Ch03_Ex05_별찍기과제 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// -1을 입력하면 그만, 아니면 계속 반복
		// 크기 >> 5
		// *****
		// **  *
		// * * *
		// * * *
		// *****

		// *****
		// ** **
		// *   *
		// ** **
		// *****

		// 크기 >> 7
		// *******
		// **    *
		// * *   *
		// *  *  *
		// *   * *
		// *    **
		// *******

		// *******
		// * * * *
		// **   **
		// *     *
		// **   **
		// * * * *
		// *******

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
		
		while (size % 2 == 0 || (size < 5 || size > 15)) {
			try {
				if (size < 5 || size > 15) {
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
		
		while(true) {
			if(!(size == -1)) {
				
				int end = size / 2 + 1;
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						System.out.print(i == j || i * j == 0 || i == size - 1 || j == size -1 ? "*" : " ");
					}
					System.out.println();
					end = i < size / 2 ? end + 1 : end - 1;
				}
				System.out.println();
				
//		end = 0;
//		for(int i = 0; i < 9; i++) {
//			for(int j = 0; j < 9; j++) {
//				System.out.print(i == j || i * j == 0 || i == 8 || j == 8 ? "*" : " ");
//			}
//			System.out.println();
//			end = i < 4 ? end + 1 : end - 1;
//		}
				
				end = size/2 + 1;
				for(int i=0; i<size; i++) {
					for(int j=0; j<size; j++) {
						System.out.print(j>=end && j<size-end? " " : "*");
					}
					System.out.println();
					end = i<size/2 ? end-1:end+1;
				}
				System.out.print("크기입력(홀수만)>>> ");
				size = scan.nextInt();
				continue;
				
			} else {
				System.out.println("종료");
				break;
			}
		}
	}
}
