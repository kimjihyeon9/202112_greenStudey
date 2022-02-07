package gameHowTo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameHowTo2 extends JPanel {
	
	private ImageIcon bgSK;
	private JLabel bgSkPan;

	private JButton next = new JButton("다음");
	private JButton prev = new JButton("이전");
	public JButton exit = new JButton("종료");

	private ImageIcon gameImg;
	private JLabel gameImgPan;
	private ImageIcon gameImg2;
	private JLabel gameImgPan2;
	private ImageIcon gameImg3;
	private JLabel gameImgPan3;

	private JLabel text;
	private JLabel text2;
	private JLabel text3;
	private Font font1;
	
	int count = 0;

	public GameHowTo2() {
		this.setBounds(100, 100, 820, 525);
		this.setBackground(new Color(0,0,0,0));
		
		bgSK = new ImageIcon("images/sk1.png");
		bgSkPan = new JLabel(bgSK);
		bgSkPan.setBounds(100, 100, 820, 525);

		font1 = new Font("맑은 고딕", Font.PLAIN, 24);

		next.setBounds(720, 440, 80, 60);
		prev.setBounds(25, 440, 80, 60);
		exit.setBounds(720, 50, 80, 60);
		
		next.setBackground(Color.orange);
		prev.setBackground(Color.pink);
		exit.setBackground(Color.red);
		
		gameImg = new ImageIcon("images/m.png");
		gameImgPan = new JLabel(gameImg);
		gameImgPan.setBounds(140, 70, 550, 300);

		text = new JLabel("게임 설명 주절주절1");
		text.setFont(font1);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setBounds(140, 380, 550, 120);
		text.setOpaque(true);
		text.setBackground(Color.pink);

		prev.setVisible(false);
		next.setVisible(true);
		
		bgSkPan.add(text);
		bgSkPan.add(next);
		bgSkPan.add(prev);
		bgSkPan.add(exit);
		bgSkPan.add(gameImgPan);
		this.add(bgSkPan);
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
//				bgSkPan.setVisible(false);
				if(count == 1) {
//					bgSkPan.setVisible(true);
//					mid();
					gameImgPan.setVisible(false);
					next.setVisible(false);
					prev.setVisible(false);
					exit.setVisible(false);
					gameImg2 = new ImageIcon("images/m.png");
					gameImgPan2 = new JLabel(gameImg2);
					gameImgPan2.setBounds(140, 70, 550, 300);
					
					text2 = new JLabel("게임 설명 주절주2");
					text2.setFont(font1);
					text2.setHorizontalAlignment(JLabel.CENTER);
					text2.setBounds(140, 380, 550, 120);
					text2.setOpaque(true);
					text2.setBackground(Color.pink);
					
					prev.setVisible(true);
					next.setVisible(true);
					bgSkPan.add(next);
					bgSkPan.add(prev);
					bgSkPan.add(exit);
					bgSkPan.add(text2);
					bgSkPan.add(gameImgPan2);
					revalidate();
					repaint();
				} else if(count == 2) {
//					bgSkPan.setVisible(true);
//					last();
					gameImgPan2.setVisible(false);
					next.setVisible(false);
					prev.setVisible(false);
					exit.setVisible(false);
					gameImg3 = new ImageIcon("images/m.png");
					gameImgPan3 = new JLabel(gameImg3);
					gameImgPan3.setBounds(140, 70, 550, 300);
					
					text3 = new JLabel("게임 설명 주절주3");
					text3.setFont(font1);
					text3.setHorizontalAlignment(JLabel.CENTER);
					text3.setBounds(140, 380, 550, 120);
					text3.setOpaque(true);
					text3.setBackground(Color.pink);
					
					next.setVisible(false);
					bgSkPan.add(next);
					bgSkPan.add(prev);
					bgSkPan.add(exit);
					bgSkPan.add(text3);
					bgSkPan.add(gameImgPan3);
					revalidate();
					repaint();
				}
			}
		});
		prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count--;
				bgSkPan.setVisible(false);
				if(count == 0) {
//					bgSkPan.setVisible(true);
//					first();
					gameImgPan2.setVisible(false);
					next.setVisible(false);
					prev.setVisible(false);
					exit.setVisible(false);
					gameImg = new ImageIcon("images/m.png");
					gameImgPan = new JLabel(gameImg);
					gameImgPan.setBounds(140, 70, 550, 300);

					text = new JLabel("게임 설명 주절주절1");
					text.setFont(font1);
					text.setHorizontalAlignment(JLabel.CENTER);
					text.setBounds(140, 380, 550, 120);
					text.setOpaque(true);
					text.setBackground(Color.pink);

					prev.setVisible(false);
					next.setVisible(true);
					bgSkPan.add(next);
					bgSkPan.add(prev);
					bgSkPan.add(exit);
					bgSkPan.add(text);
					bgSkPan.add(gameImgPan);
					revalidate();
					repaint();
				} else if(count == 1) {
//					bgSkPan.setVisible(true);
//					mid();
					gameImgPan3.setVisible(false);
					next.setVisible(false);
					prev.setVisible(false);
					exit.setVisible(false);
					gameImg2 = new ImageIcon("images/m.png");
					gameImgPan2 = new JLabel(gameImg2);
					gameImgPan2.setBounds(140, 70, 550, 300);
					
					text2 = new JLabel("게임 설명 주절주2");
					text2.setFont(font1);
					text2.setHorizontalAlignment(JLabel.CENTER);
					text2.setBounds(140, 380, 550, 120);
					text2.setOpaque(true);
					text2.setBackground(Color.pink);
					
					prev.setVisible(true);
					next.setVisible(true);
					bgSkPan.add(next);
					bgSkPan.add(prev);
					bgSkPan.add(exit);
					bgSkPan.add(text2);
					bgSkPan.add(gameImgPan2);
					revalidate();
					repaint();
				} 
			}
		});

