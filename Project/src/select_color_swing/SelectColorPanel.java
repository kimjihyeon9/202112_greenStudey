package select_color_swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectColorPanel extends JPanel {
	private ImageIcon bgImg;
	private JLabel bgImgPan;
	
	private ImageIcon bgSK;
	private JLabel bgSKPan;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	private Font font1;
	private Font font2;
	private JLabel txtTitle;
	private JLabel txtColor;
	
	private int w = 720;
	private int h = 425;
	private int x = (int)(w / 2);
	private int y = (int)(h / 2);
	
	public SelectColorPanel() {
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
		btn1.setBounds(100, 200, 100, 150);
		btn2.setBounds(300, 200, 100, 150);
		btn3.setBounds(500, 200, 100, 150);
		
		txtColor = new JLabel("파란색");
		font1 = new Font("맑은 고딕", Font.BOLD, 44);
		txtColor.setFont(font1);//mfont를 적용한다.
		txtColor.setForeground(Color.green);
		txtColor.setBounds(300, 70, 500, 100);

		txtTitle = new JLabel("알맞은 색을 선택해주세요");
		font2 = new Font("맑은 고딕", Font.BOLD, 20);
		txtTitle.setFont(font2);//mfont를 적용한다.
		txtTitle.setForeground(Color.black);
		txtTitle.setBounds(250, 20, 500, 100);
		
		bgSKPan.add(txtTitle);
		bgSKPan.add(txtColor);
		bgSKPan.add(btn1);
		bgSKPan.add(btn2);
		bgSKPan.add(btn3);
		bgImgPan.add(bgSKPan);
		this.add(bgImgPan);
	}

}
