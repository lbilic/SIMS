package model;

import java.util.ArrayList;
import java.util.Date;

public class Match {
	private String court;
	private Team home = new Team();
	private Team away = new Team();
	private Date time;
	private ArrayList<Referee> referees;
	private ArrayList<Event> events = new ArrayList<Event>();
	
	public void addEvent(Event e) {
		events.add(e);
	}

	public Player getPlayer(String team, int playerNumber) {
		if(team.equalsIgnoreCase("home"))
			return home.getPlayer(playerNumber);
		else
			return away.getPlayer(playerNumber);
	}
}
