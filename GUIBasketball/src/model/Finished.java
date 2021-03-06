package model;

import model.events.Event;

public class Finished extends State{
	
	Match match;
	
	public Finished(Match match){
		this.match = match;
	}

	@Override
	public void entry() {}

	@Override
	public void exit() {

		match.writeToFile();
	}

	@Override
	public void timePaused() {	}

	@Override
	public void timeStarted() {	}

	@Override
	public void startMatch() {	}

	@Override
	public void finishMatch() {	}

	@Override
	public void timeRanOut() {	}

	@Override
	public void eventOccurred(Event event) {	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
}
