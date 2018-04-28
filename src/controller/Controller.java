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

public class Controller  implements ActionListener{
	private ModelWorld model;
	private View view;
	public Controller(ArrayList<FloatingObjs> loFloating) {
		model = new ModelWorld(loFloating);
		view = new View(loFloating);
		//view.eg1.
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
		loFloating.add(new InvasiveSpecies("redswampcrayfish", 200 , 335));
		loFloating.add(new InvasiveSpecies("snakehead", 300 , 235));
		loFloating.add(new InvasiveSpecies("snakehead", 200 , 135));
		loFloating.add(new InvasiveSpecies("paper", 267 , 235));
		loFloating.add(new ProtectedSpecies("salamander", 267 , 235));
		loFloating.add(new ProtectedSpecies("Sturgeon", 435 , 135));
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
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		System.out.println("aaaaa");
		
	}
	
}
