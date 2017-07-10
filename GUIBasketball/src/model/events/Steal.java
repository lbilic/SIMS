package model.events;

import model.Player;

public class Steal extends Event{
	public Steal(Player contributor) {
		setContributor(contributor);
	}
}
