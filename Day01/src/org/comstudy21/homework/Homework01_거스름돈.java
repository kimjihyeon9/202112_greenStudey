package org.comstudy21.homework;

import java.util.Scanner;

public class Homework01_거스름돈 {
	public static void println(String s) { // println 으로도 찍을 수 있다
		System.out.println(s);
	}
	
	public static void main00(String[] args) {
		int price = 240;
		int money = 10000;
		int carry = money - price;
		
		System.out.println("거스름돈 = > " + carry);
		// -----------------------------------------------
		int ea5000 = carry / 5000;
		System.out.println("5천원짜리 " + ea5000 + "개");
		
		carry = carry % 5000;
		System.out.println("남은 돈 => " + carry);
		// -------------------------------------------------
		int ea1000 = carry / 1000;
		System.out.println("1천원짜리 " + ea1000 + "개");
		
		carry = carry % 1000;
		System.out.println("남은 돈 => " + carry);
		// -------------------------------------------------
		int ea500 = carry / 500;
		System.out.println("5백원짜리 " + ea500 + "개");
		
		carry = carry % 500;
		System.out.println("남은 돈 => " + carry);
		// -------------------------------------------------
		int ea100 = carry / 100;
		System.out.println("1백원짜리 " + ea100 + "개");
		
		carry = carry % 100;
		System.out.println("남은 돈 => " + carry);
		// -------------------------------------------------
		int ea50 = carry / 50;
		System.out.println("5십원짜리 " + ea50 + "개");
		
		carry = carry % 50;
		System.out.println("남은 돈 => " + carry);
		// -------------------------------------------------
		int ea10 = carry / 10;
		System.out.println("1십원짜리 " + ea10 + "개");
		
		carry = carry % 10;
		System.out.println("남은 돈 => " + carry);
		// -------------------------------------------------
	}
	
	public static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("물건 값 입력 >> ");
		int price = scan.nextInt();
		System.out.print("받은 돈 입력 >>> ");
		int money = scan.nextInt();
		while(!(money >= price && (money == 50000 || money == 10000 || money == 5000 || money == 1000 || money == 500 || money == 100 || money == 50))) { // && 가 || 보다 우선순위 
			System.out.println("잘못된 입력입니다.");
			System.out.print("받은 돈 다시 입력 >>> ");
			money = scan.nextInt();
		}
		int carry = money - price;
		
		System.out.println("지불한 돈 = > " + money);
		System.out.println("거스름 돈 = > " + carry);
		// -----------------------------------------------
/*		for (; money > 10;) {
			money /= 2;
			System.out.println("money => " + money);
			money /= 5;
			System.out.println("money => " + money);
		} 
*/		
		int num = 2;
		switch(money) {
		case 50000: case 5000: case 500: case 50:
			num = 5;
		}
		for (; money > 10;) {
			money /= num;
			System.out.println(money + "원짜리 " + (carry / money) + "개");
			carry = carry % money;
			num = num == 2 ? 5 : 2;
		}

	}

}
