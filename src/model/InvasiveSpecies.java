package model;

/**
 * Class InvasiveSpecies
 * @author Team 11 - 8
 * */

public class InvasiveSpecies extends Animal {
	//subclass of animal, have different ID than other instances

	/**
	 *InvasiveSpecies : a constructor of InvasiveSpecies
	 *@param String s: the name of this InvasiveSpecies
	 *@param int x: the x-position of this InvasiveSpecies
	 *@param int y: the y-position of this InvasiveSpecies
	 *@return InvasiveSpecies : Construct a new InvasiveSpecies
	 */
	public InvasiveSpecies(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Invasion";
	}

	/**
	 *InvasiveSpecies : a constructor of InvasiveSpecies
	 *@param String s: the name of this InvasiveSpecies
	 *@param int x: the x-position of this InvasiveSpecies
	 *@param int y: the y-position of this InvasiveSpecies
	 *@param int spee: the speed of this InvasiveSpecies
	 *@param int sco: the score of this InvasiveSpecies
	 *@param int due: the duration of this InvasiveSpecies
	 *@return InvasiveSpecies : Construct a new InvasiveSpecies
	 */
	public InvasiveSpecies(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		// TODO Auto-generated constructor stub
		this.id = "Invasion";
	}

	/**
	 *InvasiveSpecies : a constructor of InvasiveSpecies
	 *@param FloatingObjs f: a given FloatingObjs(should be InvasiveSpecies)
	 *@return InvasiveSpecies : clone a new InvasiveSpecies
	 */
	public InvasiveSpecies(FloatingObjs f) {
		// TODO Auto-generated constructor stub
		super(f);
		this.id = "Invasion";
	}

	/**
	 *toString : an override function
	 *@param void : nothing
	 *@return String : make this InvasiveSpecies be able to presented by String
	 */
	public String toString(){
		return "bad: " + super.toString();
	}
}
