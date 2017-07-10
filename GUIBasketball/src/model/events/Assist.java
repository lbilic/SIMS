package model.events;

import model.Player;
import model.TeamEnum;

public class Assist extends Event{

	public Assist(Player contributor) {
		setContributor(contributor);
	}
	
	public Assist(Player contributor, TeamEnum team){
		setContributor(contributor);
		setTeam(team);
	}

}
