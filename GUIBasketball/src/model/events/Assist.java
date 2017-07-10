package model.events;

import model.Player;

public class Assist extends Event{

	public Assist(Player contributor) {
		setContributor(contributor);
	}

}
