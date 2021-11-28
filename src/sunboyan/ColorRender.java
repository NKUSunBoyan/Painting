package sunboyan;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.Icon;
public class ColorRender extends JLabel implements ListCellRenderer<Color>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ColorRender() {
		// TODO Auto-generated constructor stub
        setOpaque(true); //����͸��
        setHorizontalAlignment(CENTER);//���ñ���ǩˮƽ���ж���
        setVerticalAlignment(CENTER);//���ñ���ǩ��ֱ���ж���
	}
	@Override
	public Component getListCellRendererComponent(JList list, Color value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		if(index == -1) {
			
		}else {
			setBackground(value);
		}
		return this;
	}

	
}
