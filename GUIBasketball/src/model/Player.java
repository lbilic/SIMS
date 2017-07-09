package model;

public class Player extends Contributor{
	private String name;
	private int number;
	
	public Player(String _name, int _number) {
		name = _name;
		number = _number;
	}
	
	public int getNumber() {
		return number;
	}
}
