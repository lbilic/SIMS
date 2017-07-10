package model.events;

import model.Player;

public class DefensiveFoul extends Foul{
	public DefensiveFoul(Player contributor) {
		setContributor(contributor);
	}
}
