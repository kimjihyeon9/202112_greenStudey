package Life_game;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gameContainer.GameContainer;

public class LifeGamePanel extends GameContainer {
	private ImageIcon bgImg;
	private JLabel bgImgPan;
	
	private ImageIcon checkIcon;
	private ImageIcon xIcon;
	private JLabel checkLabel;
	private JLabel xLabel;
	
	LifeGameConsole lgc;
	
	public LifeGamePanel() {
		lgc = new LifeGameConsole();
		this.setLayout(null);
		
		bgImg = new ImageIcon("images/gamebg.png");
		bgImgPan = new JLabel(bgImg);
		bgImgPan.setSize(1024, 768);
		
		checkIcon = new ImageIcon("images/o.png");
		checkLabel = new JLabel(checkIcon);
		xIcon = new ImageIcon("images/x.png");
		xLabel = new JLabel(xIcon);
		checkLabel.setBounds(670, 65, 150, 150);
		this.add(checkLabel);
		checkLabel.setVisible(false);
		xLabel.setBounds(670, 65, 150, 150);
		this.add(xLabel);
		xLabel.setVisible(false);
		
		
	}

	@Override
	public void gamePlay() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
