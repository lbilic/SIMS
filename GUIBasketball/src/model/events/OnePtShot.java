package model.events;

import model.Player;

public class OnePtShot extends Shot{

	public OnePtShot(Player contributor, String scored, int _x, int _y) {
		setContributor(contributor);
		made = scored.equalsIgnoreCase("dao");
		pos_x = _x;
		pos_y = _y;
	}

}
