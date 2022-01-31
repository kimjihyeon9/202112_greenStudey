package Life_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameContainer.GameContainer;

// 해결해야하는 부분
// 드래그앤드롭 드래그하면 오답일시 제자리로 돌리기
// 정답칸에 근처로 가면 딱붙는 기능 넣기(충돌검사)
// 문제 지문 가운데정렬하기 
// 배경보이기 - 해결
// 드래그앤드롭 사각형에 문제지문이 들어갈수있게 하기 - 해결
// 정답칸에 숫자(1, 2, 3, 4) 넣기 - 순서 보여주기용도 - 해결
// 마우스 가운데로 맞추기 - 해결

public class LifeGamePanel extends GameContainer implements MouseListener, MouseMotionListener {
	private ImageIcon bgImg;
	private JLabel bgImgPan;

	private ImageIcon checkIcon;
	private ImageIcon xIcon;
	private JLabel checkLabel;
	private JLabel xLabel;

	LifeGameConsole lgc;

	// 드래그 앤 드롭
	private JLabel a1;
	private JLabel a2;
	private JLabel a3;
	private JLabel a4;
	
	private Font font1;

	private boolean drag1;
	private boolean drag2;
	private boolean drag3;
	private boolean drag4;
	
	int mouseX1 = 0;
	int mouseX2 = 0;
	int mouseX3 = 0;
	int mouseX4 = 0;
	int mouseY1 = 0;
	int mouseY2 = 0;
	int mouseY3 = 0;
	int mouseY4 = 0;

	public LifeGamePanel() {
		lgc = new LifeGameConsole();
		this.setLayout(null);

		// 배경을 선언하고 add까지 했지만 들어가지 않음...
		bgImg = new ImageIcon("images/gamebg.png");
		bgImgPan = new JLabel(bgImg);
		bgImgPan.setSize(1024, 768);

		checkIcon = new ImageIcon("images/o.png");
		checkLabel = new JLabel(checkIcon);
		xIcon = new ImageIcon("images/x.png");
		xLabel = new JLabel(xIcon);
		checkLabel.setBounds(670, 65, 150, 150);
		this.add(checkLabel);
		checkLabel.setVisible(false);
		xLabel.setBounds(670, 65, 150, 150);
		this.add(xLabel);
		xLabel.setVisible(false);

		// 드래그 앤 드롭
		a1 = new JLabel(lgc.a[lgc.b[0]]);
		a2 = new JLabel(lgc.a[lgc.b[1]]);
		a3 = new JLabel(lgc.a[lgc.b[2]]);
		a4 = new JLabel(lgc.a[lgc.b[3]]);
		a1.setHorizontalAlignment(JLabel.CENTER);
		a2.setHorizontalAlignment(JLabel.CENTER);
		a3.setHorizontalAlignment(JLabel.CENTER);
		a4.setHorizontalAlignment(JLabel.CENTER);
		font1 = new Font("맑은 고딕", Font.BOLD, 24);
		a1.setFont(font1);
		a2.setFont(font1);
		a3.setFont(font1);
		a4.setFont(font1);
		drag1 = false;
		drag2 = false;
		drag3 = false;
		drag4 = false;

		a1.setOpaque(true);
		a2.setOpaque(true);
		a3.setOpaque(true);
		a4.setOpaque(true);
		a1.setBackground(new Color(233, 23, 22));
		a2.setBackground(new Color(254, 228, 55));
		a3.setBackground(new Color(33, 139, 34));
		a4.setBackground(new Color(81, 107, 254));
		a1.setBounds(362, 130, 300, 80);
		a2.setBounds(362, 220, 300, 80);
		a3.setBounds(362, 310, 300, 80);
		a4.setBounds(362, 400, 300, 80);
		a1.addMouseMotionListener(this);
		a2.addMouseMotionListener(this);
		a3.addMouseMotionListener(this);
		a4.addMouseMotionListener(this);
		a1.addMouseListener(this);
		a2.addMouseListener(this);
		a3.addMouseListener(this);
		a4.addMouseListener(this);
		bgImgPan.add(a1);
		bgImgPan.add(a2);
		bgImgPan.add(a3);
		bgImgPan.add(a4);

		// 정답칸 만들기
		// 문제점 : 문제의 지문의 길이가 길면 정답칸도 길어져서 순서를 맞출때 크기가 애매해질수있다
		// 어떻게 해결할지 고민하기
		JPanel ans1 = new JPanel();
		JPanel ans2 = new JPanel();
		JPanel ans3 = new JPanel();
		JPanel ans4 = new JPanel();
		JLabel num1 = new JLabel(lgc.a[0]); // 정답부분 : lgc.a[0] -> 이걸로 정답찾기
		JLabel num2 = new JLabel(lgc.a[1]);
		JLabel num3 = new JLabel(lgc.a[2]);
		JLabel num4 = new JLabel(lgc.a[3]);
		ans1.setBounds(150, 550, 100, 100);
		ans2.setBounds(350, 550, 100, 100);
		ans3.setBounds(550, 550, 100, 100);
		ans4.setBounds(750, 550, 100, 100);

		ans1.add(num1);
		ans2.add(num2);
		ans3.add(num3);
		ans4.add(num4);
		bgImgPan.add(ans1);
		bgImgPan.add(ans2);
		bgImgPan.add(ans3);
		bgImgPan.add(ans4);

		this.add(bgImgPan);
	}

	// 드래그 앤 드롭
	@Override
	public void mouseDragged(MouseEvent e) {
		if (drag1 == true) {
			JComponent jc = (JComponent) e.getSource();
			jc.setLocation(jc.getX() + e.getX() - mouseX1, jc.getY() + e.getY() - mouseY1);
		}
		if (drag2 == true) {
			JComponent jc = (JComponent) e.getSource();
			jc.setLocation(jc.getX() + e.getX() - mouseX2, jc.getY() + e.getY() - mouseY2);
		}
		if (drag3 == true) {
			JComponent jc = (JComponent) e.getSource();
			jc.setLocation(jc.getX() + e.getX() - mouseX3, jc.getY() + e.getY() - mouseY3);
		}
		if (drag4 == true) {
			JComponent jc = (JComponent) e.getSource();
			jc.setLocation(jc.getX() + e.getX() - mouseX4, jc.getY() + e.getY() - mouseY4);
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	// 사각형 안에서 클릭시 움직이게
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == a1) {
			drag1 = true;
			mouseX1 = e.getX();
			mouseY1 = e.getY();
		}
		if (e.getSource() == a2) {
			drag2 = true;
			mouseX2 = e.getX();
			mouseY2 = e.getY();
		}
		if (e.getSource() == a3) {
			drag3 = true;
			mouseX3 = e.getX();
			mouseY3 = e.getY();
		}
		if (e.getSource() == a4) {
			drag4 = true;
			mouseX4 = e.getX();
			mouseY4 = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drag1 = false;
		drag2 = false;
		drag3 = false;
		drag4 = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void gamePlay() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
