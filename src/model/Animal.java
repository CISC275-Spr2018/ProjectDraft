package model;

public abstract class Animal extends FloatingObjs{

	//TO DO :Please fill in the functions
	/**
	 * Constructs an Animal Object filling in fields as in its super class, FloatingObjs. 
	 * Takes a String, an int, an int as parameter and inherits the constructor in its super class.
	 * Fills the name, xloc and yloc field of this Animal.
	 * Fills the id field of this Animal with "Animal".
	 * 
	 * @param n   Animal' name as a String
	 * @param x   this x location where the Animal is located
	 * @param y   this y location where the Animal is located
	 */
	public Animal(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Animal";
	}
	/**
	 * Constructs an Animal Object filling in fields as in its super class, FloatingObjs. 
	 * Takes a String and five int as parameters and inherits the constructor in its super class.
	 * Fills the name, xloc, yloc, speed, score and duration field of this Animal.
	 * Fills the id field of this Animal with "Animal".
	 * 
	 * 
	 * @param n    Animal' name as a String
	 * @param x    this x location where the Animal is located
	 * @param y    this y location where the Animal is located
	 * @param spee an int indicates the Animal' speed as moving on the screen
	 * @param sco  an int as Animal' score
	 * @param due  an int as Animal' duration time
	 */
	public Animal(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		// TODO Auto-generated constructor stub
		this.id = "Animal";
	}
	/**
	 * Constructs an Animal by passing a FloatingObjs as parameter.
	 * Fills 5 fields with this corresponding values in fields of its parameter, a FloatingObjs.
	 * 
	 * @param f  a FloatingObjs whose fields are copied by this Animal
	 */
	public Animal(FloatingObjs f) {
		// TODO Auto-generated constructor stub
		super(f);
	}

	/**
	 * Increments this xloc and yloc by the corresponding xInc and yInc, with the speed as multiplier.
	 * Generates random x and y increment.
	 * Represents the movement that each Animal has in the game.
	 * Prevents the Animal from getting off the screen.
	 * 
	 */
	public void move(){
		double condition = Math.random() * 200;
		if(condition <=10){
			double rand = Math.random() * 3;//[0,3)
			xInc =(int) rand - 1;//[-1, 1]
			rand = Math.random() * 3;
			yInc = (int) rand - 1;//[-1, 1]
		}
		yloc += yInc * speed;
		yloc = Math.floorMod(yloc,1080);
		xloc += xInc * speed;
		xloc = Math.floorMod(xloc,1980);
	}
	
}
