package model;

import java.util.ArrayList;

public class PlayerStats {
	
	private Player player;
	

	
	private ArrayList<Event> events;	// lista eventova iz kojih se statistike racunaju
	
	public PlayerStats() {
		events = new ArrayList<Event>();
	}
	
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
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
	
/*


	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

	public int getJumps() {
		return jumps;
	}

	public void setJumps(int jumps) {
		this.jumps = jumps;
	}

*/
}
