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
	
	int x = 150;
	int x1 = 362;
	int y = 550;
	int y1 = 130;
	int w = 100;
	int w1 = 80;
	int h = 100;
	int h1 = 80;
	
	private int b1 = x1 + w/2;
	private int b2 = y1 + h/2;
	
	public crushTest() {
		this.setLayout(null);
		
		bgImg = new ImageIcon("images/gamebg.png");
		bgImgPan = new JLabel(bgImg);
		bgImgPan.setSize(1024, 768);
		
		a1 = new JLabel();
		a2 = new JLabel();
		drag1 = false;
		drag2 = false;
		
		a1.setOpaque(true);
		a2.setOpaque(true);
		a1.setBackground(new Color(233, 23, 22));
		a2.setBackground(new Color(254, 228, 55));
		a1.setBounds(x1, y1, w1, h1);
		a2.setBounds(362, 220, 80, 80);
		a1.addMouseMotionListener(this);
		a2.addMouseMotionListener(this);
		a1.addMouseListener(this);
		a2.addMouseListener(this);
		bgImgPan.add(a1);
		bgImgPan.add(a2);
		
		ans1 = new JPanel();
		ans1.setBounds(x, y, w, h);
		bgImgPan.add(ans1);
		
		this.add(bgImgPan);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setBounds(0, 0, 1024, 768);
		f.add(new crushTest());
		f.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (drag1 == true) {
			JComponent jc = (JComponent) e.getSource();
			jc.setLocation(jc.getX() + e.getX() - mouseX1, jc.getY() + e.getY() - mouseY1);
			
			if(x < b1 && (x + w) > b1) {
				if(y < b2 && (y + h) > b2){
					ans1.setBackground(Color.black);
				}
			}
		}
		if (drag2 == true) {
			JComponent jc = (JComponent) e.getSource();
			jc.setLocation(jc.getX() + e.getX() - mouseX2, jc.getY() + e.getY() - mouseY2);
		}
		repaint();
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
		if(x < b1 && (x + w) > b1) {
			if(y < b2 && (y + h) > b2){
				ans1 = (JPanel) e.getSource();
				ans1.setBackground(Color.black);
			}
		}
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
