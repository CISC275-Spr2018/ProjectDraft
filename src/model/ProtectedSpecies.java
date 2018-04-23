package model;

public class ProtectedSpecies extends Animal{
	
	public ProtectedSpecies(String n, int x, int y) {
		super(n, x, y);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return "good: " + super.toString();
	}
}
