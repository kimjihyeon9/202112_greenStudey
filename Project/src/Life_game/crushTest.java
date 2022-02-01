package Life_game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameContainer.GameContainer;

public class crushTest extends GameContainer implements MouseListener, MouseMotionListener {
	private JLabel a1;
	private JLabel a2;
	private boolean drag1;
	private boolean drag2;
	private ImageIcon bgImg;
	private JLabel bgImgPan;
	
	int mouseX1 = 0;
	int mouseX2 = 0;
	int mouseY1 = 0;
	int mouseY2 = 0;

	private JPanel ans1;
	private JPanel ans2;

	int x = 150;
	int y = 550;
	int w = 100;
	int h = 100;
	int x0 = 350;
	int y0 = 550;
	int w0 = 100;
	int h0 = 100;

	int x1 = 362;
	int y1 = 130;
	int w1 = 80;
	int h1 = 80;

	int x2 = 402;
	int y2 = 130;
	int w2 = 80;
	int h2 = 80;

//	private int b1 = x1 + w / 2;
//	private int b2 = y1 + h / 2;

	public crushTest() {
		this.setLayout(null);

		bgImg = new ImageIcon("images/gamebg.png");
		bgImgPan = new JLabel(bgImg);
		bgImgPan.setSize(1024, 768);

		a1 = new JLabel();
		drag1 = false;
		a2 = new JLabel();
		drag2 = false;

		a1.setOpaque(true);
		a1.setBackground(new Color(233, 23, 22));
		a1.setBounds(x1, y1, w1, h1);
		a1.addMouseMotionListener(this);
		a1.addMouseListener(this);
		bgImgPan.add(a1);
		a2.setOpaque(true);
		a2.setBackground(new Color(133, 23, 22));
		a2.setBounds(x2, y2, w2, h2);
		a2.addMouseMotionListener(this);
		a2.addMouseListener(this);
		bgImgPan.add(a2);

		ans1 = new JPanel();
		ans1.setBounds(x, y, w, h);
		bgImgPan.add(ans1);
		ans2 = new JPanel();
		ans2.setBounds(x0, y0, w0, h0);
		bgImgPan.add(ans2);

		this.add(bgImgPan);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setBounds(0, 0, 1024, 768);
		f.add(new crushTest());
		f.setVisible(true);
	}
	
	public void crush(int centerX, int centerY, int x, int y, int w, int h, JPanel ans) {
		if (centerX > x && centerX < x + w) {
			if (centerY > y && centerY < y + h) {
				ans.setBackground(Color.black);
				revalidate();
				repaint();
			}
		} else {
			ans.setBackground(Color.white);
			revalidate();
			repaint();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (drag1 == true) {
			JComponent jc = (JComponent) e.getSource();
			jc.setLocation(jc.getX() + e.getX() - mouseX1, jc.getY() + e.getY() - mouseY1);

//			x = jc.getX();
//			y = jc.getY();
//			
//			if(x < b1 && (x + w) > b1) {
//				if(y < b2 && (y + h) > b2){
//					ans1.setBackground(Color.black);
//					System.out.println("충돌했습니다");
//				}
//			}
			x1 = jc.getX();
			y1 = jc.getY();
			
			int centerX = x1 + w1 / 2;
			int centerY = y1 + h1 / 2;
			
			crush(centerX, centerY, x, y, w, h, ans1);
			crush(centerX, centerY, x0, y0, w0, h0, ans2);

//			if (centerX > x && centerX < x + w) {
//				if (centerY > y && centerY < y + h) {
//					ans1.setBackground(Color.black);
//					revalidate();
//					repaint();
//				}
//			} else {
//				ans1.setBackground(Color.white);
//				revalidate();
//				repaint();
//			}
		}
		if (drag2 == true) {
			JComponent jc = (JComponent) e.getSource();
			jc.setLocation(jc.getX() + e.getX() - mouseX2, jc.getY() + e.getY() - mouseY2);
			
			x2 = jc.getX();
			y2 = jc.getY();
			
			int centerX = x2 + w2 / 2;
			int centerY = y2 + h2 / 2;
			
			crush(centerX, centerY, x, y, w, h, ans1);
			crush(centerX, centerY, x0, y0, w0, h0, ans2);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drag1 = false;
		drag2 = false;
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
