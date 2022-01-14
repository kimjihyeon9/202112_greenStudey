package Day23_1_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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

class MyCenterPan extends JPanel {
	Image img;
	String imagePath = "F:\\JH\\자바_12월\\Day23_Thread\\src\\Day23_1\\airplan01.png";
	BufferedImage bfImg;
	public int x = 300, y = 300;

	public MyCenterPan() {
		// img = Toolkit.getDefaultToolkit().getImage(imagePath);
		// 이미지나 그래픽 관련 메소드는 라이프사이클에 의해서 자동 실행 된다.
		// paint(), repaint(), paintComponent()
//	      try {
//	         bfImg = ImageIO.read(this.getClass().getResource("airplan01.png"));
//	      } catch (IOException e) {
//	         e.printStackTrace();
//	      }
		// ImageIcon imgIcon = new ImageIcon("src/org/comtudy21/day23/airplan01.png");
		ImageIcon imgIcon = new ImageIcon("images/airplan01.png");

		// ImageIcon imgIcon = new ImageIcon(getClass().getResource("airplan01.png"));
		// 이미지 아이콘은 이미지가 아니다.
		img = imgIcon.getImage();

		setLayout(null);
		// JLabel()에 ImageIcon 객체 사용 가능.
		JLabel imgLbl = new JLabel(imgIcon);
		this.add(imgLbl);
		imgLbl.setBounds(300, 300, 50, 100);
		// 이미지 크기도 조정

	}

	@Override
	protected void paintComponent(Graphics g) {
		// g.drawImage(img, x, y, 100, 100, this);
	}
}

class MyContentPan extends JPanel {
	MyCenterPan centerPan = new MyCenterPan();
	JButton leftBtn = new JButton("Left");
	JButton rightBtn = new JButton("Right");

	public MyContentPan() {
		setBackground(Color.PINK);
		layoutComponent();
		actionEvetn();
	}

	private void actionEvetn() {
		leftBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼을 누르면 비행기가 화면의 좌측으로 이동한다.
				centerPan.repaint(); // 해당 콤포넌트의 화면을 다시 그린다.
			}
		});
		rightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼을 누르면 비행기가 화면의 우측으로 이동한다.

			}
		});
	}

	private void layoutComponent() {
		setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, new JLabel("이미지 사용하기"));
		this.add(centerPan);
		JPanel bottomPan = new JPanel(new FlowLayout());
		bottomPan.add(leftBtn);
		bottomPan.add(rightBtn);
		this.add(BorderLayout.SOUTH, bottomPan);
	}
}

public class Ex01_ImgIO extends JFrame {
	Container contentPan;

	public Ex01_ImgIO() {
		setTitle("이미지 불러오기 실습");
		setSize(640, 500);

		// contentPan = getContentPane();
		MyContentPan myContentPan = new MyContentPan();
		setContentPane(myContentPan);
	}

	public static void main(String[] args) {
		new Ex01_ImgIO().setVisible(true);
	}

}