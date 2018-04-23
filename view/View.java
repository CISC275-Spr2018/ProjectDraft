package view;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.FloatingObjs;
import model.ModelWorld;

public class View extends JFrame{
	final int frameCount = 10;
	final static int FWIDTH = 800;
	final static int FHEIGHT = 800;
	FishWorld eg1;
	JFrame frame = new JFrame();
	public View(ArrayList<FloatingObjs> objs) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FWIDTH, FHEIGHT);
		eg1 = new FishWorld(objs);
		frame.getContentPane().add(eg1);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FWIDTH, FHEIGHT);
    	frame.setVisible(true);
		
	}
	public void updateView(ArrayList<FloatingObjs> ob1) {
		eg1.updateBtns(ob1);
		frame.repaint();
	}
	
	
}
