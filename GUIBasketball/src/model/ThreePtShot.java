package model;

import model.events.Shot;

public class ThreePtShot extends Shot{

	public ThreePtShot(Player contributor, String scored, int _x, int _y) {
		setContributor(contributor);
		made = scored.equalsIgnoreCase("dao");
		pos_x = _x;
		pos_y = _y;
	}

}
