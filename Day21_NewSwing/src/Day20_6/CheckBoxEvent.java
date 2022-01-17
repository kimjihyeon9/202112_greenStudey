package Day20_6;

import static Day20_6.R.ch;
import static Day20_6.R.chTxt;
import static Day20_6.R.img;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui_myframe.MyJFrame;

public class CheckBoxEvent extends MyJFrame {
	private JLabel imgLbl = new JLabel();
	
	
	class MyItemListener implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
				return;
			if(ch[0].isSelected())
				imgLbl.setIcon(img[0]);
			else if(ch[1].isSelected())
				imgLbl.setIcon(img[1]);
			else if(ch[2].isSelected())
				imgLbl.setIcon(img[2]);
		}
		
	}
	
	public CheckBoxEvent() {
		JPanel chPane = new JPanel();
		Container c = getContentPane();
		c.setLayout(new GridLayout());
		
		MyItemListener listener = new MyItemListener();
		for(int i = 0; i < ch.length; i++) {
			ch[i] = new JCheckBox(chTxt[i]);
			ch[i].setBorderPainted(true);
			c.add(ch[i]);
			ch[i].addItemListener(listener);
		}
		c.add(chPane, BorderLayout.NORTH);
		c.add(imgLbl, BorderLayout.CENTER);
		imgLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		setSize(600, 200);
		
	}
	public static void main(String[] args) {
		new CheckBoxEvent().setVisible(true);
	}

	@Override
	protected void displayLayer() {}

	@Override
	protected void actionEvt() {}
}
