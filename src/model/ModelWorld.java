package model;

/**
 * Class ModelWorld
 * @author Team 11 - 8
 * */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModelWorld {
	//the class handles all data and object we imported
	//takes a list of animals and update their status
	
	private ArrayList<FloatingObjs> lof;//list of floatingObjs that will spam
	private ArrayList<FloatingObjs> loEf;//list of existed floatingObjs
	private int score;

	private int countdown;
	private int spawnNum=0;

	
	/**
	*ModelWorld : a constructor of ModelWorld
	*@param ArrayList<FloatingObjs> l: a given ArrayList<FloatingObjs>
	*@return ModelWorld : constuct a new ModelWorld
	*/

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
		this.spawn();
		this.spawn();
		this.spawn();
		this.spawn();
	}//constructor
	public int getCountDown() {
		return countdown;
	}
	
	/**
	*updateWorld : updates the location of each FloatingObjs
	*@param void : a given ArrayList<FloatingObjs>
	*@return void : updates the location of each FloatingObjs by their own move methods
	*/
	public void updateWorld(){
		countdown--;
		//System.out.println("time left is :"+countdown);
		for(FloatingObjs f : loEf){
			f.move();
			f.updateDuration();
			
		}
		spawnNum=(spawnNum+1)%100;
		if(loEf.size()<5){//make sure there is always more than 5 objs on the screen
			this.spawn();
		}
		if(spawnNum%5==1) {
			this.spawn();//spwan every
		}
		
	}
	
	/**
	*getListOfExistedFloatingObjs : a getter function of ModelWorld
	*@param void : nothing
	*@return ArrayList<FloatingObjs> : the speed of this ModelWorldthe list of existed FloatingObjs
	*/
	public ArrayList<FloatingObjs> getListOfExistedFloatingObjs(){
		return loEf;
	}
	
	/**
	*toString : an override function
	*@param void : nothing
	*@return String : make this ModelWorld be able to presented by String
	*/
	public String toString(){
		String str = "";
		for(FloatingObjs f : loEf){
			str += f.toString() + ", \r\n";
		}
		return str;
	}
	
	/**
	*move : update the location of this FloatingObjs
	*@param void : nothing
	*@return void : update the location of this FloatingObjs 
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
	*updateScore :  a setter function of ModelWorld
	*@param int s : a given score
	*@return void : add s to the current score
	*/
	public void updateScore(int s){
		score += s;
	}
	
	/**
	*getScore : a getter function of ModelWorld
	*@param void : nothing
	*@return int : the score of this ModelWorld
	*/
	public int getScore(){
		return score;
	}
	
	/**
	*destory :  a setter function of ModelWorld
	*@param int i : a given id
	*@return void : remove this FloatingObjs from loEf
	*/
	public void destory(int i){
		FloatingObjs f = findFloat(i);
		loEf.remove(f);
	}
	
	/**
	*findFloat :  find the FloatingObjs in loEf by compare the id
	*@param int i : a given id
	*@return FloatingObjs : the found FloatingObjs, if find nothing, return null
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
	*spawn :  a setter function of ModelWorld
	*@param void : nothing
	*@return void : randomly add a copied FloatingObjs from lof to loEf
	*				and add id to this FloatingObjs
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
/**
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
	}//main**/

}