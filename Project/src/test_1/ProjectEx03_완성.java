package test_1;

import java.awt.Color;

public class ProjectEx03_완성 {
	// 색깔 상수
	private static final int RED = 0;
	private static final int BLUE = 1;
	private static final int YELLOW = 2;
	private static final int ORANGE = 3;

	// 글자에 입힐 색깔
	static Color[] c = { Color.red, Color.blue, Color.yellow, Color.orange };
	// 글자
	static String[] cs = { "RED", "BLUE", "YELLOW", "ORANGE" };

	// 색깔의 배열
	static int[] arrBtn = new int[3]; // 버튼의 배열
	static int[] arrTxt = new int[4]; // 글자의 배열

	static int ansColor; // 정답(글자와 버튼색이 같음)
	static int ansLoc; // 정답위치(정답위치가 일정함을 방지하기위해서)

	// 글자 함수
	// 글자(=정답)를 정해주기위한 함수이다
	public static void colorTxt() {
		for (int i = 0; i < 1; i++) {
			arrTxt[i] = (int) (Math.random() * 4);
			System.out.println("arrTxt[i] " + arrTxt[i]);
			ansColor = arrTxt[i];
		}
	}

	// 위치선정 함수
	// 글자함수에서 나온 정답의 위치를 정해주기위한 함수이다
	public static void location() {
		ansLoc = (int) (Math.random() * 3); // 저장위치 랜덤 돌리기
		System.out.println("ansLoc : " + ansLoc); // 저장위치 확인 용도

		arrBtn[ansLoc] = ansColor;
	}

	// 버튼 2개의 색 랜덤으로 돌리기
	// 정답과 오답2개를 받기위한 함수이다
	public static void button() {
		for (int i = 0; i < arrBtn.length; i++) {
			// 정답을 제외한 버튼의 색깔지정하는 부분
			// 정답과 같으면 다시 위로 올라가서 for문을 돌아라
			if (i == ansLoc) { 
				continue;
			}

			int otherColor = (int) (Math.random() * 4); // 7개로 바꾸기

			// 랜덤수와 정답이 같으면 다시 위로 올라가서 for문을 돌아라
			if (ansColor == otherColor) { 
				i--;
				continue;
			}
			arrBtn[i] = otherColor;
			// 값이 나오면 그것에 대한 중복체크해주기
			for (int j = 0; j < i; j++) { // j < i => i = 전에 뽑은 랜덤수, j = 지금 뽑은 랜덤수
				if (arrBtn[j] == arrBtn[i]) {
					i--;
					continue;
				}
			}

		}

		// 결정된 버튼을 출력해주기
		for (int i = 0; i < arrBtn.length; i++) {
			System.out.print(arrBtn[i] + " ");
		}

	}

	public static void main(String[] args) {
		// 글자가 실행되는 부분 - 하나만 나와 중복제거가 필요없다
		colorTxt();
		System.out.println();

		// 저장위치 선정
		location();
		System.out.println();

		// 버튼이 실행되는 부분
		button();
	}
}