package model;

import model.events.Event;

public class Running extends State{
	Match match;
	
	public Running(Match match){
		this.match = match;
	}
	
	@Override
	public void entry() {
		match.getTimer().start();
	}

	@Override
	public void exit() {	}

	@Override
	public void timePaused() {	
		match.changeState(new Paused(match));
	}

	@Override
	public void timeStarted() {	}

	@Override
	public void startMatch() {	}

	@Override
	public void finishMatch() {	}

	@Override
	public void timeRanOut() {
		match.changeState(new Finished(match));
	}

	@Override
	public void eventOccurred(Event event) {
		match.addEvent(event);
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	

}
