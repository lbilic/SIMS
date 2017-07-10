package model;

public class Coach {
	private String name;
	private Team coaching;
	
	public Coach() {}

	public Coach(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getCoaching() {
		return coaching;
	}

	public void setCoaching(Team coaching) {
		this.coaching = coaching;
	}
}
