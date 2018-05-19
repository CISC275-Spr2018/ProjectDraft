package view;

import java.awt.MenuBar;

/**
 * Class View
 * @author Team 11 - 8
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.FloatingObjs;

public class View extends JFrame implements Serializable{
	//a JFrame that takes everything thing and present the layers of images 
	Menu menu = new Menu();
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
		this.getContentPane().add(menu);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		eg1 = new FishWorld(new ArrayList<FloatingObjs>());
		tb1 = new ToolBar();
		// bgp=new BackgroundPanel((new ImageIcon("resources/img/background/underwater2.png")).getImage());
        //bgp.setBounds(0,0,1920,1080);     
		this.setTitle("Habatit Mangantment Training Program");
		//this.getContentPane().add(bgp);
		isAdded = false;
		
		//initStage1();
		 //this.getContentPane().add(tb1,"West");
		//this.getContentPane().add(eg1);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(FWIDTH, FHEIGHT);
		//this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);  
		//this.setResizable(false);
		//this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		
		//this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		//this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    	this.setSize(FWIDTH, FHEIGHT);
    	this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		this.pack();
    	this.setVisible(true);
		
	}
	
	public void setMenuBar(ActionListener ac){
		JMenuBar jMB = new JMenuBar();
		JMenuItem menuPage = new JMenuItem("Main Page");
		menuPage.setActionCommand("home");
		JMenuItem menuSave = new JMenuItem("save");
		menuSave.setActionCommand("sava");
		JMenuItem menuLoad = new JMenuItem("load");
		menuLoad.setActionCommand("load");
		jMB.add(menuPage);
		jMB.add(menuSave);
		jMB.add(menuLoad);
		menuPage.addActionListener(ac);
		this.setJMenuBar(jMB);
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
		//System.out.println("added!");
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
	*gameover : call the game over panel
	*@param int i : the score
	*@return void : show the game over panel
	*/
	public void gameover(int i){
		this.getContentPane().removeAll();
		GameOverPane gm = new GameOverPane();
		this.getContentPane().add(gm);
		this.repaint();
		gm.gameover(i);		
	}//gameover
	
	/**
	*gameover : call the game over panel
	*@param int i : the score
	*@return void : show the game over panel
	*/
	public void start(){
		tb1 = new ToolBar();
		menu = new Menu();
		this.getContentPane().removeAll();
		isAdded = false;
		this.getContentPane().add(menu);
		this.repaint();
	}
	/**updateTime : 
	 * @param double d : the update period
	 * @return void : updates the time in timepane
	 * */
	public void updateTime(double d){
		tb1.updateTime(d);
	}//updateTime
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
	
	public static void main(String[] args){
		View v = new View();
	}
	
}
