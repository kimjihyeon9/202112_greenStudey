package gui_myframe;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
	// 디폴트 생성자
	public MyFrame() {
		this("my-frame", 200, 200);
	}
	
	// 생성자 오버로딩
	public MyFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		
		// 이벤트 핸들러
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
		// 스크린 화면의 정 가운데 배치
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int)tk.getScreenSize().getWidth();
		int scrHeigh = (int)tk.getScreenSize().getHeight();
		
		int x = scrWidth / 2 - w / 2;
		int y = scrHeigh / 2 - h / 2;
		
		this.setLocation(x, y);
	}
}
