package max_colors;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaxColorPanel extends JPanel implements ActionListener {
	private ImageIcon bgImg;
	private JLabel bgImgPan;

	private ImageIcon bgSK;
	private JLabel bgSKPan;

	private JLabel colorPan;

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	private JLabel txtTitle;
	private Font font;
	
	MaxColorConsole mcc;

	public MaxColorPanel() {
		mcc = new MaxColorConsole();
		this.setLayout(null);

		bgImg = new ImageIcon("images/gamebg.png");
		bgImgPan = new JLabel(bgImg);
		bgImgPan.setSize(1024, 768);

		bgSK = new ImageIcon("images/sk.png");
		bgSKPan = new JLabel(bgSK);
		bgSKPan.setBounds(150, 150, 720, 425);

		colorPan = new JLabel();
		colorPan.setLayout(new GridLayout(3, 3));
		colorPan.setBounds(100, 150, 300, 200);
		colorPan.setBackground(Color.black);

		for (int i = 0; i < 9; i++) {
			Color[] col = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA,
					Color.GRAY, Color.pink};
			JLabel label = new JLabel(i + "");
			label.setBackground(col[i]);
			label.setOpaque(true);
			colorPan.add(label);
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

	}

}
