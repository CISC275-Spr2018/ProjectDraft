package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModelWorld {
	//the class handles all data and object we imported
	//takes a list of animals and update their status
	
	private ArrayList<FloatingObjs> lof;//list of floatingObjs that will spam
	private ArrayList<FloatingObjs> loEf;//list of existed floatingObjs
	private int score;
	private int countdown;
	
	public ModelWorld(ArrayList<FloatingObjs> l){
		this.countdown=2000;
		this.lof = l;
		this.loEf = new ArrayList<FloatingObjs>();
		this.spawn();
		this.spawn();
		this.spawn();
		this.spawn();
		this.spawn();
		this.spawn();
	}//constructor
	public int getCountDown() {
		return countdown;
	}
	
	public void updateWorld(){
		countdown--;
		//System.out.println("time left is :"+countdown);
		for(FloatingObjs f : loEf){
			f.move();
			f.updateDuration();
			
		}
		
		if(loEf.size()<5){//make sure there is always more than 5 objs on the screen
			this.spawn();
		}
		
	}
	
	public ArrayList<FloatingObjs> getListOfExistedFloatingObjs(){
		return loEf;
	}
	
	public String toString(){
		String str = "";
		for(FloatingObjs f : loEf){
			str += f.toString() + ", \r\n";
		}
		return str;
	}
	
	public void move(){
		for(FloatingObjs f : loEf){
			f.move();
			if(f.getDuration()<=0) {
				//
				System.out.println("sth escaped!");
			};
		}
		
	}
	
	public void updateScore(int s){
		score += s;
	}
	
	public int getScore(){
		return score;
	}
	
	public void destory(int i){
		FloatingObjs f = findFloat(i);
		loEf.remove(f);
	}
	
	public FloatingObjs findFloat(int i){
		FloatingObjs result = null;
		for(FloatingObjs f: loEf){
			String[] ss = f.getId().split(" ");
			int j = (ss.length > 1)? Integer.parseInt(ss[1]):-1;
			if(i == j){
				result = f;
				break;
			}//if
		}//for
		return result;
	}
	
	public void spawn(){
		int len = lof.size();
		int i = (int) (Math.random() * len);
		FloatingObjs temp = lof.get(i);
		String s = temp.getId();
		FloatingObjs f;
		switch(s){
		case "Litter": f = new Trash(temp); break;
		case "Invasion": f = new InvasiveSpecies(temp); break;
		case "Protected":  f = new ProtectedSpecies(temp); break;
		default: f = new ProtectedSpecies(temp); break;
		}
		loEf.add(f);
		i = loEf.indexOf(f);
		f.addIndexId(i);
	}

	public static void main(String[] args){
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 4 , 5));
		loFloating.add(new InvasiveSpecies("bass", 4 , 5));
		loFloating.add(new InvasiveSpecies("catFish", 4 , 5));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 5));
		ModelWorld world = new ModelWorld(loFloating);
		System.out.println(world);
		
		world.destory(1);
		world.destory(2);
		System.out.println(world);
	}//main

}