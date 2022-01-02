package weekendStudy;

import java.util.Arrays;

public class Ex01 {

	public static void main02(String[] args) { // 2번
		int[][] arr = new int[3][4];
		int arr1 = (int)(Math.random() * 10);
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				
				System.out.print(arr);
			}
		}
		
	}
	
	public static void main03(String[] args) {
		int[] arr = new int [10];
		int r = (int)(Math.random() * 10);
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 1; j < arr.length; j++) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] score = {{100, 100, 100}, {20, 20, 20}, {30, 30, 30}, {40, 40, 40}, {50, 50, 50}};
		int[][] sum = new int[6][4];
		int a = 0;
		
//		for(int i = 0; i < 3; i++) {
//			a += score[0][i];
//		}
//		System.out.println(a); // 300
//		System.out.println();
//		a = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				a += score[i][j]; // 300
				sum[i][3] = a;
			}
//			System.out.println(Arrays.toString(sum));
			System.out.println(a);
			a = 0;
		}
	}

}










