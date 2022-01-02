package org.comstudy12.ex02;

import java.util.Random;
import java.util.Scanner;

public class Day11_실습문제 {
	// 실습문제
	public static void main01_2(String[] args) {
		int sum = 0, i = 0;
		while (i < 100) {
			sum = sum + i;
			i +=2;
		}
		System.out.println(sum);
	}
	
	public static void main01_3(String[] args) {
		int sum = 0, i;
		for(i = 0; i < 100; i += 2) {
			sum = sum + i;
		}
		System.out.println(sum);
		
	}
	
	public static void main01_4(String[] args) {
		int sum = 0, i = 0;
		do {
			i += 2;
			sum = sum + i;
		} while(i < 100);
		System.out.println(sum);
		
	}
	
	public static void main02(String[] args) {
		int n [][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};
		for(int i = 0; i < n.length; i++) {
			for(int j = 0; j < n[i].length; j++) {
				System.out.print(n[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main03(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("*를 몇개 출력할까요? : ");
		int s = sc.nextInt();
		int i = 0;
		int j = 0;
		
		for(i = 0; i < s; i++) {
			for(j = 0; j < s - i; j++) {
					System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
	
	public static void main04(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("소문자 알파벳 하나를 입력하시오 : ");
		String a = sc.next(); // 문자열 읽기
		char c = a.charAt(0); // 문자열의 첫번째 문자
		int i = 0;
		
		for(i = 0; i <= c-'a'; i++) {
			for(char j = 'a'; j<=c -i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		sc.close();
	}
	
	public static void main05(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 10개를 입력하시오 : ");
		int a[] = new int[10];
		int b[] = new int[10];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print("3의 배수는 ");
		for(int i = 0; i < a.length; i++) {
			if(a[i] % 3 == 0) {
				System.out.print(a[i] + " ");
			}
		}
		sc.close();
	}
	
	public static void main06(String[] args) {
		Scanner scan = new Scanner(System.in);
		int money = 0;
		int[] unit = {50000, 10000, 1000, 100, 10, 1};
		System.out.print("금액을 입력하세요 : ");
		money = scan.nextInt();
		
		for(int i = 0; i< unit.length; i++) {
			if(money >= unit[i]) {
				System.out.println(unit[i] + "원 짜리 : " + money / unit[i] + "개");
				money = money % unit[i];
			}
		}
	}
	
	public static void main07(String[] args) {
		int a[] = new int[10];
		int i = 0;
		int sum = 0;
		
		for(int j = 0; j < 10; j++) {
			i = (int)(Math.random()* 10 + 1);
			a[j] = i;
		}
		System.out.print("랜덤한 정수들 : ");
		for(i = 0; i < 10; i++) {
			System.out.print(a[i] + " ");
		}
		for(i = 0; i < 10; i++) {
			sum += a[i];
		}
		System.out.println();
		double avg = (double) sum / 10;
		System.out.println("평균은 " + avg);
	}
	
	public static void main08(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 몇개? ");
		int a[] = new int[100];
		
		
	}
	
	public static void main09(String[] args) {
		int a[][] = new int[4][4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				a[i][j] = (int)(Math.random()* 10 + 1);
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
