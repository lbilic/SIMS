package model.events;

import model.Player;

public class Block extends Event{

	public Block(Player contributor) {
		setContributor(contributor);
	}

}
