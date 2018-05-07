package model;

public abstract class FloatingObjs {
	protected String name;
	protected int xloc;
	protected int yloc;
	protected int xInc = 1;
	protected int yInc = 1;
	protected String id;
	protected int speed;
	protected int score;
	protected int duration;
	
	public FloatingObjs(String n, int x, int y,int spee,int sco, int due){
		this.name = n;
		this.xloc = x;
		this.yloc = y;
		this.id = "FloatingObjs";
		speed = spee;
		score = sco;
		duration = due;
	}
	public FloatingObjs(String n, int x, int y){
		this.name = n;
		this.xloc = x;
		this.yloc = y;
		this.id = "FloatingObjs";
		speed = 30;
		score = 100;
		duration = 600;
	}
	public FloatingObjs(FloatingObjs f){
		this.name = f.getName();
		this.id = f.getId();
		speed = f.getSpeed();
		score = f.getScore();
		duration = f.getDuration();
	}
	
	public int getXloc() {
		return xloc;
	}
	public int getYloc() {
		return yloc;
	}
	public int setXloc() {
		return xloc;
	}
	public int setYloc() {
		return yloc;
	}
	
	public String getName(){
		return name;
	}
	
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int newspeed){
		speed = newspeed;
	}

	public void move() {
		double rand = Math.random() * 3;//[0,3)
		xInc =(int) rand - 1;//[-1, 1]
		xloc += xInc * speed;
		rand = Math.random() * 3;
		yInc = (int) rand - 1;//[-1, 1]
		yloc += yInc * speed ;
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
	
	public int getScore(){
		return score;
	}
}
