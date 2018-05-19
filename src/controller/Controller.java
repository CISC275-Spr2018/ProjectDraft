package controller;
/**
 * Class Controller
 * @author Team 11 - 8
 * */

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import model.FloatingObjs;
import model.InvasiveSpecies;
import model.ModelWorld;
import model.ProtectedSpecies;
import model.Trash;
import view.SoundBar;

import view.View;

public class Controller implements Runnable, Serializable { // controller class runs the game 
	private static final long serialVersionUID = 1L;
	private ModelWorld model;
	private View view;
	private String currentTool;
	private ArrayList<FloatingObjs> lof;
	private Action act1 = new Act1();
	private int delay = 1;//in ms
	private Timer t = new Timer(delay, act1);
	

	public boolean soundFlag = true;
	public boolean bgmFlag = true;

	
	/**
	*Controller : a constructor of Controller
	*@param ArrayList<FloatingObjs> loFloating: the ArrayList of FloatingObjs
	*@return Controller : Construct a new Controller
	*/
	public Controller(ArrayList<FloatingObjs> loFloating) {
		lof = loFloating;
		model = new ModelWorld(lof);
		view = new View();
		view.setActionListener(new FishButtonListener(), new ToolBarListener(), new SoundBarListener());
		this.view.updateView(model.getListOfExistedFloatingObjs());
		currentTool = "Invasive";
		view.getFworld().initialBG();
		view.startMusic();
		view.setMenuBar(new MenuActionListener());
	}
	
	/**
	*getact : a getter function of controller
	*@param void : nothing
	*@return Action : property act1 of controller
	*/
	public Action getact() {
		return act1;
	}
	
	//this function setup model for each game
	public void setupModeles(){}
	
	/**
	*updateController : this function updates the controller
	*@param void : nothing
	*@return void : it returns nothing but updates the status of controller
	*/
	public void updateController() {
			if(view.getMenu().isStarted()&&(view.isAdded==false)) {//stage 1
				view.initStage1();		
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				view.revalidate();
				view.setVisible(true);
			}else if(view.isAdded){
				//System.out.println("wa");
				this.model.updateWorld();
				ArrayList<FloatingObjs> obj = model.getListOfExistedFloatingObjs();
				this.view.updateView(obj);	
			}
			this.updateTime();
	}
	
	/**
	*updateScore : this function updates the score in both model and view
	*@param void : nothing
	*@return void : it returns nothing but updates the score in both model and view
	*/
	public void updateScore(int i){
		model.updateScore(i);
		this.view.getTbar().updateScore(model.getScore());

	}
	
	/**
	*getScore : a getter function of controller
	*@param void : nothing
	*@return int : get the score from model
	*/
	public int getScore(){
		return model.getScore();
	}
	
	/**
	*updateTime : this function updates the time in both model and view
	*@param void : nothing
	*@return void : it returns nothing but updates the time in both model and view
	*/
	public void updateTime(){
		if(view.isAdded){
		model.updateTime(delay);
		view.updateTime(getTimeRate());
		if(getTimeRate() <= 0.0){
			t.stop();
			view.gameover(getScore());
			System.out.println("GameOver");
		}}
	}
	
	/**
	*getTimeRate : a getter function of controller
	*@param void : nothing
	*@return int : get the time from model
	*/
	public double getTimeRate(){
		return model.getTimeRate();
	}

	public class FishButtonListener implements ActionListener, Serializable{ 
		//for each Animal button, listener will
		//apply action towards their ID and count score

		/**
		*actionPerformed : an overrided function in ActionListener
		*@param ActionEvent e : where the action occurs 
		*@return void : perform action when fishbtn is clicked
		*/
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] temp = e.getActionCommand().split(" ");
			int index = Integer.parseInt(temp[1]);
			String spices = temp[0];
			int isPos = (spices.equalsIgnoreCase(currentTool))? 1: -1;

			if(soundFlag){
				SoundBar.beep(isPos);
			}

