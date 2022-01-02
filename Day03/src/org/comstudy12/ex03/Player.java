package org.comstudy12.ex03;

import java.util.Scanner;

public class Player {
	String name;
	String word;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void getWordFromUser(String word) {
		this.word = word;
	}
	
	public boolean checkSuccess(String word) {
		String word2 = scan.next();
		int lastIndex = word.length() - 1; // 마지막 문자에 대한 인덱스
		char lastChar = word.charAt(lastIndex); // 마지막 문자
		char firstChar = word2.charAt(0); // 첫번째 문자
		
		if(lastChar != firstChar) {
			System.out.print(name + "이 졌습니다.");
			return false;
		} else {
			word = word2;
		}
		return true;
	}
}

