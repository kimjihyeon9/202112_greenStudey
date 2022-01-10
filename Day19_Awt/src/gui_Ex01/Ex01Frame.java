package gui_Ex01;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Label;

public class Ex01Frame {

	public static void main(String[] args) {
//		JOptionPane p = new JOptionPane("Hello"); // 단독으로..?
//		p.show();
		
		// 프레임 실행하기
		// 두가지 방법 : 1. 단독으로 실행하기, 2. 상속을 받아서 생성하기
		// 이거는 1번 방법으로 구현한것
		Frame frame = new Frame(); // 만들어지지만 보여지지는 않는다
		
//		frame.setLayout(new FlowLayout());
		frame.setLayout(new GridBagLayout());
		
		frame.add(new Label("Hello : "));
		frame.add(new Button("WORLD"));
		
		frame.setSize(640, 480); // 크기지정
		frame.setVisible(true); // 좌측상단에 생긴다, 없애려면 콘솔에서 termainate 누르기
		
	}

}
