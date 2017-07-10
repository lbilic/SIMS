package model;

import java.util.ArrayList;

public class Team {
	private ArrayList<Player> players = new ArrayList<Player>();
	private Coach coach;
	private Town home_town;
	private String color;
	private String name;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Player getPlayer(int number) {
		for(Player p : players)
			if(p.getNumber() == number) {
				return p;
			}
		return null;
	}
	
	public Team() {
		//for(int i = 0; i < 25; i++)
		//	players.add(new Player("blah", i));
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Town getHome_town() {
		return home_town;
	}

	public void setHome_town(Town home_town) {
		this.home_town = home_town;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
