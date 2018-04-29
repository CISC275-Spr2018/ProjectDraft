package model;

public abstract class Animal extends FloatingObjs{

	//TO DO :Please fill in the functions
	public Animal(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Animal";
	}
	
	public void move(){
		double condition = Math.random() * 200;
		if(condition <=10){
			double rand = Math.random() * 3;//[0,3)
			xInc =(int) rand - 1;//[-1, 1]
			rand = Math.random() * 3;
			yInc = (int) rand - 1;//[-1, 1]
		}
		yloc += yInc * speed;
		xloc += xInc * speed;
	}
}
