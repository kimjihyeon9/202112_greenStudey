package select_color;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

// 수정
// 2월 7일 - 62줄

public class GameHowTo_sc extends JPanel implements ActionListener{
	JPanel pan1 = new JPanel();
	JPanel pan3 = new JPanel();
	
	private ImageIcon bgSK;
	private JLabel bgSkPan;

	private JButton next;
	private JButton prev;
	public JButton exit;

	private Font font1;
	
	int count = 0;
	
	public GameHowTo_sc() {
		this.setBackground(new Color(37,9,9));
		this.setLayout(null);
		comm();
		first();
		last();
		prev.addActionListener(this);
		next.addActionListener(this);
		exit.addActionListener(this);
	}

	public void comm() {
		bgSK = new ImageIcon("images/howtobg.png");
		bgSkPan = new JLabel(bgSK);
		bgSkPan.setBounds(0, 0, 820, 525);
		bgSkPan.setLayout(null);
		
		font1 = new Font("맑은 고딕", Font.PLAIN, 24);

		next = new JButton("다음");
		next.setBounds(720, 440, 80, 60);
		prev = new JButton("이전");
		prev.setBounds(25, 440, 80, 60);
		exit = new JButton("종료");
		exit.setBounds(720, 20, 80, 60);
		
		next.setBackground(Color.orange);
		prev.setBackground(Color.pink);
		exit.setBackground(Color.red);

		prev.setVisible(false); // 수정 (추가) - 한줄만
		bgSkPan.add(next);
		bgSkPan.add(prev);
		bgSkPan.add(exit);
		this.add(bgSkPan);
	}

	public void first() {
		pan1.setLayout(null);
		pan1.setBounds(130, 50, 570, 440);
		pan1.setBackground(Color.white);
		
		ImageIcon gameImg = new ImageIcon("images/GameHowTo_sc_1번.png");
		JLabel gameImgPan = new JLabel(gameImg);
		gameImgPan.setBounds(10, 10, 550, 300);

		JLabel text = new JLabel("글자의 색을 선택해주세요.");
		text.setFont(font1);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setBounds(10, 320, 550, 120);
		text.setOpaque(true);
		text.setBackground(Color.white);
		Border c = new LineBorder(new Color(137, 170,108), 7);
		text.setBorder(c);
		pan1.add(text);
		pan1.add(gameImgPan);
		bgSkPan.add(pan1);
	}

	public void last() {
		pan3.setLayout(null);
		pan3.setBounds(130, 50, 570, 440);
		pan3.setBackground(Color.white);

		ImageIcon gameImg = new ImageIcon("images/GameHowTo_sc_2번.png");
		JLabel gameImgPan = new JLabel(gameImg);
		gameImgPan.setBounds(10, 10, 550, 300);
		
		JLabel text = new JLabel("정답은 첫번째에 있는 파란색입니다.");
		text.setFont(font1);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setBounds(10, 320, 550, 120);
		text.setOpaque(true);
		text.setBackground(Color.white);
		Border c = new LineBorder(new Color(137, 170,108), 7);
		text.setBorder(c);
		pan3.setVisible(false);
		pan3.add(text);
		pan3.add(gameImgPan);
		bgSkPan.add(pan3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == prev) {
			count--;
		}
		if(e.getSource() == next) {
			count++;
		}
//		if(e.getSource() == exit) {
//			scp.btn1.addMouseListener(scp);
//			scp.btn2.addMouseListener(scp);
//			scp.btn3.addMouseListener(scp);
//			scp.btn1.setEnabled(true);
//			scp.btn2.setEnabled(true);
//			scp.btn3.setEnabled(true);
//			this.setVisible(false);
//	}
		
		if(e.getSource() == prev || e.getSource() == next) {
			if(count == 0) {
				prev.setVisible(false);
				next.setVisible(true); 
				pan1.setVisible(true);
				pan3.setVisible(false);
				revalidate();
				repaint();
			} else if(count == 1) {
				prev.setVisible(true);
				next.setVisible(false);
				pan1.setVisible(false);
				pan3.setVisible(true);
				revalidate();
				repaint();
			}
		}
	}
}
