package org.comstudy21.homework;

import java.util.Scanner;

public class Homework02_실습문제풀이 {
	// 2장 실습문제 7번
	// 좌측상단 = (0,0)
	// 아래(세로) = y, 오른쪽(가로) = x
	
	public static final Scanner scan = new Scanner(System.in);	
	
	public static void main07(String[] args) {
		int x1 = 100, x2 = 200, y1 = 100, y2 = 200;
		System.out.print("점(x,y)의 좌표를 입력하시오>> ");
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.close();
		
		// x가 x1과 x2사이에 있고 y가 y1과 y2사이에 있는가?
		if((x >= x1 && x <= x2) && (y > y1 && y <= y2)) {
			System.out.println("사각형 안에 있습니다.");
		} else {
			System.out.println("사각형 안에 없습니다.");
		}
	}
	
	// 2장 실습문제 8번
	// 야금야금 해보기!!
	public static boolean inRect(int x, int y, int rectx1, int recty1, int rectx2, int recty2) {
		if((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2))
			return true;
		else return false;
	}
	public static void main(String[] args) {
		int x1 = 100, x2 = 200, y1 = 100, y2 = 200;
		System.out.print("점(x1,y1)의 좌표를 입력하시오>> ");
		int nx1 = scan.nextInt();
		int ny1 = scan.nextInt();
		System.out.print("점(x2,y2)의 좌표를 입력하시오>> ");
		int nx2 = scan.nextInt();
		int ny2 = scan.nextInt();
		scan.close();
		
		if(inRect(nx1, ny1, x1, y1, x2, y2) || inRect(nx2, ny2, x1, y1, x2, y2)) { // 비교하는 양이 많아지기 때문에 함수를 이용한다
			System.out.println("충돌 성공");
		} else {
			System.out.println("충돌 실패");
		}
	}
	
	
}
