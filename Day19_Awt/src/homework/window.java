package homework;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class window extends MyFrame_hw {
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
		super("window 창", 600, 400);
		
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

	public static void main(String[] args) {
		new window().setVisible(true);
	}

}
