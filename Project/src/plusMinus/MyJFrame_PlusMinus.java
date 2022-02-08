package plusMinus;

import java.awt.Container;

import javax.swing.JFrame;

import plusMinus.PlusMinus;

public class MyJFrame_PlusMinus extends JFrame{
	
	Container contentPan;
	
	public MyJFrame_PlusMinus() {
		setTitle("PlusMinus");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1024,768);

		contentPan = getContentPane();
		
		contentPan.add(new PlusMinus());
	}
	
	public static void main(String[] args) {
			new MyJFrame_PlusMinus().setVisible(true);
	}
}