//		comm();
//		first();
		
//		exit.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				GameHowTo.this.setVisible(false);
//			}
//		});
		
	}
	
	public void comm() {
		bgSK = new ImageIcon("images/sk1.png");
		bgSkPan = new JLabel(bgSK);
		bgSkPan.setBounds(100, 100, 820, 525);

		font1 = new Font("맑은 고딕", Font.PLAIN, 24);

//		next = new JButton("다음");
		next.setBounds(720, 440, 80, 60);
//		prev = new JButton("이전");
		prev.setBounds(25, 440, 80, 60);
//		exit = new JButton("종료");
		exit.setBounds(720, 50, 80, 60);
		
		next.setBackground(Color.orange);
		prev.setBackground(Color.pink);
		exit.setBackground(Color.red);

		bgSkPan.add(next);
		bgSkPan.add(prev);
		bgSkPan.add(exit);
		this.add(bgSkPan);
	}

	public void first() {
//		bgSkPan.removeAll();
		
		gameImg = new ImageIcon("images/m.png");
		gameImgPan = new JLabel(gameImg);
		gameImgPan.setBounds(140, 70, 550, 300);

		text = new JLabel("게임 설명 주절주절1");
		text.setFont(font1);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setBounds(140, 380, 550, 120);
		text.setOpaque(true);
		text.setBackground(Color.pink);

		prev.setVisible(false);
		next.setVisible(true);
		bgSkPan.add(next);
		bgSkPan.add(prev);
		bgSkPan.add(exit);
		bgSkPan.add(text);
		bgSkPan.add(gameImgPan);
		revalidate();
		repaint();
	}

	public void mid() {
//		bgSkPan.removeAll();
		
		gameImg2 = new ImageIcon("images/m.png");
		gameImgPan2 = new JLabel(gameImg2);
		gameImgPan2.setBounds(140, 70, 550, 300);
		
		text2 = new JLabel("게임 설명 주절주2");
		text2.setFont(font1);
		text2.setHorizontalAlignment(JLabel.CENTER);
		text2.setBounds(140, 380, 550, 120);
		text2.setOpaque(true);
		text2.setBackground(Color.pink);
		
		prev.setVisible(true);
		next.setVisible(true);
		bgSkPan.add(next);
		bgSkPan.add(prev);
		bgSkPan.add(exit);
		bgSkPan.add(text2);
		bgSkPan.add(gameImgPan2);
		revalidate();
		repaint();
	}

	public void last() {
//		bgSkPan.removeAll();

		gameImg3 = new ImageIcon("images/m.png");
		gameImgPan3 = new JLabel(gameImg3);
		gameImgPan3.setBounds(140, 70, 550, 300);
		
		text3 = new JLabel("게임 설명 주절주3");
		text3.setFont(font1);
		text3.setHorizontalAlignment(JLabel.CENTER);
		text3.setBounds(140, 380, 550, 120);
		text3.setOpaque(true);
		text3.setBackground(Color.pink);
		
		next.setVisible(false);
		bgSkPan.add(next);
		bgSkPan.add(prev);
		bgSkPan.add(exit);
		bgSkPan.add(text3);
		bgSkPan.add(gameImgPan3);
		revalidate();
		repaint();
	}

//	public static void main(String[] args) {
//		new GameHowTo().setVisible(true);
//	}

}
