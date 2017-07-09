package model;

import java.util.ArrayList;

public class Statistics {
	private ArrayList<PlayerStats> playerStats;
	private ArrayList<TeamStats> teamStats;
	
	public Statistics() {
		playerStats = new ArrayList<PlayerStats>();
	}
	
	
	/// trazi igraca po njegovom broju i vraca njegove statistike
	public PlayerStats getPlayerStats(Player player) {
		for (PlayerStats temp : playerStats) {
			if (temp.getPlayer().getNumber() == player.getNumber()) {
				return temp;
			}
		}
		return null;
	}
	
	public void addPlayerStats(Player player, Event event) {
		// TODO nadji igraca i dodaj mu event, ili ako ne postoji dodaj novi PlayerStats sa igracem i eventom
	}
	
	
	public PlayerStats getTeamStats(Team team) {
		// TODO vrati timske statistike u zavisnosti od 'team'
		return null;
	}
	
	public void addTeamStats(Team team, Event event){
		// TODO dadaj timu 'team' event 'event'
	}
}
