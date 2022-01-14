package Day23_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyContentPanTest01 extends JPanel {
	JLabel label;

	public MyContentPanTest01() {
		label = new JLabel("우리는 하나다!");
		Font font = new Font("궁서체", Font.ITALIC, 48);
		label.setFont(font);
		this.add(label);
	}
}

class Airplan01 extends JPanel {
	Image img;
	String imagePath = "F:\\JH\\자바_12월\\Day23_Thread\\src\\Day23_1\\airplan01.png";
	BufferedImage bfimg;
	public int x = 300, y = 300;
	public JLabel imgLbl = null;

	public Airplan01() {
		// img = Toolkit.getDefaultToolkit().getImage(imagePath);
		// 이미지나 그래픽 관련 메소드는 라이프사이클에 의해서 자동 실행 된다.
		// paint(), repaint(), paintComponent()
		// 1 번째 방법
//		try {
//			bfimg = ImageIO.read(this.getClass().getResource("airplan01.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// 2번째 방법
		// 이미지 아이콘은 이미지가 아니다.
		ImageIcon imgIcon = new ImageIcon("src/Day23_1/airplan01.png"); // -> 절대 경로
//		ImageIcon imgIcon = new ImageIcon(getClass().getResource("airplan01.png"));

		img = imgIcon.getImage();
		// 이미지 크기도 조정
		Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(newimg);

//		setLayout(null);
		// JLabel()은 imgIcon 객체 사용가능
		imgLbl = new JLabel(imgIcon);
		this.add(imgLbl);

		// 2번쨰 방법 --> 혼자 해봄
//		Image img = imgIcon.getImage();
//		Image newimg = img.getScaledInstance(150,180, Image.SCALE_SMOOTH);
//		ImageIcon imageIcon02 = new ImageIcon(newimg);
//		this.add(new JLabel(imageIcon02));

	}

	@Override
	public void paintComponent(Graphics g) {
//		g.drawImage(bfimg, x, y, 100, 100, this);
	}

}

class Airplan02 extends JPanel implements Runnable {
	String imagePath = "F:\\JH\\자바_12월\\Day23_Thread\\src\\Day23_1\\airplan02.png";
	Image img = null;
	ImageIcon imgIco = null;
	int x = 100, y = -100, w = 100, h = 100;
	MyCenterPan centerPan;
	Random rand = new Random();

	public Airplan02(MyCenterPan centerPan) {
		this.centerPan = centerPan;
		x = 100 + (int) rand.nextInt(500);

		imgIco = new ImageIcon(imagePath);
		img = imgIco.getImage();
		Image newImg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		imgIco = new ImageIcon(newImg);
		add(new JLabel(imgIco));

//		MyCenterPan center = this.centerPan;
//		centerPan.y2 = 300;
//		this.setBounds(x, y, w, h);
	}

