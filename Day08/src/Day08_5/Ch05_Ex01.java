package Day08_5;

import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Ch05_Ex01 extends MyFrame {
	
	Button okBtn = new Button("OK");
	
	public Ch05_Ex01() {
		// MyFram 의 인자있는 생성을 명시적으로 호출한다.
//		super("짱구는 못말려", 400, 300);
		this("test", 500, 500);
		setLayout(new GridBagLayout());
		this.add(okBtn);
		
		okBtn.addMouseListener(new MouseAdapter() {
			public void mousClicked(MouseEvent e) {
				System.out.println("버튼 클릭 됨");
	            String message = JOptionPane.showInputDialog("즐거운 자바 개발!!");
	            System.out.println("message => " + message);
	            JOptionPane.showMessageDialog(null, message);
			}
		});
	}

	public Ch05_Ex01(String title, int w, int h) {
		super(title, w, h);
	}

	public static void main(String[] args) {
		new Ch05_Ex01();
	}

}
