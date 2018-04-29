package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModelWorld {
	private ArrayList<FloatingObjs> lof;//list of floatingObjs that will spam
	private ArrayList<FloatingObjs> loEf;//list of existed floatingObjs
	private int score;
	
	public ModelWorld(ArrayList<FloatingObjs> l){
		this.lof = l;
		this.loEf = new ArrayList<FloatingObjs>();
		this.spawn();
		this.spawn();
		this.spawn();
		this.spawn();
		this.spawn();
		this.spawn();
	}//constructor
	
	public void updateWorld(){
		for(FloatingObjs f : loEf){
			f.move();
			f.updateDuration();
			if(f.getDuration() <= 0){
				this.destory(f);
			}
		}
	}
	
	public ArrayList<FloatingObjs> getListOfExistedFloatingObjs(){
		return loEf;
	}
	
	public String toString(){
		String str = "";
		for(FloatingObjs f : lof){
			str += f.toString() + ", \r\n";
		}
		return str;
	}
	
	public void move(){
		for(FloatingObjs f : loEf){
			f.move();
		}
	}
	
	public void updateScore(int s){
		score += s;
	}
	
	public int getScore(){
		return score;
	}
	
	public void destory(FloatingObjs f){
		loEf.remove(f);
	}
	
	public void spawn(){
		int len = lof.size();
		int i = (int) (Math.random() * len);
		FloatingObjs temp = lof.get(i);
		loEf.add(temp);
		i = loEf.indexOf(temp);
		temp.addIndexId(i);
	}

	public static void main(String[] args){
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 4 , 5));
		loFloating.add(new InvasiveSpecies("bass", 4 , 5));
		loFloating.add(new InvasiveSpecies("catFish", 4 , 5));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 5));
		
		ModelWorld world = new ModelWorld(loFloating);
		
		System.out.println(world);
	}//main

}
