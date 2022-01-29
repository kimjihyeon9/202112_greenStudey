package Life_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 해결해야하는 부분
// 드래그앤드롭 사각형에 문제지문이 들어갈수있게 하기
// 드래그앤드롭 드래그하면 오답일시 제자리로 돌리기
// 배경보이기
// 정답칸에 근처로 가면 딱붙는 기능 넣기(충돌검사)
// 정답칸에 숫자(1, 2, 3, 4) 넣기 - 순서 보여주기용도

public class LifeGamePanel extends JComponent implements MouseListener, MouseMotionListener {
	private ImageIcon bgImg;
	private JLabel bgImgPan;

	private ImageIcon checkIcon;
	private ImageIcon xIcon;
	private JLabel checkLabel;
	private JLabel xLabel;

//	LifeGameConsole lgc; // 잠시 필요가 없어서 주석처리!!

	// 드래그 앤 드롭
	Rectangle box1;
	Rectangle box2;
	Rectangle box3;
	Rectangle box4;
	boolean isDragged1;
	boolean isDragged2;
	boolean isDragged3;
	boolean isDragged4;
	int X1, Y1;
	int X2, Y2;
	int X3, Y3;
	int X4, Y4;

	public LifeGamePanel() {
//		lgc = new LifeGameConsole();
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
		
		// 정답칸 만들기
		// 문제점 : 문제의 지문의 길이가 길면 정답칸도 길어져서 순서를 맞출때 크기가 애매해질수있다
		// 		어떻게 해결할지 고민하기
		// bgImgPan이 보이지 않아서 ans1~4도 보이지 않음
		JPanel ans1 = new JPanel();
		JPanel ans2 = new JPanel();
		JPanel ans3 = new JPanel();
		JPanel ans4 = new JPanel();
		ans1.setBounds(100, 650, 100, 100);
		ans2.setBounds(100, 650, 100, 100);
		ans3.setBounds(100, 650, 100, 100);
		ans4.setBounds(100, 650, 100, 100);
		
		bgImgPan.add(ans1);
		bgImgPan.add(ans2);
		bgImgPan.add(ans3);
		bgImgPan.add(ans4);
		
		this.add(bgImgPan);

		// 드래그 앤 드롭
		box1 = new Rectangle(362, 130, 300, 80);
		box2 = new Rectangle(362, 220, 300, 80);
		box3 = new Rectangle(362, 310, 300, 80);
		box4 = new Rectangle(362, 400, 300, 80);
//		Label a = new Label("문제");
//		box1.add(a);
		isDragged1 = false;
		isDragged2 = false;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	// 드래그 앤 드롭
	// 사각형 색
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(box1.x, box1.y, box1.width, box1.height); // 이동하기 위해 사각형 좌표와 마우스 좌표 필요!!
		g.drawRect(box2.x, box2.y, box2.width, box2.height); 
		g.drawRect(box3.x, box3.y, box3.width, box3.height); 
		g.drawRect(box4.x, box4.y, box4.width, box4.height); 
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (isDragged1) {
			box1.x = e.getX() - X1;
			box1.y = e.getY() - Y1;
		}
		if (isDragged2) {
			box2.x = e.getX() - X2;
			box2.y = e.getY() - Y2;
		}
		if (isDragged3) {
			box3.x = e.getX() - X3;
			box3.y = e.getY() - Y3;
		}
		if (isDragged4) {
			box4.x = e.getX() - X4;
			box4.y = e.getY() - Y4;
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	// 사각형 안에서 클릭시 움직이게
	@Override
	public void mousePressed(MouseEvent e) {
		if (box1.contains(new Point(e.getX(), e.getY()))) {
			X1 = e.getX() - box1.x;
			Y1 = e.getY() - box1.y;
			isDragged1 = true;
		}
		if (box2.contains(new Point(e.getX(), e.getY()))) {
			X2 = e.getX() - box2.x;
			Y2 = e.getY() - box2.y;
			isDragged2 = true;
		}
		if (box3.contains(new Point(e.getX(), e.getY()))) {
			X3 = e.getX() - box3.x;
			Y3 = e.getY() - box3.y;
			isDragged3 = true;
		}
		if (box4.contains(new Point(e.getX(), e.getY()))) {
			X4 = e.getX() - box4.x;
			Y4 = e.getY() - box4.y;
			isDragged4 = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isDragged1 = false;
		isDragged2 = false;
		isDragged3 = false;
		isDragged4 = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
