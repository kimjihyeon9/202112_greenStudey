package Day20_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui_myframe.MyFrame;

public class Ex01_BtnEvt extends MyFrame {
	private Button[] btnArr = new Button[3];
	{ // 초기화 블럭 - 필드를 초기화 하는 구역, 메서드에서 실행문쓰기 
		btnArr[0] = new Button("Button1");
		btnArr[1] = new Button("Button2");
		btnArr[2] = new Button("Cancle");
	}
	private Label lbl = new Label("[Result] No button pressed");
	
	public Ex01_BtnEvt() {
		super("Button Event Ex", 400, 150);
		start();
		run();
	}

	private void run() {
		// 익명 내부 클래스를 이용한 이벤트 핸들러 처리
		btnArr[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText("[Result] First button pressed");
				// 배경색 바꾸기
				Button btn = (Button)(e.getSource());
				btn.setBackground(Color.blue);
			}
		});
		btnArr[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText("[Result] Second button pressed");
			}
		});
		btnArr[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText("[Result] Cancle button pressed");
			}
		});
	}

	public void start() {
		Panel southPan = new Panel();
		// Panel의 Default Layout은 FlowLayout
		southPan.add(btnArr[0]); // 어디다가 붙이는지 꼭 알려주기(southPan)
		southPan.add(btnArr[1]);
		southPan.add(btnArr[2]);
		this.add(BorderLayout.SOUTH, southPan);
		
//		Panel norPan = new Panel();
//		norPan.add(btnArr[0]);
//		norPan.add(btnArr[1]);
//		norPan.add(btnArr[2]);
//		this.add(BorderLayout.NORTH, norPan);
		
		Panel centerPan = new Panel(new GridBagLayout());
		centerPan.add(lbl);
		this.add(BorderLayout.CENTER, centerPan);
	}

	public static void main(String[] args) {
		new Ex01_BtnEvt().setVisible(true);;
	}

}
