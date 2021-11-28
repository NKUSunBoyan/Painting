package sunboyan;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class LowPanel extends JToolBar{
	private static JLabel stateLabel = null;
	private static JCheckBox checkBox =null;
	public LowPanel() {
		stateLabel = Vars.getStateLabel();
		checkBox = Vars.getCheckBox();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(stateLabel);
		add(checkBox);
	}
}
