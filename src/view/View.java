package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.FloatingObjs;
import model.ModelWorld;

public class View extends JFrame{
	
	final int frameCount = 10;
	final static int FWIDTH = 1280;
	final static int FHEIGHT = 960;
	FishWorld eg1;
	ToolBar tb1;
//	JFrame frame = new JFrame();
	public View(ArrayList<FloatingObjs> objs) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FWIDTH, FHEIGHT);
		eg1 = new FishWorld(objs);
		tb1 = new ToolBar();
		this.getContentPane().add(tb1,"West");
		this.getContentPane().add(eg1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FWIDTH, FHEIGHT);
    	this.setVisible(true);
		
	}
	public void updateView(ArrayList<FloatingObjs> ob1) {
		eg1.updateBtns(ob1);
		repaint();
	}
	
	
}
