package max_colors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaxColorPanel extends JPanel {
	private ImageIcon bgImg;
	private JLabel bgImgPan;
	
	private ImageIcon bgSK;
	private JLabel bgSKPan;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	private JLabel txt;
	
	public MaxColorPanel() {
		this.setLayout(null);
		
		bgImg = new ImageIcon("F:\\JH\\자바_12월\\Project\\images\\gamebg.png");
		bgImgPan = new JLabel(bgImg);
		bgImgPan.setSize(1024, 768);

		bgSK = new ImageIcon("F:\\JH\\자바_12월\\Project\\images\\sk.png");
		bgSKPan = new JLabel(bgSK);
		bgSKPan.setBounds(150, 150, 720, 425);
		
		btn1 = new JButton("0번째 버튼");
		btn2 = new JButton("1번째 버튼");
		btn3 = new JButton("2번째 버튼");
		btn1.setBounds(500, 100, 100, 50);
		btn2.setBounds(500, 200, 100, 50);
		btn3.setBounds(500, 300, 100, 50);
		
		txt = new JLabel("파란색을 눌러주세요!");
		txt.setBounds(300, 50, 200, 100);
		
		bgSKPan.add(txt);
		bgSKPan.add(btn1);
		bgSKPan.add(btn2);
		bgSKPan.add(btn3);
		bgImgPan.add(bgSKPan);
		this.add(bgImgPan);
	}

}
