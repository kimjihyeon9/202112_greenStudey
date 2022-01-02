package org.comstudy21.ex01;

public class Day10_연습문제 {

	public static void main(String[] args) {
		// 연습 문제
		
		int i;
		int j;
		i = 10;
		j = 20;
		System.out.println(i + j);
		
		int a = 10;
		int b = 9;
		System.out.println(a == b);
		
		System.out.println("\"를 출력하려면 \\다음에 \"를 붙여 \\\"과 같이 하면 됩니다.");
		
		int sum = 0;
		char grade = 'A';
		switch(grade) {
		case 'A' : sum += 100;
		case 'B' : sum += 50;
		case 'C' : sum += 30;
		case 'D' : sum += 10;
		
		}
		System.out.println(sum);
		
		switch("in") {
		case "가위": 
			System.out.println(1); 
			break;
		case "바위": 
			System.out.println(2); 
			break;
		case "보": 
			System.out.println(3); 
			break;
		default:
			System.out.println(0);
		}
	}

}
