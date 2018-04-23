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
	private FishWorld W;
	public Controller(ArrayList<FloatingObjs> loFloating) {
		model = new ModelWorld(loFloating);
		view = new View(loFloating);
	}
	public void updateController(ArrayList<FloatingObjs> obj) {
		this.model.move();
		this.view.updateView(obj);
	}
	
	public static void main(String args[]) {
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturle", 4 , 5));
		loFloating.add(new InvasiveSpecies("bass", 4 , 5));
		loFloating.add(new InvasiveSpecies("catFish", 4 , 5));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 5));
		Controller a = new Controller(loFloating);
		while(true){
			a.updateController(loFloating);			
		try {
    		Thread.sleep(100);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
		}		
	}
	
}
