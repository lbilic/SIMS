package model;

import model.events.Event;

public abstract class State {
	abstract public void entry();
	abstract public void exit();
	abstract public void timePaused();
	abstract public void timeStarted();
	abstract public void startMatch();
	abstract public void finishMatch();
	abstract public void timeRanOut();
	abstract public void eventOccurred(Event event);
}
