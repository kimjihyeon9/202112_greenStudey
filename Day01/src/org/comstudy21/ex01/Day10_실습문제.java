package org.comstudy21.ex01;

import java.util.Scanner;

public class Day10_실습문제 {
	// 실습 문제

	public static void main01(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("원화를 입력하세요(단위 원)>> ");
		int won = sc.nextInt();
		double d = (double) won / 1100;
		
		System.out.println(won + "원은 $" + d + "입니다.");
		sc.close();
	}
	
	public static void main02(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("2자리수 정수 입력(10~99)>> ");
		int i = sc.nextInt();
		
		if(i % 11 == 0) {
			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
		} else {
			System.out.println("No! 10의 자리와 1의 자리가 같지않습니다.");
		}
		sc.close();
	}
	
	public static void main03(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하시오>> ");
		int money = 0;
		int[] m = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		money = sc.nextInt();
		
		for(int i = 0; i< m.length; i++) {
			if(money >= m[i]) {
				System.out.println(m[i] + "원 " + money / m[i] + "개");
				money = money % m[i];
			}
		}
		sc.close();
	}
	
	public static void main04(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 3개 입력>> ");
		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();
		
		if((i < j && j < k) || (k < j && j < i)) {
			System.out.println("중간값은 " + j);
	     }else if((j < i && i < k) || (k < i && i < j)) {
	    	System.out.println("중간값은 " + i);
	     }else {
	        System.out.println("중간값은 " + k);
	     }
		
/*		if (i < j && j < k) {
			System.out.println("중간 값은 " + j);
		} else if (k < i && i < j) {
			System.out.println("중간 값은 " + i);
		} else {
			System.out.println("중간 값은 " + k);
		}
*/
		sc.close();
	}
	
	public static void main05(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 3개 입력>> ");
		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();
		
		if ((i + j) < k || (j + k) < i || (i + k) < j) {
			System.out.println("삼각형이 안됩니다");
		} else {
			System.out.println("삼각형이 됩니다");
		}
		sc.close();
	}
	
	public static void main06(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~99 사이의 정수를 입력하시오>> ");
		int i = sc.nextInt();
		int j, k;
		
		if(i != 0 && 1 <= 1 && i <= 99) {
			j = i / 10;
			k = i % 10;
			
			if((j == 3 || j == 6 || j == 9) && (k == 3 || k == 6 || k == 9)) {
				System.out.println("박수짝짝");
			} else if((j == 3 || j == 6 || j == 9) || (k == 3 || k == 6 || k == 9)) {
				System.out.println("박수짝");
			}
		} else {
			System.out.println("1~99 사이의 정수를 입력하세요");
		}
		sc.close();
	}
	
	public static void main07(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점 (x, y)의 좌표를 입력하시오>> ");
		int i = sc.nextInt();
		int j = sc.nextInt();
		
		if(100 <= i && i <= 200 && 100 <= j && j <= 200) {
			System.out.println("(" + i + ", " + j + ") 는 사각형 안에 있습니다.");
		} else {
			System.out.println("(" + i + ", " + j + ") 는 사각형 안에 없습니다.");
		}
		sc.close();
	}
	
	public static void main08(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점 (x1, y1)의 좌표를 입력하시오>> ");
		int i1 = sc.nextInt();
		int j1 = sc.nextInt();
		System.out.print("점 (x2, y2)의 좌표를 입력하시오>> ");
		int i2 = sc.nextInt();
		int j2 = sc.nextInt();
		
		sc.close();
	}
	public static boolean inRect(int x, int y, int rectx1, int recty1, int rectx2, int recty2) {
		if((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2))
			return true;
		else return false;
	}
	
	public static void main09(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("원의 중심과 반지름 입력>> ");
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		int j = sc.nextInt();
		
		sc.close();
	}
	
	public static void main10(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 원의 중심과 반지름 입력>> ");
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		System.out.print("두번째 원의 중심과 반지름 입력>> ");
		int j1 = sc.nextInt();
		int j2 = sc.nextInt();
		
		sc.close();
	}
	
	public static void main11_1(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("달을 입력하세요(1~12)>> ");
		int i = sc.nextInt();
		
		if(1 <= i && i <= 9) {
			if (i == 3 || i == 4 || i == 5) {
				System.out.println("봄");
			} else if(i == 6 || i == 7 || i == 8) {
				System.out.println("여름");
			} else if(i == 9 || i == 10 || i == 11) {
				System.out.println("가을");
			} else if(i == 12 || i == 1 || i == 2) {
				System.out.println("겨울");
			}
		} else {
			System.out.println("잘못입력");
		}
		sc.close();
	}
	public static void main11_2(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("달을 입력하세요(1~12)>> ");
		int i = sc.nextInt();
		
		switch(i) {
		case 3: case 4: case 5:
			System.out.println("봄");
			break;
		case 6: case 7: case 8:
			System.out.println("여름");
			break;
		case 9: case 10: case 11:
			System.out.println("가을");
			break;
		case 12: case 1: case 2:
			System.out.println("겨울");
			break;
		default:
			System.out.println("잘못입력");
		}
		sc.close();
	}
	
	public static void main12_1(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연산>> ");
		int i1 = sc.nextInt();
		String j = sc.next();
		int i2 = sc.nextInt();
		int r = 0;
		
		if(j.equals("+"))
			r = i1 + i2;
		else if(j.equals("-"))
			r = i1 - i2;
		else if(j.equals("*"))
			r = i1 * i2;
		else if(j.equals("/"))
			if(i2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				sc.close();
				return;
			} else  {
				r = i1 / i2;
			}
			System.out.print(i1 + j + i2 + "의 계산결과는 " + r);
	}
	public static void main12_2(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연산>> ");
		int i1 = sc.nextInt();
		String j = sc.next();
		int i2 = sc.nextInt();
		int r = 0;
		
		switch(j) {
		case "+":
			r = i1 + i2;
			break;
		case "-":
			r = i1 - i2;
			break;
		case "*":
			r = i1 * i2;
			break;
		case "/":
			if(i2 == 0) 
				System.out.println("0으로 나눌 수 없습니다.");
			else {
				r = i1 / i2;
			}
			break;
		default:
			System.out.println("잘못입력했습니다");
			break;
		}
		System.out.print(i1 + j + i2 + "의 계산결과는 " + r);
	}
}
