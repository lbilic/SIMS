package model.events;

import model.Player;

public class DefensiveRebound extends Rebound{
	public DefensiveRebound(Player contributor) {
		setContributor(contributor);
	}
}
