package model.events;

import model.Player;

public class OffensiveFoul extends Foul{
	public OffensiveFoul(Player contributor) {
		setContributor(contributor);
	}
}
