package model;

public abstract class FloatingObjs {
	private String name;
	private int xloc;
	private int yloc;
	private int speed;
	private int score;
	
	public FloatingObjs(String n, int x, int y){
		this.name = n;
		this.xloc = x;
		this.yloc =y;
		speed = 1;
		score = 100;
	}
	
	public int getXloc() {
		return xloc;
	};
	public int getYloc() {
		return yloc;
	};
	public void onClick(){};
	public void move() {
		double rand = Math.random() * 3;//[0,3)
		int xInc =(int) rand - 1;//[-1, 1]
		xloc += xInc * speed;
		rand = Math.random() * 3;
		int yInc = (int) rand - 1;//[-1, 1]
		yloc += yInc * speed;
	}//move
	
	public String toString(){
		return name+"-> speed: "+speed+" score: "+score;
	}
}
