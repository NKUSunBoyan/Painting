package sunboyan;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar{
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;
	private JPanel panel5 = null;
	private JPanel panel6 = null;
	public ToolBar() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel2.add(new JLabel("背景色"));
		panel2.add(Vars.getBackColorBox());
		panel1.add(new JLabel("前景色"));
		panel1.add(Vars.getShapeColorBox());
		panel3.add(new JLabel("文字"));
		panel3.add(Vars.getTextField());
		panel4.add(new JLabel("字体"));
		panel4.add(Vars.getFontPanel());
		panel5.add(Vars.getUndoButton());
		panel6.add(Vars.getSaveButton());
		setLayout(new GridLayout(2,3));
		add(panel1,getLayout());
		add(panel2,getLayout());
		add(panel3,getLayout());
		add(panel4,getLayout());
		add(panel5,getLayout());
		add(panel6,getLayout());
	}
	
}
