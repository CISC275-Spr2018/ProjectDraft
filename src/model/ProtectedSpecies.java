package model;

/**
 * Class ProtectedSpecies
 * @author Team 11 - 8
 * */

public class ProtectedSpecies extends Animal{
	
	/**
	*ProtectedSpecies : a constructor of ProtectedSpecies
	*@param String s: the name of this ProtectedSpecies
	*@param int x: the x-position of this ProtectedSpecies
	*@param int y: the y-position of this ProtectedSpecies
	*@return ProtectedSpecies : Construct a new ProtectedSpecies
	*/
	//subclass of animal, have different ID than other instances'
	public ProtectedSpecies(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Protected";
	}
	
	/**
	*ProtectedSpecies : a constructor of ProtectedSpecies
	*@param String s: the name of this ProtectedSpecies
	*@param int x: the x-position of this ProtectedSpecies
	*@param int y: the y-position of this ProtectedSpecies
	*@param int spee: the speed of this ProtectedSpecies
	*@param int sco: the score of this ProtectedSpecies
	*@param int due: the duration of this ProtectedSpecies
	*@return ProtectedSpecies : Construct a new ProtectedSpecies
	*/
	public ProtectedSpecies(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		// TODO Auto-generated constructor stub
		this.id = "Protected";
	}
	
	/**
	*ProtectedSpecies : a constructor of ProtectedSpecies
	*@param FloatingObjs f: a given FloatingObjs(should be ProtectedSpecies)
	*@return ProtectedSpecies : clone a new ProtectedSpecies
	*/
	public ProtectedSpecies(FloatingObjs f) {
		// TODO Auto-generated constructor stub
		super(f);
		this.id = "Protected";
	}

	/**
	*toString : an override function
	*@param void : nothing
	*@return String : make this ProtectedSpecies be able to presented by String
	*/
	public String toString(){
		return "good: " + super.toString();
	}
}
