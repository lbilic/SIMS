package model.events;

import java.util.Date;

import model.Contributor;

public abstract class Event {
	private Date time;
	private Contributor contributor;
	
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
	
	
}
