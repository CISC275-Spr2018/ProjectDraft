package model;

import java.util.ArrayList;
import javax.swing.Timer;


public class ModelWorld {
	private ArrayList<FloatingObjs> lof;
	private int score;
	//private int time;
	//private Timer timer;

	
	public ModelWorld(ArrayList<FloatingObjs> l){
		this.lof = l;
		this.time=0;
		//this.timer = new Timer(1000, new FishTimer());
	}//constructor
	
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
	
	public void updateScore(int s){
		score += s;
	}
	
	//public void start(){
	//	timer.scheduleAtFixedRate(task, 0, 1000);
	//}
	
	public int getScore(){
		return score;
	}
	
	public void destory(){}
	
	public void spawn(){}

}
