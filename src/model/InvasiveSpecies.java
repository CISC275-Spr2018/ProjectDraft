package model;

public class InvasiveSpecies extends Animal {
	/**
	 * Constructs an InvasiveSpecies Object filling in fields as in its super class, Animal. 
	 * Takes a String, an int, an int as parameter and inherits the constructor in its super class.
	 * Fills the name, xloc and yloc field of this InvasiveSpecies.
	 * Fills the id field of this InvasiveSpecies with "Invasion".
	 * 
	 * @param n   InvasiveSpecies' name as a String
	 * @param x   this x location where this InvasiveSpecies is located
	 * @param y   this y location where this InvasiveSpecies is located
	 */
	public InvasiveSpecies(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Invasion";
	}
	/**
	 * Constructs an InvasiveSpecies Object filling in fields as in its super class, Animal. 
	 * Takes a String and five int as parameters and inherits the constructor in its super class.
	 * Fills the name, xloc, yloc, speed, score and duration field of this InvasiveSpecies.
	 * Fills the id field of this InvasiveSpecies with "Invasion".
	 * 
	 * 
	 * @param n    InvasiveSpecies' name as a String
	 * @param x    this x location where this InvasiveSpecies is located
	 * @param y    this y location where this InvasiveSpecies is located
	 * @param spee an int indicates this InvasiveSpecies' speed as moving on the screen
	 * @param sco  an int as InvasiveSpecies' score
	 * @param due  an int as InvasiveSpecies' duration time
	 */
	public InvasiveSpecies(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		// TODO Auto-generated constructor stub
		this.id = "Invasion";
	}
	/**
	 * Constructs an InvasiveSpecies by passing a FloatingObjs as parameter.
	 * Fills 5 fields with this corresponding values in fields of its parameter, a FloatingObjs.
	 * 
	 * @param f  a FloatingObjs whose fields are copied by this InvasiveSpecies	 
	 */
	public InvasiveSpecies(FloatingObjs f) {
		// TODO Auto-generated constructor stub
		super(f);
		this.id = "Invasion";
	}

	/**
	 *  This toString method makes a new String made up of this InvasiveSpecies' name, speed, score and id.
	 *  Inherits from superclass FloatingObjs.
	 *  
	 * @return a String indicates that invasive species are bad for estuary
	 */
	public String toString(){
		return "bad: " + super.toString();
	}
}
