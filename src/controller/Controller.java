package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.FloatingObjs;
import model.InvasiveSpecies;
import model.ModelWorld;
import model.ProtectedSpecies;
import view.FishWorld;
import view.View;

public class Controller {
	private ModelWorld model;
	private View view;
	private String currentTool;
	
	public Controller(ArrayList<FloatingObjs> loFloating) {
		model = new ModelWorld(loFloating);
		view = new View(model.getListOfExistedFloatingObjs());
		currentTool = "Invasion";
	}
	
	public void setupModeles(){}
	public void updateController(ArrayList<FloatingObjs> obj) {
		this.model.updateWorld();
		this.view.updateView(obj);		
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
		}
		
	}//FishButtonListener
	
	public class ToolBarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			currentTool = e.getActionCommand();
		}
		
	}//FishButtonListener
	
	
	
	public static void main(String args[]) {
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 400 , 5));
		loFloating.add(new InvasiveSpecies("bass", 4 , 500));
		loFloating.add(new InvasiveSpecies("catFish", 400 , 500));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 5));
		Controller a = new Controller(loFloating);
		int i = 0;
		while(i++ < 30){
			a.updateController(loFloating);	
			a.updateScore(1);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while
		HighScore h1 = new HighScore(a.getScore());
		ArrayList<HighScore> hs = new ArrayList<HighScore>();
		hs.add(h1);
		HighScore.showHighScoreList(hs);
		
		HighScore.writeOut("outSample", hs);
		//HighScore.showHighScoreList(HighScore.readIn("outSample"));
	}
	
}
