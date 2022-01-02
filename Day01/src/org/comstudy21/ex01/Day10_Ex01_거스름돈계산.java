package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out; // improt를 했기 때문에 out만 사용해도 가능

public class Day10_Ex01_거스름돈계산 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 다음과 같이 출력되도록 구현하세요(반복문 사용가능)
		// 10000원을 입력 받았다면
		// 5000원권 1개
		// 1000원권 4개
		// 500원권 1개
		// 100원권 2개
		// 50원권 1개
		// 10원권 1개
		
		int money = 0;
		int price = 240;
		int[] ch = {5000, 1000, 500, 100, 50, 10};
		System.out.printf("물건 값이 %d원입니다.\n",price);
		System.out.print("현금입력 : ");
		money = scan.nextInt();
		
		money = money - price;
		
		for(int i = 0; i< ch.length; i++) {
			if(money >= ch[i]) {
				System.out.println(ch[i] + "원 " + money / ch[i] + "개");
				money = money % ch[i];
			}
		}
		
/*		int a = money - price;
		
		int b = a / 5000;
		int c = a % 5000 / 1000;
		int d = a % 1000 / 500;
		int e = a % 500 / 100;
		int f = a % 100 / 50;
		int g = a % 50 / 10;
		
		System.out.println("5000원권 " + b + "개");
		System.out.println("1000원권 " + c + "개");
		System.out.println(" 500원권 " + d + "개");
		System.out.println(" 100원권 " + e + "개");
		System.out.println("  50원권 " + d + "개");
		System.out.println("  10원권 " + f + "개");
*/		
	       
	}
}
