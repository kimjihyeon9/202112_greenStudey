package test_1;

import java.awt.Color;

public class ProjectEx03 {
	// 색깔 상수
	private static final int RED = 0;
	private static final int BLUE = 1;
	private static final int YELLOW = 2;
	private static final int ORANGE = 3;

	static Color[] c = { Color.red, Color.blue, Color.yellow, Color.orange };
	static String[] cs = { "RED", "BLUE", "YELLOW", "ORANGE" };
	
	// 색의 배열
	static int[] arr1 = new int[4]; // 버튼의 배열
	static int[] arr2 = new int[4]; // 글자의 배열

	static int ansColor; // 정답(글자와 버튼색이 같음)
	
	// 색배열, 글자배열 => 일단 4개로 해서 테스트 하기(나중에는 7개정도)
	
	// 버튼 색도 랜덤으로 돌리기
	// 		중복제거
	
	// 글씨를 랜덤으로 돌리기
	// 단, 글씨의 색이 버튼 3개중에 한개여야한다
	// 버튼색이 같으면 안된다(중복체크)
	// 글씨와 색이 맞는거 검사하기
	
	// 글씨랑 색을 상수로 선언을 한뒤에 출력된 값에 대입하기
	// 랜덤으로 뽑은 글씨를 같은 색의 버튼으로 지정, 2개만 랜덤으로 돌리기
	// 글자색은 정답인 색이 아니면 들어갈수있게
	
	public ProjectEx03() {
		
	}
	
	// 글자
	public static void colorTxt() {
		for(int i = 0; i < 1; i++) {
			arr2[i] = (int)(Math.random() * 4);
			System.out.println(arr2[i]);
			ansColor = arr2[i]; 
		}
	}
	
	// 버튼 2개의 색 랜덤으로 돌리기
	public static void button() {
		for(int i = 0; i < 2; i++) {
			arr1[i] = (int)(Math.random() * 4); // 0~3 
			System.out.print(arr1[i] + " ");
		}
		System.out.print(ansColor);
		System.out.println();
	}
	
	public static void main(String[] args) {
		// 글자가 실행되는 부분 - 하나만 나와 중복제거가 필요없다
		colorTxt();
		System.out.println();
		
		// 버튼이 실행되는 부분
		button();
		
		while(true) {
			// 버튼의 중복 처리
			if((ansColor == arr1[0]) || (ansColor == arr1[1]) || (arr1[0] == arr1[1])) {
				button();
			} else {
				break;
			}
		}
		
		
	}
}
