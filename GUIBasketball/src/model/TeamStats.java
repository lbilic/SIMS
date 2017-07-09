package model;

import java.util.ArrayList;

public class TeamStats {
	private Team team;
	

	
	private ArrayList<Event> events;	// lista eventova iz kojih se statistike racunaju
	
	public TeamStats() {
		events = new ArrayList<Event>();
	}
	
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	/// funkcije za racunanje statistika
	// TODO fali jos brdo statistika
	
	public int getPoints() {
		int points = 0;
		// TODO formula za racunanje poena !
		return points;
	}
}
