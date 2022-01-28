package Life_game;

public class LifeGame {
	String[][] Arr = {{"전자레인지를 킨다", "전자레인지에 음식을 넣는다", "동작 버튼을 누른다", "음식을 꺼낸다"}, 
			{"TV의 전원을 킨다", "리모컨을 든다", "원하는 체널로 이동한다", "전원을 끈다"},
			{"2번 문제", "2번 문제", "2번 문제", "2번 문제"},
			{"3번 문제", "3번 문제", "3번 문제", "3번 문제"}}; // 답 순서를 담아놓은 배열
	
	// 문항을 담는 변수
	String[] answer0; 
	String[] answer1;
	String[] answer2;
	String[] answer3;
	
	int k = 0; // 문항 번호을 결정하는 변수(랜덤으로 돌면 될거같다)
	// 중복 체크 - 만약 Arr[0]이 나왔는데 다음 문제도 Arr[0]이 나오는 경우 생각하기
	String[] a = new String[4 * 4];
	
	public LifeGame() {
		run();
	}
	
	public void run() {
		answer();
		
		quiz();
		
		location();
	}
	
	public void answer() {
		switch(k) {
		case 0:
			a = answer0;
			answerArr();
			break;
		case 1:
			a = answer1;
			answerArr();
			break;
		case 2:
			a = answer2;
			answerArr();
			break;
		case 3:
			a = answer3;
			answerArr();
			break;
		}
	}
	
	public void answerArr() { // 정답를 뽑기위한 함수
		// 이중 for문을 쓴 이유
		// Arr[][]가 이차원 배열이여서 
		for(int i = k; i < k+1; i++) { // 문항뽑기
			for(int j = 0; j < 4; j++) { // 문항안 정답 뽑기
				a[i * 4 + j] = Arr[i][j]; // 문제 = 1차원 배열과 2차원 배열이 충돌함
				System.out.println(a);
			}
			System.out.println();
		}
	}
	
	public void quiz() {
		
	}
	
	public void location() {
		
	}
	
	public static void main(String[] args) {
		new LifeGame();
	}

}
