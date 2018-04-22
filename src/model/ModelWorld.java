package model;

import java.util.ArrayList;

public class ModelWorld {
	private ArrayList<FloatingObjs> lof;
	
	public ModelWorld(ArrayList<FloatingObjs> l){
		this.lof = l;
	}//constructor
	
	public void updateWorld(){
		for(FloatingObjs f : lof){
			f.move();
		}
	}
	
	public String toString(){
		String str = "";
		for(FloatingObjs f : lof){
			str += f.toString() + ", \r\n";
		}
		return str;
	}
	
	public void destory(){}
	
	public void spawn(){}

	public static void main(String[] args){
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogtoturle", 4 , 5));
		loFloating.add(new InvasiveSpecies("bass", 4 , 5));
		loFloating.add(new InvasiveSpecies("cafFish", 4 , 5));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 5));
		
		ModelWorld world = new ModelWorld(loFloating);
		
		System.out.println(world);
	}//main

}
