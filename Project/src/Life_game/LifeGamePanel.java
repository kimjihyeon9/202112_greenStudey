package Life_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gameContainer.GameContainer;

public class LifeGamePanel extends GameContainer implements MouseListener, MouseMotionListener {
	// JComponent
	private ImageIcon bgImg;
	private JLabel bgImgPan;

	private ImageIcon checkIcon;
	private ImageIcon xIcon;
	private JLabel checkLabel;
	private JLabel xLabel;

	LifeGameConsole lgc;

	// 드래그 앤 드롭
	Rectangle box;
	boolean isDragged;
	int X, Y;

	public LifeGamePanel() {
		lgc = new LifeGameConsole();
		this.setLayout(null);

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
		box = new Rectangle(0, 0, 100, 100);
		isDragged = false;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void gamePlay() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	// 드래그 앤 드롭
	// 사각형 색
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(box.x, box.y, box.width, box.height); // 이동하기 위해 사각형 좌표와 마우스 좌표 필요!!
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (isDragged) {
			box.x = e.getX() - X;
			box.y = e.getY() - Y;
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
		if (box.contains(new Point(e.getX(), e.getY()))) {
			X = e.getX() - box.x;
			Y = e.getY() - box.y;
			isDragged = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isDragged = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
