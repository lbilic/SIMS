package model;

import java.util.ArrayList;

public class Team {
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Player getPlayer(int number) {
		for(Player p : players)
			if(p.getNumber() == number) {
				return p;
			}
		return null;
	}
	
	public Team() {
		for(int i = 0; i < 25; i++)
			players.add(new Player("blah", i));
	}
}
