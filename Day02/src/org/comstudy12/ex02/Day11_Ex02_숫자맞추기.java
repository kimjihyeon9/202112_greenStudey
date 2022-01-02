package org.comstudy12.ex02;

import java.util.Random;
import java.util.Scanner;

public class Day11_Ex02_숫자맞추기 {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			Random r = new Random();
			int k = r.nextInt(100); // 0~99까지 임의의 정수 생성
			int i = 1;
			int min = 0;
			int max = 99;
			
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			System.out.println(min + " - " + max);
			System.out.print(i + " >>> ");
			int j = scan.nextInt();
			
			while(true) {
				if(j == k) {
					System.out.println("맞았습니다");
					break;
				} else if (j < k) {
					i++;
					System.out.println("더 높게");
					min = j;
					System.out.println(min + " - " + max);
					System.out.print(i + " >>> ");
					j = scan.nextInt();
				} else {
					i++;
					System.out.println("더 낮게");
					max = j;
					System.out.println(min + " - " + max);
					System.out.print(i + " >>> ");
					j = scan.nextInt();
				}
			}
			System.out.print("다시하시겠습니까(y/n)");
			String text = scan.next(); // 사용자로부터 "y"나 "n" 문자열 입력
			if(text.equals("n")) {
				System.out.println("종료하겠습니다.");
				return;
			} else {

			}
		}
		
		
	}
		
}
