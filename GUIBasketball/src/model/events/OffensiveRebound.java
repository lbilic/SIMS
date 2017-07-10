package model.events;

import model.Player;

public class OffensiveRebound extends Rebound{
	public OffensiveRebound(Player contributor) {
		setContributor(contributor);
	}
}
