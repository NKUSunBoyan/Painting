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
        setOpaque(true); //设置透明
        setHorizontalAlignment(CENTER);//设置本标签水平居中对齐
        setVerticalAlignment(CENTER);//设置本标签垂直居中对齐
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
