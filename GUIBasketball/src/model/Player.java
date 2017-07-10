package model;

public class Player extends Contributor{
	private String name;
	private int number;
	private double height;
	private Position position;
	private Team plays_for;
	
	public Player(String _name, int _number) {
		name = _name;
		number = _number;
	}
	
	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Team getPlays_for() {
		return plays_for;
	}

	public void setPlays_for(Team plays_for) {
		this.plays_for = plays_for;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
