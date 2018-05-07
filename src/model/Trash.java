package model;

public class Trash extends FloatingObjs {
	//subclass of floating object, have different ID than other instances'
	//has different speed 
	public Trash(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Litter";
	}
	public Trash(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		// TODO Auto-generated constructor stub
		this.id = "Litter";
	}
	
	public Trash(FloatingObjs f) {
		// TODO Auto-generated constructor stub
		super(f);
		this.id = "Litter";
	}

	public void move(){
		yloc += yInc * speed;
		yloc = Math.floorMod(yloc,1080);
		xloc += xInc * speed;
		xloc = Math.floorMod(xloc,1980);
	}//move

}
