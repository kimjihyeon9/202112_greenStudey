package plusMinus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gameContainer.GameContainer;
import test.RoundJButton;

// 25번, 26번, 41번 ~ 47번, 52번, 63 ~ 66번, 79번, 82번, 108 ~ 186번
public class PlusMinus extends GameContainer {
	GamePlayMain gp = new GamePlayMain();
	JLabel bgLabel; // 가장 밑배경(초록잔디)
	JLabel pmbgLabel; // 게임 배경(하얀색 메모장)
	JLabel quizLabel; // 문제 나오는 곳 라벨( num + num )

	JButton[] choiceBtn; // 4개의 선지
	JLabel checkLabel; // 정답일 경우 나오는 체크표시
	JLabel xLabel; // 오답일 경우 나오는 엑스표시
	JButton pauseBtn; // 멈춤 버튼
	JLabel manualLabel; // 설명부분
	int click = 0;
	public PlusMinus() {
		gamePlay();
	}

	@Override
	public void gamePlay() {
		this.setLayout(null);

		ImageIcon bgicon = new ImageIcon("images/gamebg.png");
		bgLabel = new JLabel(bgicon);
		bgLabel.setBounds(0, 0, 1024, 768);

		ImageIcon pmicon = new ImageIcon("images/gamebackImg.png");
		pmbgLabel = new JLabel(pmicon);
		pmbgLabel.setBounds(155, 60, 700, 600);

		manualLabel = new JLabel("알맞은 숫자를 누르세요");
		manualLabel.setBounds(320, 310, 400, 50);
		manualLabel.setHorizontalAlignment(JLabel.CENTER);
		manualLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		this.add(manualLabel);
		
		quizLabel = new JLabel(gp.question);
		quizLabel.setFont(new Font("Gothic", Font.BOLD, 115));
		quizLabel.setForeground(new Color(255, 127, 0));
		quizLabel.setBounds(315, 140, 400, 200);

		choiceBtn = new JButton[4];
		for (int i = 0; i < gp.answerArr.length; i++) {
			choiceBtn[i] = new RoundJButton();
			choiceBtn[i].setText(Integer.toString(gp.answerArr[i]));
			choiceBtn[i].setBackground(Color.orange);
			choiceBtn[i].setFont(new Font("Gothic", Font.BOLD, 70));
			choiceBtn[i].setForeground(Color.WHITE);
		}

		choiceBtn[0].setBounds(320, 380, 150, 70);
		choiceBtn[1].setBounds(540, 380, 150, 70);
		choiceBtn[2].setBounds(320, 480, 150, 70);
		choiceBtn[3].setBounds(540, 480, 150, 70);

		ImageIcon checkIcon = new ImageIcon("projectImages/checked.png");
		checkLabel = new JLabel(checkIcon);
		ImageIcon xIcon = new ImageIcon("projectImages/x.png");
		xLabel = new JLabel(xIcon);
		ImageIcon pauseIcon = new ImageIcon("projectImages/pause.png");

		pauseBtn = new JButton(pauseIcon);
		pauseBtn.setBounds(920, 30, 50, 50);
		pauseBtn.setBorderPainted(false); // 버튼의 외곽 투명하게
		pauseBtn.setContentAreaFilled(false); // 만들어 주는 것

		checkLabel.setBounds(700, 20, 150, 150);
		this.add(checkLabel);
		checkLabel.setVisible(false);
		xLabel.setBounds(700, 20, 150, 150);
		this.add(xLabel);
		xLabel.setVisible(false);

		this.add(pauseBtn);
		
		

		this.add(choiceBtn[0]);
		this.add(choiceBtn[1]);
		this.add(choiceBtn[2]);
		this.add(choiceBtn[3]);

		this.add(quizLabel);

		this.add(pmbgLabel);

		this.add(bgLabel);

		choiceBtn[0].addActionListener(this);
		choiceBtn[1].addActionListener(this);
		choiceBtn[2].addActionListener(this);
		choiceBtn[3].addActionListener(this);
		pauseBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == choiceBtn[0]) {
			if(click == 1) {
				return;
			}
			choiceBtn[0].setBackground(Color.RED);
			if (gp.answer == Integer.parseInt(choiceBtn[0].getText())) {
				gp.count++;
				click++;
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				click++;
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == choiceBtn[1]) {
			if(click == 1) {
				return;
			}
			choiceBtn[1].setBackground(Color.RED);
			if (gp.answer == Integer.parseInt(choiceBtn[1].getText())) {
				gp.count++;
				click++;
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				click++;
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == choiceBtn[2]) {
			if(click == 1) {
				return;
			}
			choiceBtn[2].setBackground(Color.RED);
			if (gp.answer == Integer.parseInt(choiceBtn[2].getText())) {
				gp.count++;
				click++;
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				click++;
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == choiceBtn[3]) {
			if(click == 1) {
				return;
			}
			choiceBtn[3].setBackground(Color.RED);
			if (gp.answer == Integer.parseInt(choiceBtn[3].getText())) {
				gp.count++;
				click++;
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				click++;
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == pauseBtn) {
			JOptionPane.showMessageDialog(pauseBtn, "정지!"); // 이벤트 처리를 위해 임시동작
		}

	}
}