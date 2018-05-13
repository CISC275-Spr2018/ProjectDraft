package model;
/**
 * Class FloatingObjs
 * @author Team 11 - 8
 * */
public abstract class FloatingObjs {
	//super class of animal class and trash class
	
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
	*FloatingObjs : a constructor of FloatingObjs
	*@param String s: the name of this FloatingObjs
	*@param int x: the x-position of this FloatingObjs
	*@param int y: the y-position of this FloatingObjs
	*@param int spee: the speed of this FloatingObjs
	*@param int sco: the score of this FloatingObjs
	*@param int due: the duration of this FloatingObjs
	*@return FloatingObjs : Construct a new FloatingObjs
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
	*FloatingObjs : a constructor of FloatingObjs
	*@param String s: the name of this FloatingObjs
	*@param int x: the x-position of this FloatingObjs
	*@param int y: the y-position of this FloatingObjs
	*@return FloatingObjs : Construct a new FloatingObjs
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
	*FloatingObjs : a constructor of FloatingObjs
	*@param FloatingObjs f: a given FloatingObjs
	*@return FloatingObjs : clone a new FloatingObjs
	*/
	public FloatingObjs(FloatingObjs f){
		this.name = f.getName();
		this.id = f.getId();
		speed = f.getSpeed();
		score = f.getScore();
		duration = f.getDuration();
	}
	
	/**
	*getXloc : a getter function of FloatingObjs
	*@param void : nothing
	*@return int : the x-location of this FloatingObjs
	*/
	public int getXloc() {
		return xloc;
	}
	
	/**
	*getName : a getter function of FloatingObjs
	*@param void : nothing
	*@return int : the y-location of this FloatingObjs
	*/
	public int getYloc() {
		return yloc;
	}
	
	/*/**
	*setXloc : a setter function of FloatingObjs
	*@param void : nothing
	*@return int : the x-location of this FloatingObjs
	*
	public int setXloc() {
		return xloc;
	}
	
	**
	*setYloc : a setter function of FloatingObjs
	*@param void : nothing
	*@return int : the y-location of this FloatingObjs
	*
	public int setYloc() {
		return yloc;
	}
	*/
	
	/**
	*getName : a getter function of FloatingObjs
	*@param void : nothing
	*@return String : the name of this FloatingObjs
	*/
	public String getName(){
		return name;
	}
	
	/**
	*getSpeed : a getter function of FloatingObjs
	*@param void : nothing
	*@return int : the speed of this FloatingObjs
	*/
	public int getSpeed(){
		return speed;
	}
	
	/**
	*setSpeed : a setter function of FloatingObjs
	*@param int newSpeed : a given speed
	*@return void : set the speed to the new speed
	*/
	public void setSpeed(int newSpeed){
		speed = newSpeed;
	}

	/**
	*move : update the location of this FloatingObjs
	*@param void : nothing
	*@return void : update the location of this FloatingObjs 
	*/
	public void move() {
		double rand = Math.random() * 3;//[0,3)
		xInc =(int) rand - 1;//[-1, 1]
		xloc += xInc * speed;
		rand = Math.random() * 3;
		yInc = (int) rand - 1;//[-1, 1]
		yloc += yInc * speed ;
		//System.out.println(xloc +"~~~~~~~~~~~~~~"+yloc);
	}//move
	
	/**
	*toString : an override function
	*@param void : nothing
	*@return String : make this FloatingObjs be able to presented by String
	*/
	public String toString(){
		return name+"-> speed: "+speed+" score: "+score + " id: " + id;
	}
	
	/**
	*updateDuration : a setter function of FloatingObjs
	*@param void : nothing
	*@return void : set the duration to decrease by 1
	*/
	public void updateDuration(){
		this.duration--;
	}
	
	/**
	*getDuration : a getter function of FloatingObjs
	*@param void : nothing
	*@return int : the duration of this FloatingObjs
	*/
	public int getDuration(){
		return duration;
	}
	
	/**
	*getId : a getter function of FloatingObjs
	*@param void : nothing
	*@return String : the id of this FloatingObjs
	*/
	public String getId(){
		return id;
	}
	
	/**
	*addIndexId : a setter function of FloatingObjs
	*@param int i : a given index
	*@return void : append the given index to the id of this FloatingObjs
	*/
	public void addIndexId(int i){
		this.id += " " + i;
	}
	
	/**
	*getScore : a getter function of FloatingObjs
	*@param void : nothing
	*@return int : the score of this FloatingObjs
	*/
	public int getScore(){
		return score;
	}
}
