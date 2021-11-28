package sunboyan;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ShapeBar extends JPanel {
	private static JToggleButton circleButton = null;
	private static JToggleButton squareButton = null;
	private static JToggleButton textButton = null;
	private static JToggleButton ellipseButton = null;
	private static JToggleButton lineButton = null;
	private static JToggleButton boldButton = null;
	public ShapeBar() {
		circleButton = Vars.getCircleButton();
		squareButton = Vars.getSquareButton();
		textButton = Vars.getTextButton();
		ellipseButton = Vars.getEllipseButton();
		lineButton = Vars.getLineButton();
		boldButton = Vars.getBoldButton();
		setLayout(new GridLayout(6,1));
		add(circleButton);
		add(ellipseButton);
		add(squareButton);
		add(textButton);
		add(lineButton);
		add(boldButton);
	}
	
}
