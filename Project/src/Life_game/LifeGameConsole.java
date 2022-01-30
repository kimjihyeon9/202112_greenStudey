package Life_game;

public class LifeGameConsole {
	// 답 순서를 담아놓은 배열
	String[][] Arr = { { "전자레인지를 킨다", "전자레인지에 음식을 넣는다", "동작 버튼을 누른다", "음식을 꺼낸다" },
			{ "TV의 전원을 킨다", "리모컨 빨간버튼을 누른다", "원하는 채널로 이동한다", "전원을 끈다" }, 
			{ "선풍기의 코드를 꼽는다", "전원을 킨다", "선풍기의 풍속을 조절한다", "전원을 끈다" },
			{ "가스레인지 벨브를 연다", "가스를 킨다", "가스를 끈다", "벨브를 잠근다" },
			{ "청소기의 전원을 킨다", "청소기로 청소를 한다", "청소를 마친 후 먼지를 비운다", "청소기를 원래 자리로 돌려 놓는다" },
			{ "세탁기의 전원을 킨다", "빨래를 집어 넣는다", "빨래 시작을 누른다", "다 된 빨래를 널어 말린다"}}; // 6개

	// 문항을 담는 변수
	String[] answer = new String[4];

	int k = (int) (Math.random() * 4); // 문항을 랜덤으로 뽑는다.
	// int k = 1; // 문항 번호을 결정하는 변수(랜덤으로 돌면 될거같다)
	int count = 0;
	// 중복 체크 - 만약 Arr[0]이 나왔는데 다음 문제도 Arr[0]이 나오는 경우 생각하기
	String[] a = new String[4];
	int r;

	public LifeGameConsole() {
		run();
	}

	public void run() {
		answer();

		quiz();
	}
	
	public void answerArr() { // 정답를 뽑기위한 함수
		// 이중 for문을 쓴 이유
		// Arr[][]가 이차원 배열이여서
		for (int i = k; i < k + 1; i++) { // 문항뽑기
			for (int j = 0; j < 4; j++) { // 문항안 정답 뽑기
				a[count++] = Arr[i][j]; // 문항 정답을 차례대로 보여준다
				System.out.println(a[j]);
			}
			System.out.println();
		}
	}

	public void answer() {
		switch (k) {
		case 0:
			answerArr();
			answer[0] = a[0];
			break;
		case 1:
			answerArr();
			answer[1] = a[1];
			break;
		case 2:
			answerArr();
			answer[2] = a[2];
			break;
		case 3:
			answerArr();
			answer[3] = a[3];
			break;
		}
	}

	public void quiz() {
		int[] b = new int[4];

		for (int i = 0; i < 4; i++) {
			r = (int) (Math.random() * 4);
			b[i] = r;
			for (int j = 0; j < i; j++) {
				if (b[j] == b[i]) {
					i--;
					break;
				} 
			}
		}
		for(int i = 0; i < 4; i++) {
			System.out.println(a[b[i]]);
		}
	}

	public static void main(String[] args) {
		new LifeGameConsole();
	}

}
