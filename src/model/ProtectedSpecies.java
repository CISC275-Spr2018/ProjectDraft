package model;

public class ProtectedSpecies extends Animal{
	//subclass of animal, have different ID than other instances'
	public ProtectedSpecies(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
		this.id = "Protected";
	}
	public ProtectedSpecies(String n, int x, int y,int spee,int sco, int due) {
		super(n, x, y,spee,sco,due);
		// TODO Auto-generated constructor stub
		this.id = "Protected";
	}
	public ProtectedSpecies(FloatingObjs f) {
		// TODO Auto-generated constructor stub
		super(f);
		this.id = "Protected";
	}


	public String toString(){
		return "good: " + super.toString();
	}
}
