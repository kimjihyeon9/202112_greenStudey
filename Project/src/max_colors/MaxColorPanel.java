package max_colors;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameContainer.GameContainer;

public class MaxColorPanel extends GameContainer {
	private ImageIcon bgImg;
	private JLabel bgImgPan;

	private ImageIcon bgSK;
	private JLabel bgSKPan;

	private JPanel colorPan;

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	private JLabel txtTitle;
	private Font font;

	private JLabel checkLabel;
	private JLabel xLabel;

	MaxColorConsole mcc = new MaxColorConsole();

	public void nineArr() {
		for (int i = 0; i < 9; i++) {
//		JLabel arr[i] = new JLabel();
		}
	}

	public MaxColorPanel() {
		this.setLayout(null);

		bgImg = new ImageIcon("images/gamebg.png");
		bgImgPan = new JLabel(bgImg);
		bgImgPan.setSize(1024, 768);

		bgSK = new ImageIcon("images/sk.png");
		bgSKPan = new JLabel(bgSK);
		bgSKPan.setBounds(150, 150, 720, 425);

		ImageIcon checkIcon = new ImageIcon("images/o.png");
		checkLabel = new JLabel(checkIcon);
		ImageIcon xIcon = new ImageIcon("images/x.png");
		xLabel = new JLabel(xIcon);

		checkLabel.setBounds(670, 65, 150, 150);
		this.add(checkLabel);
		checkLabel.setVisible(false);
		xLabel.setBounds(670, 65, 150, 150);
		this.add(xLabel);
		xLabel.setVisible(false);

		colorPan = new JPanel();
		colorPan.setLayout(new GridLayout(3, 3));
		colorPan.setBounds(100, 150, 300, 200);

		colorPan.setOpaque(true);
		JLabel arr0 = new JLabel();
		colorPan.add(arr0);
		JLabel arr1 = new JLabel();
		colorPan.add(arr1);
		JLabel arr2 = new JLabel();
		colorPan.add(arr2);
		JLabel arr3 = new JLabel();
		colorPan.add(arr3);
		JLabel arr4 = new JLabel();
		colorPan.add(arr4);
		JLabel arr5 = new JLabel();
		colorPan.add(arr5);
		JLabel arr6 = new JLabel();
		colorPan.add(arr6);
		JLabel arr7 = new JLabel();
		colorPan.add(arr7);
		JLabel arr8 = new JLabel();
		colorPan.add(arr8);

		Color[] col = { Color.red, Color.blue, Color.yellow };

//		for (int i = 0; i < 9; i++) {
//			if (mcc.setArr() == mcc.col[0]) {
//				colorPan.setBackground(Color.red);
//			} else if (mcc.setArr() == mcc.col[1]) {
//				colorPan.setBackground(Color.blue);
//			} else if (mcc.setArr() == mcc.col[2]) {
//				colorPan.setBackground(Color.yellow);
//			}
//			colorPan.add(new JLabel(i + ""));
//		}
//		colorPan.add(new JLabel());
//		colorPan.setOpaque(true);

//		for (int i = 0; i < 3; i++) {
//			nineArr();
//		}

		for (int i = 0; i < 3; i++) {
			JLabel b = new JLabel();
			b.setOpaque(true);
			if (mcc.setArr() == mcc.col[0]) {
				b.setBackground(mcc.col[0]);
			} else if (mcc.setArr() == mcc.col[1]) {
				b.setBackground(Color.blue);
			} else if (mcc.setArr() == mcc.col[2]) {
				b.setBackground(Color.yellow);
			}
//			b.setBackground(col[i]);
			colorPan.add(b);
		}

		btn1 = new JButton("빨간색");
		btn2 = new JButton("파란색");
		btn3 = new JButton("노란색");
		btn1.setBounds(500, 160, 100, 50);
		btn2.setBounds(500, 230, 100, 50);
		btn3.setBounds(500, 300, 100, 50);
		btn1.setBackground(Color.red);
		btn2.setBackground(Color.blue);
		btn3.setBackground(Color.yellow);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		txtTitle = new JLabel("가장 많은 색을 선택해주세요");
		font = new Font("맑은 고딕", Font.BOLD, 20);
		txtTitle.setFont(font);
		txtTitle.setForeground(Color.black);
		txtTitle.setBounds(230, 50, 500, 100);

		bgSKPan.add(colorPan);
		bgSKPan.add(txtTitle);
		bgSKPan.add(btn1);
		bgSKPan.add(btn2);
		bgSKPan.add(btn3);
		bgImgPan.add(bgSKPan);
		this.add(bgImgPan);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			if (mcc.max == mcc.c0) {
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == btn2) {
			if (mcc.max == mcc.c1) {
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == btn3) {
			if (mcc.max == mcc.c2) {
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
	}

	@Override
	public void gamePlay() {

	}

}
