package Day20_5;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class window extends JFrame {
	Button btn1 = new Button("All list");
	Button btn2 = new Button("Add");
	Button btn3 = new Button("Delete");
	Button btn4 = new Button("Search");
	Button btn5 = new Button("Cancle");
	
	Label lb1 = new Label("Number");
	Label lb2 = new Label("Name");
	Label lb3 = new Label("Email");
	Label lb4 = new Label("PhoneNumber");
	
	Panel pan = new Panel(new GridLayout(8, 5, 0, 0));
	Panel southPan = new Panel(new FlowLayout());
	Panel centerPan = new Panel(new FlowLayout());
	
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	Panel p4 = new Panel();
	
	TextField tf1 = new TextField(8);
	TextField tf2 = new TextField(10);
	TextField tf3 = new TextField(10);
	TextField tf4 = new TextField(5);
	
	public window() {
		view("window", 640, 480);
		info();
		button();
	}

	public void button() {
		southPan.add(btn1);
		southPan.add(btn2);
		southPan.add(btn3);
		southPan.add(btn4);
		southPan.add(btn5);
		this.add(BorderLayout.SOUTH, southPan);
	}
	
	public void info() {
		this.add(BorderLayout.CENTER, centerPan);
		TextArea ta = new TextArea("", 20, 60);
		centerPan.add(ta);
		
		this.add(BorderLayout.WEST, pan);
		pan.add(p1);
		p1.add(lb1);
		p1.add(tf1);
		
		pan.add(p2);
		p2.add(lb2);
		p2.add(tf2);
		
		pan.add(p3);
		p3.add(lb3);
		p3.add(tf3);
		
		pan.add(p4);
		p4.add(lb4);
		p4.add(tf4);
	}
	
	public void view(String title, int w, int h) {
		this.setTitle(title);
		super.setSize(w, h);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int)tk.getScreenSize().getWidth();
		int scrHeigh = (int)tk.getScreenSize().getHeight();
		
		int x = scrWidth / 2 - w / 2;
		int y = scrHeigh / 2 - h / 2;
		
		this.setLocation(x, y);
	}

	public static void main(String[] args) {
		new window().setVisible(true);
	}

}
