package model;

import model.events.Event;

public class Paused extends State{
	Match match;
	public Paused(Match match){
		this.match = match;
		entry();
	}

	@Override
	public void entry() {
		match.getTimer().pause();
	}

	@Override
	public void exit() {	}

	@Override
	public void timePaused() {	}

	@Override
	public void timeStarted() {
		if (matchRegular())
			match.changeState(new Running(match));
	}

	@Override
	public void startMatch() {	}

	@Override
	public void finishMatch() {	}
	
	@Override
	public void timeRanOut() {	
		match.changeState(new Finished(match));
	}

	@Override
	public void eventOccurred(Event event) {	}
	
	private boolean matchRegular(){
		
		return true;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}
