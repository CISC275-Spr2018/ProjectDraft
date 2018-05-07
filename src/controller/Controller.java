package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.FloatingObjs;
import model.InvasiveSpecies;
import model.ModelWorld;
import model.ProtectedSpecies;
import model.Trash;
import view.FishWorld;
import view.Menu;
import view.View;

public class Controller {
	private ModelWorld model;
	private View view;
	private String currentTool;

	public Controller(ArrayList<FloatingObjs> loFloating) {
		model = new ModelWorld(loFloating);
		view = new View();
		stage1(loFloating);	
	}
	public void stage1(ArrayList<FloatingObjs> loFloating) {
		
		view.setActionListener(new FishButtonListener(), new ToolBarListener());
		this.view.updateView(model.getListOfExistedFloatingObjs());
		currentTool = "Invasion";
		view.getFworld().initialBG();
	}
	
	//this function setup model for each game
	public void setupModeles(){}
	
	public void updateController() {
			if(view.getMenu().isStarted()&&(view.isAdded==false)) {//stage 1
				view.initStage1();
			}else {
				System.out.println("wa");
				this.model.updateWorld();
				ArrayList<FloatingObjs> obj = model.getListOfExistedFloatingObjs();
				this.view.updateView(obj);	
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] temp = e.getActionCommand().split(" ");
			int index = Integer.parseInt(temp[1]);
			String spices = temp[0];
			int isPos = (spices.equalsIgnoreCase(currentTool))? 1: -1;
			view.getFworld().removeFloat(index);
			int score = model.findFloat(index).getScore();
			updateScore(score*isPos);
			model.destory(index);
			//System.out.println(spices);
		}
		
	}//FishButtonListener
	
	public class ToolBarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			currentTool = e.getActionCommand();
			System.out.println("the tool is now: " + currentTool);
		}
		
	}//FishButtonListener
	
	
	
	public static void main(String args[]) {
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 800 , 765,55,200,100));
		loFloating.add(new InvasiveSpecies("bluecatFish", 900 , 700,75,45,110));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 400 , 516,50,300,200));
		loFloating.add(new InvasiveSpecies("redswampcrayfish", 1200 , 535,40,30,150));
		loFloating.add(new InvasiveSpecies("snakehead", 1200 , 1035,95,160,60));
		loFloating.add(new Trash("paper", 1267, 635,45,100,100));
		loFloating.add(new ProtectedSpecies("salamander", 1267 , 735,70,350,150));
		loFloating.add(new ProtectedSpecies("Sturgeon", 1435 , 835,85,230,60));
		Controller a = new Controller(loFloating);
		int i = 0;
		while(true){
			a.updateController();	
			//a.updateScore(1);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while
		/*HighScore h1 = new HighScore(a.getScore());
		ArrayList<HighScore> hs = new ArrayList<HighScore>();
		hs.add(h1);
		HighScore.showHighScoreList(hs);
		
		HighScore.writeOut("outSample", hs);
		//HighScore.showHighScoreList(HighScore.readIn("outSample"));*/
	}
	
}