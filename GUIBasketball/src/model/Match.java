package model;

import java.util.ArrayList;
import java.util.Date;

import model.events.Event;

public class Match {
	private String court;
	private Team home = new Team();
	private Team away = new Team();
	private Date time;
	private Referee referees;
	private ArrayList<Event> events = new ArrayList<Event>();
	private State active;
	private Arena played_in;
	
	public void addEvent(Event e) {
		events.add(e);
	}

	public Player getPlayer(String team, int playerNumber) {
		if(team.equalsIgnoreCase("home"))
			return home.getPlayer(playerNumber);
		else
			return away.getPlayer(playerNumber);
	}
	
	public void writeToFile() {
		// TODO: odraditi upis u fajl
	}
	
	public void changeState(State state) {
		
	}
	
	public void startTime() {
		
	}
	
	public void pauseTime() {
		
	}
}
