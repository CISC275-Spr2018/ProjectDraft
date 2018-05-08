package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ModelWorld implements Serializable{
	private ArrayList<FloatingObjs> lof;//list of floatingObjs that will spam
	private ArrayList<FloatingObjs> loEf;//list of existed floatingObjs
	private int score;
	private int time=0;
	
	/**
	 * 
	 * @param l
	 */
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
	/**
	 * 
	 */
	public void updateWorld(){
		for(FloatingObjs f : loEf){
			f.move();
			f.updateDuration();
			
		}
		
		if(loEf.size()<5){//make sure there is always more than 5 objs on the screen
			this.spawn();
		}
		
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<FloatingObjs> getListOfExistedFloatingObjs(){
		return loEf;
	}
	/**
	 * 
	 */
	public String toString(){
		String str = "";
		for(FloatingObjs f : loEf){
			str += f.toString() + ", \r\n";
		}
		return str;
	}
	/**
	 * 
	 */
	public void move(){
		for(FloatingObjs f : loEf){
			f.move();
			if(f.getDuration()<=0) {
				//
				System.out.println("sth escaped!");
			};
		}
		
	}
	/**
	 * 
	 * @param s
	 */
	public void updateScore(int s){
		score += s;
	}
	/**
	 * 
	 */
	public void updateTime(){
		time++;
	}
	/**
	 * 
	 * @return
	 */
	public int getScore(){
		return score;
	}
	/**
	 * 
	 * @return
	 */
	public int getTime(){
		return time;
	}
	/**
	 * 
	 * @param i
	 */
	public void destory(int i){
		FloatingObjs f = findFloat(i);
		loEf.remove(f);
	}
	/**
	 * 
	 * @param i
	 * @return
	 */
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
	/**
	 * 
	 */
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
//serializable code:
		/*	try{
			FileOutputStream fileOut = new FileOutputStream("/tmp/world.ser");
			ObjectOutputStream out= new ObjectOutputStream(fileOut);
			out.writeObject(world);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/world.ser");
		}
		catch(IOException i){
			i.printStackTrace();
		}*/
		
		world.destory(1);
		world.destory(2);
		System.out.println(world);
	}//main

}