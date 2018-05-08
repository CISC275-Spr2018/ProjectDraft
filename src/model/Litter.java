package model;

public class Litter extends FloatingObjs {

	public Litter(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Litter";
	}
	
	public void move(){
		yloc += yInc * speed;
		xloc += xInc * speed;
	}//move

}
