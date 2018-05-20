package model;

/**
 * Class Trash
 * @author Team 11 - 8
 * */

public class Trash extends FloatingObjs {
	//subclass of floating object, have different ID than other instances'
	//has different speed 

	/**
	 *Trash : a constructor of Trash
	 *@param String s: the name of this Trash
	 *@param int x: the x-position of this Trash
	 *@param int y: the y-position of this Trash
	 *@return Trash : Construct a new Trash
	 */
	public Trash(String n, int x, int y) {
		super(n, x, y);
		this.id = "Litter";
	}

	/**
	 *Trash : a constructor of Trash
	 *@param String s: the name of this Trash
	 *@param int x: the x-position of this Trash
	 *@param int y: the y-position of this Trash
	 *@param int spee: the speed of this Trash
	 *@param int sco: the score of this Trash
	 *@param int due: the duration of this Trash
	 *@return Trash : Construct a new Trash
	 */
	public Trash(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		this.id = "Litter";
	}

	/**
	 *Trash : a constructor of Trash
	 *@param FloatingObjs f: a given FloatingObjs(should be Trash)
	 *@return Trash : clone a new Trash
	 */
	public Trash(FloatingObjs f) {
		super(f);
		this.id = "Litter";
	}

	/**
	 *move : update the location of this Trash
	 *@param void : nothing
	 *@return void : update the location of this Trash 
	 */
	public void move(){
		yloc += yInc * speed;
		yloc = Math.floorMod(yloc,1080);
		xloc += xInc * speed;
		xloc = Math.floorMod(xloc,1980);
	}//move

}
