package model.events;

import model.Player;
import model.TeamEnum;

public class OnePtShot extends Shot{

	public OnePtShot(Player contributor, String scored, int _x, int _y) {
		setContributor(contributor);
		made = scored.equalsIgnoreCase("dao");
		pos_x = _x;
		pos_y = _y;
	}
	
	public OnePtShot(Player contributor, String scored, int _x, int _y, TeamEnum team) {
		setContributor(contributor);
		setTeam(team);
		made = scored.equalsIgnoreCase("dao");
		pos_x = _x;
		pos_y = _y;
	}

}
