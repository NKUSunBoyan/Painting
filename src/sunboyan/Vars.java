package sunboyan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.IllegalFormatCodePointException;
import java.util.prefs.BackingStoreException;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Vars {

	private static ToolBar toolBar = null;
	private static JComboBox<Color> shapeColorBox = null;
	private static JComboBox<Color> backColorBox = null;
	private static JTextField textField = null;
	private static JButton upButton = null;
	private static JButton downButton = null;
	private static JPanel fontPanel = null;
	private static Color[] colors = {Color.BLACK,Color.blue,Color.CYAN,Color.DARK_GRAY, Color.GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.RED,Color.WHITE,Color.YELLOW};
	private static ColorRender render = null;
	private static TextField fontLabel = null;
	
	private static ShapeBar shapePanel = null;
	private static JToggleButton circleButton = null;
	private static JToggleButton squareButton = null;
	private static JToggleButton textButton = null;
	private static JToggleButton ellipseButton = null;
	private static JToggleButton lineButton = null;
	private static JToggleButton boldButton = null;
	
	private static PaintPanel paintPanel = null;
	private static Color color = Color.BLACK;
	private static Color backColor = Color.white;
	private static Shape shape = null;
	public static Shape [] items = null;
	public static int nums = 0;
	private static String shapeString = "line";
	private static Font font =null;
	
	private static LowPanel lowerPanel =null;
	private static JLabel stateLabel = null;
	private static JCheckBox checkBox  = null;
	public static boolean isFilled = false;
	public static boolean isBold = false;
	
	public static JButton saveButton = null;
	public static JButton undoButton = null;
	
	public static ToolBar getToolPanel() {
		if(toolBar == null) {
			toolBar = new ToolBar();
		}
		return toolBar;
	}
	public static JComboBox<Color> getShapeColorBox() {
		if(shapeColorBox == null) {
			shapeColorBox = new JComboBox<>(getColors());
			shapeColorBox.addItemListener(new ItemListener() {			
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					Vars.color = (Color)shapeColorBox.getSelectedItem();
					shapeColorBox.setBackground(color);
					shapeColorBox.setFocusable(false);
				}
			});
			shapeColorBox.setRenderer(getColorRender());
		}
		return shapeColorBox;
	}
	public static JComboBox<Color> getBackColorBox() {
		if(backColorBox == null) {
			backColorBox = new JComboBox<>(getColors());
			backColorBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					Vars.backColor = (Color)backColorBox.getSelectedItem();
					backColorBox.setBackground(backColor);
					backColorBox.setFocusable(false);
				}
			});
			backColorBox.setRenderer(getColorRender());
		}
		return backColorBox;
	}
	public static ColorRender getColorRender() {
		if(render == null) {
			render = new ColorRender();
			render.setPreferredSize(new Dimension(200,40));
		}
		return render;
	} 
	public static JTextField getTextField() {
		if(textField == null) {
			textField= new JTextField();
			textField.setPreferredSize(new Dimension(200,40));
			textField.setText("Default");
			textField.setFont(new Font("Times New Roman",Font.PLAIN,40));
		}
		return textField;
	}
	public static JButton getUpButton() {
		if(upButton == null) {
			upButton= new JButton();
			upButton.setText("Up");
			upButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					addSize();
					Integer integer = getFont().getSize();
					getFontLabel().setText(integer.toString());
				}
			});
		}
		return upButton;
	}
	public static JButton getDownButton() {
		if(downButton == null) {
			downButton= new JButton();
			downButton.setText("Down");
			downButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					subSize();
					Integer integer = getFont().getSize();
					getFontLabel().setText(integer.toString());
				}
			});
		}
		return downButton;
	}
	public static JPanel getFontPanel() {
		if(fontPanel == null) {
			fontPanel = new JPanel();
			fontPanel.setLayout(new BorderLayout());
			fontPanel.add(getFontLabel(),BorderLayout.CENTER);
			fontPanel.add(getUpButton(),BorderLayout.EAST);
			fontPanel.add(getDownButton(),BorderLayout.WEST);
		}
		return fontPanel;
	}
	public static Color [] getColors() {
		return colors;
	}
	public static TextField getFontLabel() {
		if(fontLabel == null) {
			fontLabel = new TextField();
			fontLabel.setPreferredSize(new Dimension(100,40));
			fontLabel.setEditable(false);
			fontLabel.setFont(new Font("Consolas", Font.PLAIN, 40));
			fontLabel.setText("40");
		}
		return fontLabel;
	}

	public static ShapeBar getShapePanel() {
		if(shapePanel == null) {
			shapePanel = new ShapeBar();
		}
		return shapePanel;
	}
	public static JToggleButton getCircleButton() {
		if(circleButton == null) {
			circleButton= new JToggleButton("圆",false);
			circleButton.setSize(60, 60);
			circleButton.addMouseListener(new MouseAdapter() {			
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
						getSquareButton().setSelected(false);
						getEllipseButton().setSelected(false);
						getTextButton().setSelected(false);
						getLineButton().setSelected(false);
						Vars.setString("circle");
					}

			});
		}
		return circleButton;
	}
	public static JToggleButton getSquareButton() {
		if(squareButton == null) {
			squareButton= new JToggleButton("方",false);
			squareButton.setSize(60,60);
			squareButton.setText("方");
			squareButton.addMouseListener(new MouseAdapter() {			
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub					
						getCircleButton().setSelected(false);
						getEllipseButton().setSelected(false);
						getTextButton().setSelected(false);	
						getLineButton().setSelected(false);
						Vars.setString("square");
				}

			});
		}
		return squareButton;
	}
	public static JToggleButton getEllipseButton() {
		if(ellipseButton == null) {
			ellipseButton= new JToggleButton("椭圆",false);
			ellipseButton.setSize(60,60);
			ellipseButton.addMouseListener(new MouseAdapter() {			
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
						getCircleButton().setSelected(false);
						getSquareButton().setSelected(false);
						getTextButton().setSelected(false);
						getLineButton().setSelected(false);
						Vars.setString("ellipse");
				}

			});
		}
		return ellipseButton;
	}
	public static JToggleButton getTextButton() {
		if(textButton == null) {
			textButton= new JToggleButton("T",false);
			textButton.setSize(60,60);
			textButton.addMouseListener(new MouseAdapter() {			
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
						getCircleButton().setSelected(false);
						getSquareButton().setSelected(false);
						getEllipseButton().setSelected(false);
						getLineButton().setSelected(false);
						Vars.setString("text");
				}

			});
		}
		return textButton;
	}
	public static JToggleButton getLineButton() {
		if(lineButton == null) {
			lineButton = new JToggleButton("\\",false);
			lineButton.setSize(60,60);
			lineButton.addMouseListener(new MouseAdapter() {			
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
						getCircleButton().setSelected(false);
						getSquareButton().setSelected(false);
						getEllipseButton().setSelected(false);
						getTextButton().setSelected(false);
						Vars.setString("line");
				}

			});
		}
		return lineButton;
	}
	public static JToggleButton getBoldButton() {
		if(boldButton==null) {
			boldButton = new JToggleButton("B");
			boldButton.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					isBold = boldButton.isSelected();
					System.out.println(isBold);
				}
			});
		}
		return boldButton;
	}
	public static JButton getUndoButton() {
		if(undoButton == null) {
			undoButton = new JButton("撤销");
			undoButton.setFont(new Font("宋体",Font.PLAIN,30));
			undoButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					subItems();
					paintPanel.repaint();
				}
			});
		}
		return undoButton;
		
	}
	public static JButton getSaveButton() {
		if(saveButton == null) {
			saveButton = new JButton("保存");
			saveButton.setFont(new Font("宋体",Font.PLAIN,30));
			saveButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					getPaintPanel().save();
				}
			});
		}
		return saveButton;
	}
	public static Color getColor() {
		return color;
	}
	public static void setColor(Color c) {
		color = c;
	}
	public static Color getBackColor() {
		return backColor;
	}
	public static void setBackColor(Color c) {
		backColor = c;
	}
	public static Shape getShape() {
		if(shape == null) {
			shape = new Shape();
		}
		return shape;
	}
	public static Shape[] getItems() {
		if(items ==null) {
			items = new Shape[100];
		}
		return items;
	}
	public static int getNums() {
		return nums;
	}
	public static void addItems() {
		items[nums] = new Shape(shape);
		nums++;
	}
	public static void subItems() {
		if(nums>0) {
			items[--nums] = null;
		}
	}
	public static void setString(String string) {
		shapeString = string;
	}
	public static String getString() {
		return shapeString;
	}
	public static PaintPanel getPaintPanel() {
		if(paintPanel == null) {
			paintPanel = new PaintPanel();
		}
		return paintPanel;
	}
	public static Font getFont() {
		if(font==null) {
			font = new Font("Times New Roman", Font.PLAIN, 40);
		}
		return font;
	}
	public static void addSize() {
		if(font==null) {
			font = new Font("Times New Roman", Font.PLAIN, 42);
		}else if(font.getSize()<80){
			font = new Font("Times New Roman",Font.PLAIN,font.getSize()+2);
		}	
	}
	public static void subSize() {
		if(font==null) {
			font = new Font("Times New Roman", Font.PLAIN, 38);
		}else if(font.getSize()>2) {
			font = new Font("Times New Roman",Font.PLAIN,font.getSize()-2);
		}	
	}
	public static  LowPanel getLowPanel() {
		if(lowerPanel ==null) {
			lowerPanel = new LowPanel();
		}
		return lowerPanel;
	}
	public static JLabel getStateLabel() {
		if(stateLabel ==null) {
			stateLabel = new JLabel();
			stateLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
			stateLabel.setText("X:0 , Y:0");
		}
		return stateLabel;
	}
	public static JCheckBox getCheckBox() {
		if (checkBox == null) {
			checkBox = new JCheckBox("填充");
			checkBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					isFilled = checkBox.isSelected();
				}
			} );
		}
		return checkBox;
	}
}
