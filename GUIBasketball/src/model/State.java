package model;

public abstract class State {
	abstract public void entry();
	abstract public void exit();
	abstract public void timePaused();
	abstract public void timeStarted();
}
