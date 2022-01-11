package gui_myframe;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Swing과 AWT를 같이 쓰지 말자
// 약간 가계도가 달라서 섞어서 사용 금지!!

public class MyFrame extends Frame {
	// 디폴트 생성자
	public MyFrame() {
		// 생성자 오버로딩 호출
		this("my-frame", 200, 200);
	}
	
	// 생성자 오버로딩
	public MyFrame(String title, int w, int h) {
		this.setTitle(title);
		super.setSize(w, h);
		
		// 이벤트 핸들러
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
		// 스크린 화면의 정 가운데 배치
		// 공식같은거여서 암기하던가 복붙하던가
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int)tk.getScreenSize().getWidth();
		int scrHeigh = (int)tk.getScreenSize().getHeight();
		
		int x = scrWidth / 2 - w / 2;
		int y = scrHeigh / 2 - h / 2;
		
		this.setLocation(x, y);
	}
}
