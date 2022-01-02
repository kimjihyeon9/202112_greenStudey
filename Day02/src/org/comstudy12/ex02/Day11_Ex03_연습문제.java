package org.comstudy12.ex02;

public class Day11_Ex03_연습문제 {
	public static void main(String[] args) {
		
		for(int i = 1; i < 10; i += 2) {
			System.out.print(i + " ");
		}
		
		// 3번
//		int sum = 0, i = 1;
//		while(i < 100) {
//			if(i % 3 != 0) {
//				i++;
//				
//			}
//			else sum += i;
//			i++;
//		}
		
		// 4번
		int sum = 0, i = 1;
		while (true) {
			if(i > 50) break;
			sum += i;
			i++;
		}
		System.out.println(sum);
		
		// 7번
		char c[] = new char[10];
//		int i[] = {0, 1, 2, 3, 4, 5};
		char day[] = {'일', '월', '화', '수', '목', '금', '토'};
		
		
		
	}
}
