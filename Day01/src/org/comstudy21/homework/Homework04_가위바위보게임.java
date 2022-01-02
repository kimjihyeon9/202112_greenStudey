package org.comstudy21.homework;

import java.util.Scanner;

public class Homework04_가위바위보게임 {
	// 가위바위보 게임

	public static final Scanner scan = new Scanner(System.in);
	public static final String 가위 = "가위";
	public static final String 바위 = "바위";
	public static final String 보 = "보";

	public static String getUserWord(String user) {
		String var = "";
		do {
			System.out.println("가위 바위 보 중에 입력 하세요!");
			System.out.printf("%s >> ", user);
			var = scan.next();
		} while (!(var.equals(가위) || var.equals(바위) || var.equals(보)));
		return var;
	} // end of getUserWord

	public static void game(String user1Name, String user2Name) {
		String user1 = getUserWord(user1Name);
		String user2 = getUserWord(user2Name);
		
		if (user1.equals(user2)) {
			System.out.println("비겼습니다");
			return;
		}
		
		String win = "";
		switch(user1) {
		case 가위:
			win = user2.equals(바위) ? user1Name : user2Name;
			break;
		case 바위:
			win = user2.equals(보) ? user1Name : user2Name;
			break;
		case 보:
			win = user2.equals(가위) ? user1Name : user2Name;
			break;
		}
		System.out.println(win + "가 이겼습니다.");
	}
	
	public static void main(String[] args) {
		if(args == null || args.length == 0) {
			System.out.println("arguments 가 없습니다");
			return;
		}
		while(args[0] != null && args[1] != null) {
			game(args[0], args[1]);
			System.out.println("계속 하시겠습니까? ( Y / N )");
			char isLoop = scan.next().charAt(0);
			while(!(isLoop == 'n' || isLoop == 'y')) {
				System.out.println("y 또는 n 만 입력하세요");
				System.out.println("계속 하시겠습니까? ( y / n)");
				if(isLoop == 'y') {
					isLoop = scan.next().charAt(0);
				} else {
					System.out.println("종료하겠습니다");
					return;
				}
			}
			if(isLoop == 'n') {
				break;
			}
		}
	}
}
