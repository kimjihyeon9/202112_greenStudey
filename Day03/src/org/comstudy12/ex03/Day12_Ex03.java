package org.comstudy12.ex03;

import java.io.IOException;
import java.util.Scanner;

public class Day12_Ex03 {
	public static void main01(String[] args) {
		// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
		// while 문으로 구현하기
		
		final int MAX = 10;
		
		// 누적하는 변수는 0으로 초기화
		int sum = 0; // 1부터 10까지 누적
		int num = 1; // 1부터 10까지 하나씩 증가 용도
		
		while(num <= MAX) {
			sum += num;
			System.out.print(num);
			System.out.print(num != MAX ? "+" : "=");
			num++;
		}
		System.out.println(sum);
	}
	
	public static void main02(String[] args) {
		// 1 + 2 - 3 + 4 - 5 + 6 - 7 + 8 - 9 + 10 = 7
		final int MAX = 10;
		final int MIN = 1;
		int sum = 0;
		int num = MIN;
		
		// 1. 1~10까지 출력 (num을 증가하면서 출력한다)
		while(num <= MAX) {
			System.out.print(num);
			if(num % 2 != 0) {
				System.out.print("+");
				sum = num == MIN ? sum + num : sum - num;
			} else {
				System.out.print(num != MAX ? "-" : "=");
				sum += num;
			}
			num++;
		}
		System.out.print(sum);
	}
	
	public static void main03(String[] args) {
		// 피보나치 수열 누적
		// 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 = 54
		final int MAX = 21;
		int sum = 0;
		
		for (int p = 0, c = 1, n = 0; c <= MAX; n = p + c, p = c, c = n) {
			sum += c;
			System.out.print(c);
			System.out.print(c == MAX ? "=" : "+");
		}
		System.out.print(sum);
/*		
		int prev = 0; // 이전항
		int curr = 1; // 현재항
		int next = 0; // 다음항
		int sum = 0;
		
		while(curr <= MAX) {
			System.out.print(curr);
			
			// 누적하기
			sum += curr;
			
			// 치환해서 증가하기
			// 다음항은 이전항 + 현재항
			// 현재항은 이전항으로 치환
			// 다음항은 현재항으로 치환(새로운 현재항)
			next = prev + curr;
			System.out.print(curr == MAX ? "=" : "+");
			prev = curr;
			curr = next;
		}
		System.out.print(sum);
*/
	}
	
	public static void main04(String[] args) {
		// 피보나치 수열 누적
		// 1 + 1 - 2 + 3 - 5 + 8 - 13 + 21 = 14
		final int MAX = 21;
		
		int prev = 0; // 이전항
		int curr = 1; // 현재항
		int next = 0; // 다음항
		int sum = 0;
		
		int i = 1;
		while (curr <= MAX) {
			System.out.print(curr);
			if(i%2==1) {
				sum = i == 1 ? curr : sum - curr;
				System.out.print("+");
			} else {
				sum += curr;
				System.out.print(curr == MAX ? "=" : "-");
			}
			next = prev + curr;
			prev = curr;
			curr = next;
			i++;
		}
		System.out.print(sum);
		
/*		for(int i = 1; curr <= MAX; i++) {
			System.out.print(curr);
			if(i % 2 != 0) {
				sum = (curr == 1) ? curr : sum - curr;
				System.out.print("+");
			} else {
				System.out.print(curr != MAX ? "-" : "=");
				sum += curr;
			}
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		System.out.print(sum);
*/
	}
	
	public static void main(String[] args) {
		// 피보나치 수열 누적
		// 1 + 1 - 2 + 3 - 5 + 8 - 13 + 21 = 14
		final int MAX = 21;
				
		int prev = 0; // 이전항
		int curr = 1; // 현재항
		int next = 0; // 다음항
		int sum = 0;
		
		// flag 알고리즘
		boolean flag = true;
		while(curr <= MAX) {
			System.out.print(curr);
			
			if(flag) {
				sum = curr == 1 ? curr : sum - curr;
				System.out.print("+");
				flag = false;
			} else {
				sum += curr;
				System.out.print(curr != MAX ? "-" : "=");
				flag = true;
			}

			next = prev + curr;
			prev = curr;
			curr = next;
		}
		System.out.print(sum);
	}
	
}
