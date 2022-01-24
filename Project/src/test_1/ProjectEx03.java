package test_1;

import java.awt.Color;

public class ProjectEx03 {
	// 색깔 상수
	private static final int RED = 0;
	private static final int BLUE = 1;
	private static final int YELLOW = 2;
	private static final int ORANGE = 3;

	Color[] c = { Color.red, Color.blue, Color.yellow, Color.orange };
	String[] cs = { "RED", "BLUE", "YELLOW", "ORANGE" };
	
	// 색의 배열
	static int[] arr = new int[4];

	// 색배열, 글자배열 => 일단 4개로 해서 테스트 하기(나중에는 7개정도)
	
	// 버튼 색도 랜덤으로 돌리기
	// 		중복제거
	
	// 글씨를 랜덤으로 돌리기
	// 단, 글씨의 색이 버튼 3개중에 한개여야한다
	// 버튼색이 같으면 안된다(중복체크)
	// 글씨와 색이 맞는거 검사하기
	
	public ProjectEx03() {
		
	}

	// 버튼 3개의 색 랜덤으로 돌리기
	public static void button() {
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = (int)(Math.random() * 4); // 0~3 
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// 버튼이 실행되는 부분
		button();
		
		while(true) {
			// 버튼의 중복 처리
			if((arr[0] == arr[1]) || (arr[1] == arr[2]) || (arr[0] == arr[2])) {
				button();
			} else {
				break;
			}
		}
		
		
	}

}
