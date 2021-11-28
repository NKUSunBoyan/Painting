package sunboyan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.Math;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class PaintPanel extends JPanel implements MouseListener,MouseMotionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x1 = e.getX();
		int y1 = e.getY();
		Vars.getShape().setX1(x1);
		Vars.getShape().setY1(y1);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x2 = e.getX();
		int y2 = e.getY();
		Vars.getShape().setX2(x2);
		Vars.getShape().setY2(y2);
		Vars.getShape().setColor();
		Vars.getShape().setString();
		Vars.getShape().setFont(Vars.getFont());
		Vars.getShape().setBackColor(Vars.getBackColor());
		Vars.getShape().setTextString(Vars.getTextField().getText());
		Vars.getShape().filled = Vars.isFilled;
		Vars.getShape().bold = Vars.isBold;
		Vars.addItems();
		paintComponent(getGraphics());
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Vars.getStateLabel().setText("X:0 , Y:0");
	}
	
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Vars.getStateLabel().setText("X:"+e.getX()+" , Y:"+e.getY());
	}

	public PaintPanel() {
		setBackground(Color.white);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			g.drawImage(ImageIO.read(new File("D:\\Coding projects\\eclipse-workspace\\Painting\\cache\\autosave.jpg")), 0, 0, Color.WHITE, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			;
		}
		setBackground(Vars.getBackColor());
		Shape[] shapes = Vars.getItems();
		if(shapes == null) {
			return;
		}
		for (Shape shape : shapes) {
			draw((Graphics2D)g, shape);
		}
		if(Vars.nums>10) {
			clear();
		}
	}
	public void clear() {
		Vars.nums = 0;
		autoSave();
		Vars.items = new Shape[100];	
	}
	
	public void draw(Graphics2D g, Shape shape) {
		if(shape ==null) {
			return;
		}
		switch (shape.getString()) {
		case "circle":
			g.setColor(shape.getColor());
			if(shape.bold) {
				g.setStroke(new BasicStroke(10));
			}else {
				g.setStroke(new BasicStroke(3));
			}
			g.drawOval(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getX1()-shape.getX2()));
			if (shape.filled) {
				g.setColor(shape.getBackColor());
				g.fillOval(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getX1()-shape.getX2()));

			}else {

			}
			break;
		case "square":
			g.setColor(shape.getColor());
			if(shape.bold) {
				g.setStroke(new BasicStroke(10));
			}else {
				g.setStroke(new BasicStroke(3));
			}
			g.drawRect(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getY1()-shape.getY2()));
			if (shape.filled) {
				g.setColor(shape.getBackColor());
				g.fillRect(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getY1()-shape.getY2()));

			}else {

			}
			break;
		case "ellipse":
			g.setColor(shape.getColor());
			if(shape.bold) {
				g.setStroke(new BasicStroke(10));
			}else {
				g.setStroke(new BasicStroke(3));
			}
			g.drawOval(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getY1()-shape.getY2()));
			if (shape.filled) {
				g.setColor(shape.getBackColor());
				g.fillOval(Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()), Math.abs(shape.getX1()-shape.getX2()), Math.abs(shape.getY1()-shape.getY2()));

			}else {
			}
			break;			
		case "text":
			g.setColor(shape.getColor());
			if(shape.bold) {
				Font font = shape.getFont().deriveFont(Font.BOLD);
				g.setFont(font);
			}else {
				g.setFont(shape.getFont());
			}
			g.drawString(shape.getTextString(),Math.min(shape.getX1(), shape.getX2()), Math.min(shape.getY1(), shape.getY2()));
			break;
		case "line":
			g.setColor(shape.getColor());
			if(shape.bold) {
				g.setStroke(new BasicStroke(10));
			}else {
				g.setStroke(new BasicStroke(3));
			}
			g.drawLine(shape.getX1(), shape.getY1(), shape.getX2(), shape.getY2());
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void save() {
		BufferedImage image  = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)image.getGraphics();
		paint(g);
		JFileChooser chooser=new JFileChooser();//文件保存对话框
		chooser.setCurrentDirectory(new File("."));
		if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
			File oFile=chooser.getSelectedFile();
			try{
				 File file = new File(oFile.getName()+".jpg");
				ImageIO.write(image, "jpg", file);//保存图像文件
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
	public void autoSave() {
		BufferedImage image  = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)image.getGraphics();
		paint(g);
		try {
			File cacheFile = new File("D:\\Coding projects\\eclipse-workspace\\Painting\\cache\\autosave.jpg");
			ImageIO.write(image, "jpg", cacheFile);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
