package gui_Ex01;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex02FrameEvent extends Frame implements WindowListener {
	public Ex02FrameEvent() {
		setTitle("WindowEventListener 실습");
		setSize(640, 480);
		setVisible(true);
		
		this.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		// 닥기 버튼 눌렀을때 창닫고 프로세스 끝내기
		System.out.println(">> 닫기 버튼을 눌렸기 때문에 프로세스가 종료된다!");
		dispose();
		System.exit(0); // 강제 종료
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	
	public static void main(String[] args) {
		new Ex02FrameEvent();
	}

}
