package model;

public class Arena {
	private String name;
	private Town placed_in;
	
	public Arena() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Town getPlaced_in() {
		return placed_in;
	}
	public void setPlaced_in(Town placed_in) {
		this.placed_in = placed_in;
	}
	
}
