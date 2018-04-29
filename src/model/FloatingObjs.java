package model;

public abstract class FloatingObjs {
	protected String name;
	protected int xloc;
	protected int yloc;
	protected int xInc;
	protected int yInc;
	protected String id;
	protected int speed;
	protected int score;
	protected int duration;
	
	public FloatingObjs(String n, int x, int y){
		this.name = n;
		this.xloc = x;
		this.yloc = y;
		this.xInc = 1;
		this.yInc = 1;
		this.id = "FloatingObjs";
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
	public void onClick(){};
	public void move() {
		double rand = Math.random() * 3;//[0,3)
		xInc =(int) rand - 1;//[-1, 1]
		xloc += xInc * speed;
		rand = Math.random() * 3;
		yInc = (int) rand - 1;//[-1, 1]
		yloc += yInc * speed;
		System.out.println(xloc +"~~~~~~~~~~~~~~"+yloc);
	}//move
	
	public String toString(){
		return name+"-> speed: "+speed+" score: "+score + " id: " + id;
	}
	
	public void updateDuration(){
		this.duration--;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public String getId(){
		return id;
	}
	
	public void addIndexId(int i){
		this.id += " " + i;
	}
}