			view.getFworld().removeFloat(index);
			int score = model.findFloat(index).getScore();
			updateScore(score*isPos);
			model.destory(index);
			//System.out.println(spices);
		}
		
	}//FishButtonListener
	
	/**
	 * load : read the string and go back to certain stage
	 * @param String str : the serialization String 
	 * @return void : update the Controller
	 * */
	public void load(String str){
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(str));
			Object c = in.readObject();    
			model = (ModelWorld) c;
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//load
	
	/**
	 * save : read the Controller and save it to String
	 * @param void : nothing 
	 * @return String : the saved String
	 * */
	public void save(String str){
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(str));
	        out.writeObject(model);
	        out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//load
	



	public class ToolBarListener implements ActionListener, Serializable{
		//using radio button to change tools 
		private Cursor invasive;
		private Cursor protect;
		private Cursor litter;
		
		/**
		*ToolBarListener : a constructor of ToolBarListener
		*@param void : nothing
		*@return ToolBarListener : Construct a new ToolBarListener
		*							setup 3 Cursors
		*/
		public ToolBarListener(){
			super();
			Toolkit tk = Toolkit.getDefaultToolkit();
			Image Absorb = new ImageIcon("resources/img/tool/Absorb.png").getImage(); 
			Image invaImage = new ImageIcon("resources/img/tool/net.png").getImage(); 
			Image proImage = new ImageIcon("resources/img/tool/camera.png").getImage(); 
			Image litImage = new ImageIcon("resources/img/tool/trashpicker.png").getImage(); 
			Cursor AbsorbC = tk.createCustomCursor(Absorb, new Point(10, 10), "invasive");
			invasive = tk.createCustomCursor(invaImage, new Point(10, 10), "invasive");
			protect = tk.createCustomCursor(proImage, new Point(10, 10), "protected");
			litter = tk.createCustomCursor(litImage, new Point(10, 10), "litter");
			view.setCursor(AbsorbC);
		}

		/**
		*actionPerformed : an overrided function in ActionListener
		*@param ActionEvent e : where the action occurs 
		*@return void : perform action when toolbtn is clicked and update the currentTool
		*/
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			currentTool = e.getActionCommand();
			System.out.println("the tool is now: " + currentTool);
			switch(currentTool){
			case "Invasive": view.setCursor(invasive);break;
			case "Protected": view.setCursor(protect);break;
			case "Litter": view.setCursor(litter);break;
			default:break;
			}
		}
		
	}//FishButtonListener
	
	public class Act1 extends AbstractAction implements Serializable{

		/**
		*actionPerformed : an override function in ActionListener
		*@param ActionEvent e : where the action occurs 
		*@return void : perform action while loop
		*/
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			updateController();
		}}
	

	public class SoundBarListener implements ActionListener, Serializable{
		
		/**
		*actionPerformed : an overrided function in ActionListener
		*@param ActionEvent e : where the action occurs 
		*@return void : perform action when soundBtn is clicked and update the currentTool
		*/
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = e.getActionCommand();
			System.out.println(str);
			String[] ss = str.split(" ");
			String ss0 = ss[0];
			String ss1 = ss[1].equalsIgnoreCase("on")? "off": "on";
			boolean ssb = ss1.equalsIgnoreCase("on")? true: false;

			if(ss0.equalsIgnoreCase("BGM")){
				if(bgmFlag){
					view.stopMusic();
				}else{
					view.startMusic();
				}//inner if-else, either stop or play
				bgmFlag = ssb;
			}else{
				soundFlag = ssb;
			}//outter if-else, either sound or bgm
			view.getSb().setIcons(soundFlag, bgmFlag);
			((JRadioButton)e.getSource()).setActionCommand(ss0 + " " + ss1);
		}//SoundBarListener
	}//SoundBarListener
	
	public class MenuActionListener implements ActionListener, Serializable{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()){
			case "home" : load("resources/text/start.txt");break;
			case "save" : save("resources/text/save.txt");break;
			case "load" : load("resources/text/save.txt");break;
			}
		}
		
	}//MenuActionListener
		
	
	/**
	 * run : implempent function in Runnable
	 * @param void : it consumes nothing
	 * @return void : repeatly run
	*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		t.start();
	}//run
	
	public static void main(String args[]) {
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 800 , 765,5,200,100));
		loFloating.add(new InvasiveSpecies("bluecatFish", 900 , 700,8,45,110));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 400 , 516,10,300,200));
		loFloating.add(new InvasiveSpecies("redswampcrayfish", 1200 , 535,18,30,150));
		loFloating.add(new InvasiveSpecies("snakehead", 1200 , 1035,11,75,60));
		loFloating.add(new Trash("paper", 1267, 635,12,100,100));
		loFloating.add(new ProtectedSpecies("salamander", 1267 , 735,17,350,150));
		loFloating.add(new ProtectedSpecies("Sturgeon", 1435 , 835,13,230,60));
	
		Controller a = new Controller(loFloating);
		a.save("resources/text/start.txt");
		a.run();
	}
	
}