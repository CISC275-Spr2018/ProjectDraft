package model;

import java.io.Serializable;

public abstract class FloatingObjs implements Serializable{
	protected String name;
	protected int xloc;
	protected int yloc;
	protected int xInc = 1;
	protected int yInc = 1;
	protected String id;
	protected int speed;
	protected int score;
	protected int duration;
	/**
	 * Constructs a FloatingObjs Object that all Objects in the game are inherited from. 
	 * Each FloatingObjs has its name, id, x & y position(increment). 
	 * As well as its moving speed, its corresponding score and duration time.
	 * <p>
	 * Initial 7 fields of a FloatingObjs object in this constructor.
	 * 
	 * @param n    FloatingObjs' name as a String
	 * @param x    this x location where the FloatingObjs is located
	 * @param y    this y location where the FloatingObjs is located
	 * @param spee an int indicates the FloatingObjs' speed as moving on the screen
	 * @param sco  an int as FloatingObjs' score
	 * @param due  an int as FloatingObjs' duration time
	 * 
	 */
	public FloatingObjs(String n, int x, int y,int spee,int sco, int due){
		this.name = n;
		this.xloc = x;
		this.yloc = y;
		this.id = "FloatingObjs";
		speed = spee;
		score = sco;
		duration = due;
	}
	/**
	 * Constructs a FloatingObjs with three parameters that fill the name, xloc and yloc field.
	 * Fills in id field with "FloatingObjs".
	 * And this speed, score and duration are set to 30,100 and 600,respectively,
	 * 
	 * @param n   FloatingObjs' name as a String
	 * @param x   this x location where the FloatingObjs is located
	 * @param y   this y location where the FloatingObjs is located
	 *
	 */
	public FloatingObjs(String n, int x, int y){
		this.name = n;
		this.xloc = x;
		this.yloc = y;
		this.id = "FloatingObjs";
		speed = 30;
		score = 100;
		duration = 600;
	}
	/**
	 * Constructs a FloatingObjs by passing another FloatingObjs as parameter.
	 * Fills 5 fields with this corresponding values in fields of its parameter, another FloatingObjs.
	 * 
	 * @param f   a FloatingObjs whose fields are copied by this FloatingObjs
	 * 
	 */
	public FloatingObjs(FloatingObjs f){
		this.name = f.getName();
		this.id = f.getId();
		speed = f.getSpeed();
		score = f.getScore();
		duration = f.getDuration();
	}
	
	/**
	 * Gets an int in this field of xloc.
	 * 
	 * @return the x position of this FloatingObjs
	 */
	public int getXloc() {
		return xloc;
	}
	/**
	 * Gets an int in this field of yloc.
	 * 
	 * @return the y position of this FloatingObjs
	 */
	public int getYloc() {
		return yloc;
	}
/**
 * 
 * @return
 */
	public int setXloc() {
		return xloc;
	}
	/**
	 * 
	 * @return
	 */
	public int setYloc() {
		return yloc;
	}
	/**
	 * Gets a String in this field of name.
	 * 
	 * @return the name of this FloatingObjs
	 */
	public String getName(){
		return name;
	}
	/**
	 * Gets an int in this field of speed.
	 * 
	 * @return the speed of this FloatingObjs
	 */
	public int getSpeed(){
		return speed;
	}
	/**
	 * Sets this FloatingObjs' speed to a new value, as its parameter.
	 * 
	 * @param newspeed  a new speed to replace speed of this FloatingObjs
	 */
	public void setSpeed(int newspeed){
		speed = newspeed;
	}

	/**
	 * Increments this xloc and yloc by the corresponding xInc and yInc, with the speed as multiplier.
	 * Generates random x and y increment.
	 * Represents the movement that each FloatingObjs has in the game.
	 * 
	 */
	public void move() {
		double rand = Math.random() * 3;//[0,3)
		xInc =(int) rand - 1;//[-1, 1]
		xloc += xInc * speed;
		rand = Math.random() * 3;
		yInc = (int) rand - 1;//[-1, 1]
		yloc += yInc * speed ;
		System.out.println(xloc +"~~~~~~~~~~~~~~"+yloc);
	}//move
	
	/**
	 * This toString method makes a new String made up of this FloatingObjs' name, speed, score and id.
	 * 
	 * @return a String that reports this FloatingObjs' state: name,speed, score and id
	 */
	public String toString(){
		return name+"-> speed: "+speed+" score: "+score + " id: " + id;
	}
	/**
	 * Updates the duration time for this FloatingObjs.
	 * Decrements durtion by 1 each time.
	 * 
	 */
	public void updateDuration(){
		this.duration--;
	}
	/**
	 * Gets an int in this field of duration.
	 * 
	 * @return the duration time of this FloatingObjs
	 */
	public int getDuration(){
		return duration;
	}
	/**
	 * Gets a String in this field of id.
	 * 
	 * @return the id of this FloatingObjs
	 */
	public String getId(){
		return id;
	}
	/**
	 * Adds an index for this FloatingObjs' id.
	 * Allows different id for FloatingObjs Objects.
	 * 
	 * @param i an int as an index added at the end of the id String
	 */
	public void addIndexId(int i){
		this.id += " " + i;
	}
	/**
	 * Gets an int in this field of score.
	 * 
	 * @return the score of this FloatingObjs
	 */
	public int getScore(){
		return score;
	}
}
