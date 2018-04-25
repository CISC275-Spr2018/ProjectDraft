package model;

public abstract class FloatingObjs {
	private String name;
	private int xloc;
	private int yloc;
	private int speed;
	private int score;
	private int duration;
	
	public FloatingObjs(String n, int x, int y){
		this.name = n;
		this.xloc = x;
		this.yloc = y;
		speed = 30;
		score = 100;
		duration = 600;
	}
	
	public int getXloc() {
		return xloc;
	}
	public int getYloc() {
		return yloc;
	}
	
	public String getName(){
		return name;
	}
	public void destory() {
		
	}
	public void onClick(){};
	public void move() {
		double rand = Math.random() * 3;//[0,3)
		int xInc =(int) rand - 1;//[-1, 1]
		xloc += xInc * speed;
		rand = Math.random() * 3;
		int yInc = (int) rand - 1;//[-1, 1]
		yloc += yInc * speed;
		//System.out.println(xloc +"~~~~~~~~~~~~~~"+yloc);
	}//move
	
	public String toString(){
		return name+"-> speed: "+speed+" score: "+score;
	}
}
