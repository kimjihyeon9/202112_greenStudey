package Day08_5;

// 이클립스에 다운로드해서 사용할때
// 		- Help -> Install New Software

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
	// Frame 을 상속받은 MyFrame 은 Frame 이다. (IS-A관계)
	public MyFrame(String title, int width, int height) {
		// 인스턴스 내부
		setTitle(title);
		super.setVisible(true);
		this.setSize(width, height); // 창을 닫고 싶으면 콘솔창의 Terminate 클릭
		
		Toolkit tk = getToolkit().getDefaultToolkit();
		int sw = (int)(tk.getScreenSize().getWidth()); // 넓이
		int sh = (int)(tk.getScreenSize().getHeight());
		setLocation(sw/2 - this.getWidth()/2, sh/2 - this.getHeight()/2);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 윈도우의 닫기 버튼을 클릭하면 발생되는 이벤트 핸들러
				MyFrame.this.dispose(); // 리소스 수거하기
				System.exit(0); // 프로그램 강제 종료
			}
		});
	}

	public static void main(String[] args) {
//		Frame win = new Frame();
//		win.setVisible(true);
//		win.setSize(640, 480);
		
//		new MyFrame();
		Frame frame = new MyFrame("윈도우 생성 실습", 600, 400);
		// 여기는 인스턴스 외부
	}

}
