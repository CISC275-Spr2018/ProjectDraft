package model;

public class InvasiveSpecies extends Animal {
	
	public InvasiveSpecies(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Invasion";
	}

	public String toString(){
		return "bad: " + super.toString();
	}
}
