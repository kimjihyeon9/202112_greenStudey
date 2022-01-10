package homework;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame_hw extends Frame {
	public MyFrame_hw() {
		this("my-frame", 200, 200);
	}
	
	public MyFrame_hw(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int)tk.getScreenSize().getWidth();
		int scrHeigh = (int)tk.getScreenSize().getHeight();
		
		int x = scrWidth / 2 - w / 2;
		int y = scrHeigh / 2 - h / 2;
		
		this.setLocation(x, y);
	}
}
