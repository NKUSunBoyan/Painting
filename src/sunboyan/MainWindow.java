package sunboyan;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainWindow() {
		JPanel panel = new JPanel();
		setContentPane(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 720);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(Vars.getToolPanel(), BorderLayout.NORTH);
		getContentPane().add(Vars.getShapePanel(),BorderLayout.WEST);
		getContentPane().add(Vars.getPaintPanel(),BorderLayout.CENTER);
		getContentPane().add(Vars.getLowPanel(),BorderLayout.SOUTH);
	}
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
		Vars.getPaintPanel().paintComponent(g);
	}
}
