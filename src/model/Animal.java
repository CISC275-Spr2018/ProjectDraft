package model;

/**
 * Class Animal
 * @author Team 11 - 8
 * */

public abstract class Animal extends FloatingObjs{

	/**
	*Animal : a constructor of Animal
	*@param String s: the name of this Animal
	*@param int x: the x-position of this Animal
	*@param int y: the y-position of this Animal
	*@return Animal : Construct a new Animal
	*/
	//TO DO :Please fill in the functions
	public Animal(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Animal";
	}
	
	/**
	*Animal : a constructor of Animal
	*@param String s: the name of this Animal
	*@param int x: the x-position of this Animal
	*@param int y: the y-position of this Animal
	*@param int spee: the speed of this Animal
	*@param int sco: the score of this Animal
	*@param int due: the duration of this Animal
	*@return Animal : Construct a new Animal
	*/
	public Animal(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		// TODO Auto-generated constructor stub
		this.id = "Animal";
	}
	
	/**
	*Animal : a constructor of Animal
	*@param FloatingObjs f: a given FloatingObjs(should be Animal)
	*@return Animal : clone a new Animal
	*/
	public Animal(FloatingObjs f) {
		// TODO Auto-generated constructor stub
		super(f);
	}

	/**
	*move : update the location of this Animal
	*@param void : nothing
	*@return void : update the location of this Animal 
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
