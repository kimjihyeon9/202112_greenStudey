package Day20_6;

import java.awt.Button;
import java.awt.Image;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public abstract class R {
	public static JTable table;
	public static DefaultTableModel tbModel;
	public static JScrollPane scrollPane;
	
	public static Vector data;
	public static Vector<String> colNames;
	
	public static final JTextField txtFld1 = new JTextField(6);
	public static final JTextField txtFld2 = new JTextField(6);
	public static final JTextField txtFld3 = new JTextField(6);
	public static final JTextField txtFld4 = new JTextField(6);
	
	public static ImageIcon img1 = new ImageIcon("F:\\buttonImg\\All.jpg");
	public static Image image = img1.getImage();
	public static Image nImg1 = image.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
	public static ImageIcon img2 = new ImageIcon(nImg1);
	
	public static final JButton allbtn = new JButton(new ImageIcon(nImg1));
//	public static final JButton allbtn = new JButton(img1);
	public static final JButton inputbtn = new JButton("Input");
	public static final JButton searchbtn = new JButton("Search");
	public static final JButton modifybtn = new JButton("Modify");
	public static final JButton deletebtn = new JButton("Delete");
	public static final JButton finishbtn = new JButton("Finish");
	
//	public static ImageIcon imageIcon = new ImageIcon("F:\\img\\allBtn.png");
//	public static Image image = imageIcon.getImage();  //ImageIcon을 Image로 변환.
//	public static Image newimg = image.getScaledInstance(60,30, Image.SCALE_SMOOTH);
//	public static ImageIcon imageIcon02 = new ImageIcon(newimg); //Image로 ImageIcon 생성
//	public static final JButton allBtn = new JButton(new ImageIcon(newimg));
	
	public static final ButtonGroup rbbox = new ButtonGroup();
	public static final JRadioButton rb1 = new JRadioButton("남자", true);
	public static final JRadioButton rb2 = new JRadioButton("여자", false);
	
	public static final JCheckBox ch1 = new JCheckBox("회원", true);
	public static final JCheckBox ch2 = new JCheckBox("비회원", false);

//	public static int sequence = 4;
	
	public static final SaramDAO dao = new SaramDAO();
}
