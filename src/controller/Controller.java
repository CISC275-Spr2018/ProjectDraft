package controller;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import model.FloatingObjs;
import model.InvasiveSpecies;
import model.ModelWorld;
import model.ProtectedSpecies;
import model.Trash;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import view.FishWorld;

import view.Menu;

import view.SoundBar;

import view.View;

public class Controller { // controller class runs the game 
	private ModelWorld model;
	private View view;
	private String currentTool;
	public Action act1;
	public boolean isEnded =false;
    
	public Controller(ArrayList<FloatingObjs> loFloating) {
		//-----
	/**	progressBar = new JProgressBar(JProgressBar.VERTICAL, 0, 10);
        progressBar.setValue(10);
        ActionListener listener = new ActionListener() {
            int counter = 10;
            public void actionPerformed(ActionEvent ae) {
                counter--;
                progressBar.setValue(counter);
                if (counter<1) {
                    JOptionPane.showMessageDialog(null, "Kaboom!");
                    timer.stop();
                } 
            }}**/
        //---
		act1 = new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(model.getCountDown()>=0) {
					updateController();
				}
				else {
					System.out.println("GameOVer");
				}
				
			}
		};
		model = new ModelWorld(loFloating);
		view = new View();
		view.setActionListener(new FishButtonListener(), new ToolBarListener());
		this.view.updateView(model.getListOfExistedFloatingObjs());
		currentTool = "Invasion";
		view.getFworld().initialBG();
		SoundBar.music();
		stage1(loFloating);
		view.Poptutorial();
	}
	public Action getact() {
		return act1;
	}
	public void stage1(ArrayList<FloatingObjs> loFloating) {

	}
	
	//this function setup model for each game
	public void setupModeles(){}
	
	public void updateController() {
			if(view.getMenu().isStarted()&&(view.isAdded==false)) {//stage 1
				view.initStage1();
				view.getTbar().getTimer().start();
			}else if(view.isAdded){
				//System.out.println("wa");
				this.model.updateWorld();
				ArrayList<FloatingObjs> obj = model.getListOfExistedFloatingObjs();
				this.view.updateView(obj);	
			}
			
			if((view.getTbar().getPbar().getValue()<=0)&&(isEnded==false)) {
				//pop up game over
				view.PopGameOver(model.getScore());
				isEnded=true;
				//view.getTbar().getTimer().stop();
				
			}
			
	}
	
	public void updateScore(int i){
		model.updateScore(i);
		this.view.getTbar().updateScore(model.getScore());

	}
	
	public int getScore(){
		return model.getScore();
	}
	

	public class FishButtonListener implements ActionListener{ 
		//for each Animal button, listener will
		//apply action towards their ID and count score

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] temp = e.getActionCommand().split(" ");
			int index = Integer.parseInt(temp[1]);
			String spices = temp[0];
			int isPos = (spices.equalsIgnoreCase(currentTool))? 1: -1;

			beep(isPos);

			view.getFworld().removeFloat(index);
			int score = model.findFloat(index).getScore();
			updateScore(score*isPos);
			model.destory(index);
			//System.out.println(spices);
		}
		
	}//FishButtonListener
	


	private void beep(int i){
		String input = (i==1)? "correct" : "wrong";
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;

        try{
            InputStream test = new FileInputStream("resources//music//" + input + ".wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
    }
	

	public class ToolBarListener implements ActionListener{
		//using radio button to change tools 

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			currentTool = e.getActionCommand();
			System.out.println("the tool is now: " + currentTool);
		}
		
	}//FishButtonListener
	/**
	public void Poptutorial() {
		BufferedImage bufferedImage = null;
    	try{
	    	bufferedImage = ImageIO.read(new File("resources/img/background/Intro11.png"));
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
    	ImageIcon icon = new ImageIcon(bufferedImage);
    	JOptionPane.showConfirmDialog(null, "", "Introduction", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
    	
	}
	public void PopGameOver() {
		BufferedImage bufferedImage = null;
    	try{
	    	bufferedImage = ImageIO.read(new File("resources/img/background/Intro11.png"));
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
    	ImageIcon icon = new ImageIcon(bufferedImage);
    	JOptionPane.showConfirmDialog(null, "", "Introduction", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	**/
	public static void main(String args[]) {
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 800 , 765,15,200,100));
		loFloating.add(new InvasiveSpecies("bluecatFish", 900 , 700,18,45,110));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 400 , 516,14,300,200));
		loFloating.add(new InvasiveSpecies("redswampcrayfish", 1200 , 535,18,30,150));
		loFloating.add(new InvasiveSpecies("snakehead", 1200 , 1035,11,75,60));
		loFloating.add(new Trash("paper", 1267, 635,12,100,100));
		loFloating.add(new ProtectedSpecies("salamander", 1267 , 735,21,350,150));
		loFloating.add(new ProtectedSpecies("Sturgeon", 1435 , 835,18,230,60));
		Controller a = new Controller(loFloating);
		Timer t = new Timer(1,a.getact());
		t.start();
		
	
		
		/**
		while(true){
			a.updateController();	
			//a.updateScore(1);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while**/
		/*HighScore h1 = new HighScore(a.getScore());
		ArrayList<HighScore> hs = new ArrayList<HighScore>();
		hs.add(h1);
		HighScore.showHighScoreList(hs);
		
		HighScore.writeOut("outSample", hs);
		//HighScore.showHighScoreList(HighScore.readIn("outSample"));*/
	}
	
}