package max_colors;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaxColorPanel extends JPanel {
//	JPanel jPan = new JPanel();
	
	public MaxColorPanel() {
		this.setLayout(null);
		
		ImageIcon bgSK = new ImageIcon("F:\\JH\\자바_12월\\Project\\src\\select_color_swing\\sk.png");
		JLabel bgSKPan = new JLabel(bgSK);
		bgSKPan.setBounds(150, 150, 720, 425);
		
		JButton btn1 = new JButton("0번째 버튼");
		JButton btn2 = new JButton("1번째 버튼");
		JButton btn3 = new JButton("2번째 버튼");
		btn1.setBounds(500, 100, 100, 50);
		btn2.setBounds(500, 200, 100, 50);
		btn3.setBounds(500, 300, 100, 50);
		
		JLabel txt = new JLabel("파란색을 눌러주세요!");
		txt.setBounds(300, 50, 200, 100);
		
		bgSKPan.add(txt);
		bgSKPan.add(btn1);
		bgSKPan.add(btn2);
		bgSKPan.add(btn3);
		this.add(bgSKPan);
	}

}
