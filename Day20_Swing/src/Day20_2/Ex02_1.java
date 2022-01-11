package Day20_2;

import javax.swing.JFrame;

public class Ex02_1 extends JFrame { // 상속을 받았다 = 그것이 되었다, 일을 받았다
	public Ex02_1() { // Construckor = 생성자
		// 닫기 버튼 누를때 강제종료 이벤트 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 타이틀 지정
		setTitle("첫번째 스윙 실습");
		
		// 크기설정
		setSize(640, 480);
	}

	public static void main(String[] args) {
		new Ex02_1().setVisible(true);
	}

}
