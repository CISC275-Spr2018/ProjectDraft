package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.FloatingObjs;
import model.ModelWorld;

public class View extends JFrame {
	
	final int frameCount = 10;
	final static int FWIDTH = 1280;
	final static int FHEIGHT = 960;
	public FishWorld eg1;
	public ToolBar tb1;
	
	//JButton click;
	public View(ArrayList<FloatingObjs> objs) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FWIDTH, FHEIGHT);
		eg1 = new FishWorld(objs);
		tb1 = new ToolBar();
		this.getContentPane().add(tb1,"West");
		this.getContentPane().add(eg1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FWIDTH, FHEIGHT);
		//this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);  
    	this.setVisible(true);
    	
		
	}
	public void updateView(ArrayList<FloatingObjs> ob1) {
		eg1.updateBtns(ob1);
	}
	
	public ToolBar getTbar(){
		return tb1;
	}
	
	
}
