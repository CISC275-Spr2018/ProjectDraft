package controller;

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
	public Controller(ArrayList<FloatingObjs> loFloating) {
		model = new ModelWorld(loFloating);
		view = new View(loFloating);
	}
	public void updateController(ArrayList<FloatingObjs> obj) {
		this.model.move();
		this.view.updateView(obj);
		this.view.getTbar().updateScore(model.getScore());
	}
	
	public void updateScore(int i){
		model.updateScore(i);
	}
	
	public static void main(String args[]) {
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 400 , 5));
		loFloating.add(new InvasiveSpecies("bass", 4 , 500));
		loFloating.add(new InvasiveSpecies("catFish", 400 , 500));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 5));
		Controller a = new Controller(loFloating);
		while(true){
			a.updateController(loFloating);	
			a.updateScore(1);
		try {
    		Thread.sleep(100);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
		}		
	}
	
}
