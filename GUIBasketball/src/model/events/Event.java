package model.events;

import java.util.Date;

import model.Contributor;
import model.TeamEnum;

public abstract class Event {
	private Date time;
	private Contributor contributor;
	private TeamEnum team;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Contributor getContributor() {
		return contributor;
	}
	public void setContributor(Contributor contributor) {
		this.contributor = contributor;
	}
	public TeamEnum getTeam() {
		return team;
	}
	public void setTeam(TeamEnum team) {
		this.team = team;
	}
	
	
}
