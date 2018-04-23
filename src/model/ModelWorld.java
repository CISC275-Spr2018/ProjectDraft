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
	
	public ArrayList<FloatingObjs> getListOfFloatingObjs(){
		return lof;
	}
	
	public String toString(){
		String str = "";
		for(FloatingObjs f : lof){
			str += f.toString() + ", \r\n";
		}
		return str;
	}
	
	public void move(){
		for(FloatingObjs f : lof){
			f.move();
		}
	}
	
	public void destory(){}
	
	public void spawn(){}

	

}
