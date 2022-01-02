package org.comstudy12.ex03;

import java.io.IOException;
import java.util.Scanner;

public class Day12_Ex02 {
	
	static Scanner scan = new Scanner(System.in);
	
	static int getNum() {
		int num = 0;
		int ch = 0;
		try {
			while((ch = System.in.read()) != '\n') {
				if(ch >= '0' && ch <= '9') {
					num = num * 10 + ch - '0';
				}
			}
		} catch (IOException e) {}
		return num;
	}
	
	public static int compare(int a, int b) {
		if(a == b) {
			return 0;
		} else if(a < b) {
			return 1;
		} else {
			return -1;
		}
	}
	
	static void status(int cnt) {
		if(cnt == 0) {
			System.out.println("기회를 모두 소진 했다. 실격!");
		}
	}
	
	// 입력 받은 userNum의 유효성 체크하는 함수
	static int getUserNum(int min, int max, int cnt) {
		System.out.print("사용자 입력(1~100 사이)>> ");
//		System.out.printf("사용자 입력(%d~%d 사이)>> ", min, max);
		int userNum = getNum();
		while(userNum < min || userNum > max) {
			System.out.println("입력 범위를 벗어 났습니다!");
			System.out.print("다시 입력(1~100 사이)>> ");
			userNum = getNum();
		}
		return userNum;
	}
	
	public static void game() {
		// 컴퓨터가 1~100사이의 랜덤한 숫자(난수) 선택
		// 사용자가 5회 안에 맞추기
		int min = 1, max = 100;
		int cnt = 5;
		int sysNum = (int)(min + Math.random() * max);
		System.out.println("시스템이 난수를 선택 했습니다.(" + sysNum + ")");
		
		while(cnt > 0) {
			// 사용자가 입력 받아서 비교하기
			System.out.println("남은 시도 횟수 : " + cnt);
			int userNum = getUserNum(min, max, 5);
			int result = compare(sysNum, userNum);
			
			if(result == 0) {
//				System.out.println("빙고!");
				break;
			}
			if (result == 1) {
				// 너무 큰 숫자 -> max의 범위 변경
				System.out.println("너무 큰 숫자입니다!");
				max = userNum -1;
			} else {
				System.out.println("너무 작은 숫자입니다!");
				min = userNum + 1;
			}
			cnt--;
		} // end of while
		// 맟주고 나온건가? cnt가 다 되어서 나온건가?
		// cnt가 0이 아니면 맞추고 나온것 0이면 그냥 실격!
		status(cnt);
	}

	public static void main(String[] args) {
		// 높다 낮다 게임(카드 맞추기)
		// 컴퓨터가 1~100사이의 랜덤한 숫자(난수) 선택
		// 사용자가 5회 안에 맞추기
		// 재시도 가능하게 구현
		// --- 입력된 숫자가 맞나? 틀리나? 판별
		// --- 맞으면 빙고, 틀리면 작다/크다를 출력
		
		while(true) {
			System.out.println("-- 게임 시작 --");
			game();
			System.out.println("계속 하시겠습니까? ( y / n )");
			char isLoop = scan.next().charAt(0);
			while(!(isLoop == 'n' || isLoop == 'y')) {
				System.out.println("y 또는 n 만 입력하세요");
				System.out.println("계속 하시겠습니까? ( y / n)");
				isLoop = scan.next().charAt(0);
			}
			if(isLoop == 'n') {
				break;
			}
//		int res = compare(55, 46);
		}
		System.out.println("수고했습니다!!!");
	}
}
