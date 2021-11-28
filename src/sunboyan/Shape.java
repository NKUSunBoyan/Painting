package sunboyan;

import java.awt.Color;
import java.awt.Font;

public class Shape {
	private int x1 = 0;
	private int x2 = 0;
	private int y1 = 0;
	private int y2 = 0;
	private String string = null;
	private String textString =null;
	private Color color = null;
	private Color backColor = null;
	private Font font = new Font("Times New Roman",Font.PLAIN,20);
	public boolean filled =false;
	public boolean bold = false;
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public String getString() {
		return string;
	}
	public void setString() {
		this.string = Vars.getString();
	}
	public Color getColor() {
		return color;
	}
	public void setColor() {
		color = Vars.getColor();
	}
	public void setFont(Font font) {
		this.font = font;
	}	
	public Font getFont() {
		return font;
	}
	public Color getBackColor() {
		return backColor;
	}
	public void setBackColor(Color c) {
		backColor =c;
	}
    public Shape() {
		
	}
	public Shape(Shape shape) {
		string = shape.string;
		color = shape.color;  
		backColor = shape.backColor;
		font = shape.font;
		filled =shape.filled;
		bold = shape.bold;
		textString = shape.textString;
		x1 = shape.x1;
		x2 = shape.x2;
		y1 = shape.y1;
		y2 = shape.y2;
	}
	public String getTextString() {
		return textString;
	}
	public void setTextString(String string) {
		textString = string;
	}
}
