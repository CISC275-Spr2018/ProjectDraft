package model;

public class InvasiveSpecies extends Animal {
	
	public InvasiveSpecies(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Invasion";
	}
	public InvasiveSpecies(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		// TODO Auto-generated constructor stub
		this.id = "Invasion";
	}
	
	public InvasiveSpecies(FloatingObjs f) {
		// TODO Auto-generated constructor stub
		super(f);
		this.id = "Invasion";
	}

	public String toString(){
		return "bad: " + super.toString();
	}
}
