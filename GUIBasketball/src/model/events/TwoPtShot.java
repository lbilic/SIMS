package model.events;

import model.Player;

public class TwoPtShot extends Shot{

	public TwoPtShot(Player contributor, String scored, int _x, int _y) {
		setContributor(contributor);
		made = scored.equalsIgnoreCase("dao");
		pos_x = _x;
		pos_y = _y;
	}

}
