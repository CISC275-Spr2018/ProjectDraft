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
		loFloating.add(new ProtectedSpecies("bogturtle", 800 , 765));
		loFloating.add(new InvasiveSpecies("bluecatFish", 900 , 700));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 400 , 516));
		loFloating.add(new InvasiveSpecies("redswampcrayfish", 1200 , 535));
		loFloating.add(new InvasiveSpecies("snakehead", 1300 , 935));
		loFloating.add(new InvasiveSpecies("snakehead", 1200 , 1035));
		loFloating.add(new InvasiveSpecies("paper", 1267 , 635));
		loFloating.add(new ProtectedSpecies("salamander", 1267 , 735));
		loFloating.add(new ProtectedSpecies("Sturgeon", 1435 , 835));
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
