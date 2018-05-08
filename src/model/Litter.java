package model;

public class Litter extends FloatingObjs {

	/**
	 * Constructs an Litter Object filling in fields as in its super class, FloatingObjs. 
	 * Takes a String, an int, an int as parameter and inherits the constructor in its super class.
	 * Fills the name, xloc and yloc field of this Litter.
	 * Fills the id field of this Litter with "Litter".
	 * 
	 * @param n   Litter' name as a String
	 * @param x   this x location where this Litter is located
	 * @param y   this y location where this Litter is located
	 */
	public Litter(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Litter";
	}
	/**
	 * Increments this xloc and yloc by the corresponding xInc and yInc, with the speed as multiplier.
	 * Represents the movement that each Litter has in the game.
	 * 
	 */
	public void move(){
		yloc += yInc * speed;
		xloc += xInc * speed;
	}//move

}
