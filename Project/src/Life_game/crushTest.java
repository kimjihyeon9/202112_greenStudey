package Life_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class crushTest extends JComponent implements MouseListener, MouseMotionListener {
	Rectangle box1;
	Rectangle box2;
	boolean isDragged1;
	boolean isDragged2;
	int X1, Y1;
	int X2, Y2;
	
	public crushTest() {
		box1 = new Rectangle(0, 0, 100, 100);
		box2 = new Rectangle(200, 200, 100, 100);
		isDragged1 = false;
		isDragged2 = false;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setBounds(0, 0, 1024, 768);
		f.add(new crushTest());
		f.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(box1.x, box1.y, box1.width, box1.height);
		g.drawRect(box2.x, box2.y, box2.width, box2.height);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(isDragged1) {
			box1.x = e.getX() - X1;
			box1.y = e.getY() - Y1;
		}
		if(isDragged2) {
			box2.x = e.getX() - X2;
			box2.y = e.getY() - Y2;
		}
		repaint();
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
		if(box1.contains(new Point(e.getX(), e.getY()))) {
			X1 = e.getX() - box1.x;
			Y1 = e.getY() - box1.y;
			isDragged1 = true;
		}
		if(box2.contains(new Point(e.getX(), e.getY()))) {
			X2 = e.getX() - box2.x;
			Y2 = e.getY() - box2.y;
			isDragged2 = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isDragged1 = false;
		isDragged2 = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