	public void movePlain() {
		this.setBounds(x, y, w, h);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
				// 좌표를 변경하고 다시 그리기
				y += 3;
				if (y >= 600) {
					y = -100;
					x = 100 + (int) rand.nextInt(500);
				}
				movePlain();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class AirplanStarterThread extends Thread {
	Airplan02[] airplan02;

	public AirplanStarterThread(Airplan02[] airplan02) {
		this.airplan02 = airplan02;
	}

	@Override
	public void run() {
		for (int i = 0; i < airplan02.length; i++) {
			Thread th = new Thread(airplan02[i]);
			th.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Bullet extends JPanel implements Runnable {
	MyCenterPan centerPan;
	String imagePath = "src/Day23_1/bulet.png";
	Image img = null;
	ImageIcon imgIco = null;
	int x = 350, y = 400, w = 50, h = 70;

	public Bullet(MyCenterPan centerPan) {
		this.centerPan = centerPan;
		x = centerPan.x1 + 20;
		imgIco = new ImageIcon(imagePath);
		img = imgIco.getImage();
		Image newImg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		imgIco = new ImageIcon(newImg);
		add(new JLabel(imgIco));
	}

	public void movePlain() {
		this.setBounds(x, y, w, h);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
				y -= 10;
				if (y < -100) {
					y = 400;
					x = centerPan.x1 + 20;
				}
				movePlain();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class BulletStarterThread extends Thread {
	Bullet[] bullet = null;
	
	public BulletStarterThread() {
		this.bullet = bullet;
	}
	
	public BulletStarterThread(Bullet[] bullet2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for(int i = 0; i < bullet.length; i++) {
			Thread bulletTh = new Thread(bullet[i]);
			bulletTh.start();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyCenterPan extends JPanel {
	int x1 = 350, y1 = 400, w1 = 100, h1 = 100;
//	int x2 = 100, y2 = 0, w2 = 100, h2 = 100;

	public Airplan01 airplan01 = new Airplan01();
	public Airplan02[] airplan02 = new Airplan02[10];
	public Bullet[] bullet = new Bullet[7];

	public MyCenterPan() {
		setLayout(null);
		add(airplan01);

		airplan01.setBounds(x1, y1, w1, h1);

		for (int i = 0; i < airplan02.length; i++) {
			airplan02[i] = new Airplan02(this);
			add(airplan02[i]);
			airplan02[i].movePlain();
			Thread airplain02th = new Thread(airplan02[i]);
		}
		
		for(int i = 0; i < bullet.length; i++) {
			bullet[i] = new Bullet(this);
			add(bullet[i]);
		}
		
		AirplanStarterThread starter = new AirplanStarterThread(airplan02);
		starter.start();
		
		BulletStarterThread bulletStarter = new BulletStarterThread(bullet);
		bulletStarter.start();
	}

	public void airplan01MoveLeft() {
		x1 -= 10;
		airplan01.setBounds(x1, y1, w1, h1);
	}

	public void airplan01MoveRight() {
		x1 += 10;
		airplan01.setBounds(x1, y1, w1, h1);
	}
}

class MyContentPan extends JPanel {
	MyCenterPan centerPan = new MyCenterPan();
	JButton leftBtn = new JButton("Left");
	JButton rightBtn = new JButton("Right");

	public MyContentPan() {
		setBackground(Color.PINK);
		layoutComponent();
		actionEvent();
	}

	private void actionEvent() {
		leftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 누르면 비행기가 화면의 좌측으로 이동한다.
				centerPan.airplan01MoveLeft();
				repaint();
				// 혼자 한 방법
//				if(e.getSource() == leftBtn) {
//					x -= 10;
//					centerPan.setLocation(x, y);
//					centerPan.repaint(); // 해당 콤포넌트의 화면을 다시 그린다.
//				}
			}
		});

		rightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼을 누르면 비행기가 화면의 우측으로 이동한다.
				centerPan.airplan01MoveRight();
				repaint();
				// 혼자 한 방법
//				if(e.getSource() == rightBtn) {
//					x += 10;
//					centerPan.setLocation(x, y);
//					centerPan.repaint(); // 해당 콤포넌트의 화면을 다시 그린다.
//				}
			}
		});
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT) {
					centerPan.airplan01MoveLeft();
					repaint();
//					System.out.println("왼쪽으로");
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					centerPan.airplan01MoveRight();
					repaint();
//					System.out.println("오른족으로");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
		});
		// Focus를 읽을 수 있도록 설정
		this.setFocusable(true);
		this.requestFocus();
	}

	private void layoutComponent() {
		setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, new JLabel("미사일로 비행기 맞추기 게임 - 방향키로 비행기 조정"));
		this.add(centerPan);
		JPanel bottomPan = new JPanel(new FlowLayout());
		bottomPan.add(leftBtn);
		bottomPan.add(rightBtn);
		this.add(BorderLayout.SOUTH, bottomPan);
	}
}

public class Day23Ex01ImgIO extends JFrame {
	Container contentPan;

	public Day23Ex01ImgIO() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("이미지 불러오기 실습");
		setSize(800, 600);

		// contentPan = getContentPane();
		MyContentPan myContentPan = new MyContentPan();
		setContentPane(myContentPan);
	}

	public static void main(String[] args) {
		new Day23Ex01ImgIO().setVisible(true);
	}

}