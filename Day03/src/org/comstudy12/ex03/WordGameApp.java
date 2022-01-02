package org.comstudy12.ex03;

import java.util.Scanner;

public class WordGameApp {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("끝말잇기 게임을 시작합니다... ");
		run();
	}	
	
	public static void run() {
		System.out.print("게임에 참가하는 인원은 몇명입니까>> ");
		int n = sc.nextInt();
		Player[] player = new Player[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("참가자의 이름을 입력하세요>> ");
			String name = sc.next();
			player[i] = new Player(name);
		}
		
		String word = "아버지";
		System.out.println("시작하는 단어는 " + word + "입니다");
		
		for(int i = 0; ; i++) {
			System.out.print(player[i].name + " >> ");
			player[i].getWordFromUser(word);
			word = sc.next();
			if(!player[i].checkSuccess(word)) {
				break;
			}
		}
	}
}
