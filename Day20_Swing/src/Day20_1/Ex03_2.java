package Day20_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui_myframe.MyFrame;

public class Ex03_2 extends MyFrame implements ActionListener {
	Label lbl = new Label("[Result] Nothing to do");
	
	Panel leftPan = new Panel();
	Panel southPan = new Panel();
	Panel centerPan = new Panel(new GridBagLayout());

	Button btn1 = new Button("typy 01");
	Button btn2 = new Button("typy 02");
	Button btn3 = new Button("Save");
	Button btn4 = new Button("Cancle");

	TextField txtFld1 = new TextField(10);
	TextField txtFld2 = new TextField(10);
	TextField txtFld3 = new TextField(10);
	TextField txtFld4 = new TextField(10);
	TextField txtFld5 = new TextField(10);

	Checkbox gen1 = new Checkbox("Man");
	Checkbox gen2 = new Checkbox("Woman");

	public Ex03_2() {
		super("Member management system", 640, 480);

		add(BorderLayout.WEST, leftPan);
		Panel rowPan1 = new Panel();
		rowPan1.add(new Label("    Info     : "));
		rowPan1.add(btn1);
		rowPan1.add(btn2);

		Panel rowPan2 = new Panel();
		rowPan2.add(new Label("  No     : "));
		rowPan2.add(txtFld1);

		Panel rowPan3 = new Panel();
		rowPan3.add(new Label("Name : "));
		rowPan3.add(txtFld2);

		Panel rowPan4 = new Panel();
		rowPan4.add(new Label("Email : "));
		rowPan4.add(txtFld3);

		Panel rowPan5 = new Panel();
		rowPan5.add(new Label("Phone : "));
		rowPan5.add(txtFld4);

		Panel rowPan6 = new Panel();
		rowPan6.add(new Label("Subject : "));
		rowPan6.add(txtFld5);

		Panel rowPan7 = new Panel();
		rowPan7.add(new Label("Gender : "));
		rowPan7.add(gen1);
		rowPan7.add(gen2);

		Panel gridPan = new Panel(new GridLayout(8, 1));
		gridPan.add(rowPan1);
		gridPan.add(rowPan2);
		gridPan.add(rowPan3);
		gridPan.add(rowPan4);
		gridPan.add(rowPan5);
		gridPan.add(rowPan6);
		gridPan.add(rowPan7);

		leftPan.add(gridPan);

		add(BorderLayout.SOUTH, southPan);
		Panel ynPan = new Panel();
		ynPan.add(btn3);
		ynPan.add(btn4);
		southPan.add(ynPan);

		add(BorderLayout.CENTER, centerPan);
		centerPan.add(lbl);
		centerPan.setBackground(Color.LIGHT_GRAY);

		run();
	}

	private void run() {
		// 익명 내부 클래스를 이용한 이벤트 핸들러 처리
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}

	public static void main(String[] args) {
		new Ex03_2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btn3.equals(e.getSource())) {
			lbl.setText("[Result] save pressed!!!");
		} else if (btn4.equals(e.getSource())) {
			lbl.setText("[Result] cancle pressed!!!");
		}
	}

}
