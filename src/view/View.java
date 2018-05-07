package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.FloatingObjs;
import model.ModelWorld;

public class View extends JFrame{
	
	final int frameCount = 10;
	final static int FWIDTH = 1960;
	final static int FHEIGHT = 1080;
	private FishWorld eg1;
	private ToolBar tb1;
	//private BackgroundPanel bgp;
	
	
	public View() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FWIDTH, FHEIGHT);
		eg1 = new FishWorld(new ArrayList<FloatingObjs>());
		tb1 = new ToolBar();
       // bgp=new BackgroundPanel((new ImageIcon("resources/img/background/underwater2.png")).getImage());
        //bgp.setBounds(0,0,1920,1080);     
		this.setTitle("beta");
		//this.getContentPane().add(bgp);
		this.getContentPane().add(tb1,"West");
		this.getContentPane().add(eg1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FWIDTH, FHEIGHT);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);  
		this.pack();
    	this.setVisible(true);
		
	}
	public void updateView(ArrayList<FloatingObjs> ob1) {
		eg1.updateBtns(ob1);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//this.repaint();
	}
	
	
	public ToolBar getTbar(){
		return tb1;
	}
	
	public FishWorld getFworld(){
		return eg1;
	}
	
	public void setActionListener(ActionListener fBListener, ActionListener tBListener){
		eg1.setActionListener(fBListener);
		tb1.setActionListener(tBListener);
	}
	
}
