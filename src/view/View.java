package view;

/**
 * Class View
 * @author Team 11 - 8
 * */

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
	//a JFrame that takes everything thing and present the layers of images 
	Menu menu;
	final int frameCount = 10;
	final static int FWIDTH = 1960;
	final static int FHEIGHT = 1080;
	
	
	private FishWorld eg1;
	private ToolBar tb1;
	
	//private BackgroundPanel bgp;
	public boolean isAdded;
	
	/**
	*View : a constructor of View
	*@param void: nothing
	*@return View : Construct a new View
	*/
	public View() {
		menu= new Menu();
		add(menu);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		eg1 = new FishWorld(new ArrayList<FloatingObjs>());
		tb1 = new ToolBar();
		// bgp=new BackgroundPanel((new ImageIcon("resources/img/background/underwater2.png")).getImage());
        //bgp.setBounds(0,0,1920,1080);     
		this.setTitle("beta");
		//this.getContentPane().add(bgp);
		isAdded = false;
		
		//initStage1();
		 //this.getContentPane().add(tb1,"West");
		//this.getContentPane().add(eg1);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(FWIDTH, FHEIGHT);
		//this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);  
		//this.setResizable(false);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		//this.setSize(FWIDTH, FHEIGHT);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		this.pack();
    	this.setVisible(true);
    	this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    	
		
	}
	
	/**
	*getMenu : a getter function of View
	*@param void : nothing
	*@return Menu : the menu of this View
	*/
	public Menu getMenu() {
		return menu;
	}
	
	/**
	*startMusic : a setter function of View
	*@param void : nothing
	*@return void : starts the play of BGM
	*/
	public void startMusic(){
		tb1.getSb().startMusic();
	}
	
	/**
	*stopMusic : a setter function of View
	*@param void : nothing
	*@return void : stops the play of BGM
	*/
	public void stopMusic(){
		tb1.getSb().stopMusic();
	}
	
	/**
	*getSb : a getter function of View
	*@param void : nothing
	*@return SoundBar : the SoundBar of this View
	*/
	public SoundBar getSb(){
		return tb1.getSb();
	}
	
	/**
	*initStage1 : initialize stage1
	*@param void : nothing
	*@return void : initialize the stage1 of this View
	*/
	public void initStage1() {
		System.out.println("added!");
		this.getFworld().initialBG();
		this.getContentPane().add(tb1,"West");
		this.getContentPane().add(eg1);
		isAdded=true;						
	}
	
	/**
	*updateView :updates components in View
	*@param ArrayList<FloatingObjs> ob1 : a given ArrayList<FloatingObjs>
	*@return void : this function moves the fishBtns in eg1(FishWorld panel)
	*/
	public void updateView(ArrayList<FloatingObjs> ob1) {
		
		eg1.updateBtns(ob1);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//this.repaint();
	}
	
	/**
	*getTbar : a getter function of View
	*@param void : nothing
	*@return ToolBar : the tb1(Toolbar panel) of this View
	*/
	public ToolBar getTbar(){
		return tb1;
	}
	
	/**
	*getFworld : a getter function of View
	*@param void : nothing
	*@return FishWorld : the eg1(FishWorld panel) of this View
	*/
	public FishWorld getFworld(){
		return eg1;
	}
	/**
	*setActionListener : setup ActionListner
	*@param ActionListener fBListener : a given FishBtn ActionListener
	*@param ActionListener tBListener : a given toolBar ActionListener
	*@return void : give eg1(FishWorld panel) fBListener; 
	*				give tb1(Toolbar panel) tBListener
	*/
	public void setActionListener(ActionListener fBListener, ActionListener tBListener, ActionListener sBListener){
		eg1.setActionListener(fBListener);
		tb1.setActionListener(tBListener, sBListener);
	}
	
	
}
