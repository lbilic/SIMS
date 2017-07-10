package model.events;

import model.Player;

public class Turnover extends Event{

	public Turnover(Player contributor) {
		setContributor(contributor);
	}

}
