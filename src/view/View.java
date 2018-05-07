package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.FloatingObjs;
import model.ModelWorld;

public class View extends JFrame  {
	
	final int frameCount = 10;
	final static int FWIDTH = 1920;
	final static int FHEIGHT = 1080;
	public FishWorld eg1;
	public ToolBar tb1;
	Image bgImg;
	JLabel jlBackgroundimg;
	ImageIcon bgIcon;
	
	public static JPanel GImage = null; 
	 

	 public void initFrame(ArrayList<FloatingObjs> objs) {
		this.getContentPane().setLayout(null); 
        eg1 = new FishWorld(objs);
		tb1 = new ToolBar();
		tb1.setBounds(0,0,260,1080);
		eg1.setBounds(0,0,FWIDTH,FHEIGHT);
		this.add(tb1);
		this.add(eg1);
		
		
		
        this.setTitle("BG test");  
        
        this.pack();  
        this.setSize(FWIDTH,FHEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    }  
	 //
	//JButton click;
	public View(ArrayList<FloatingObjs> objs) {
		initFrame(objs);
	}
	public void updateView(ArrayList<FloatingObjs> ob1) {
		eg1.updateBtns(ob1);
	}
	
	public ToolBar getTbar(){
		return tb1;
	}
	
	
}
