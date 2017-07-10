package model;

import java.util.ArrayList;
import java.util.Date;

import model.events.Event;

public class Match {
	private Team home;
	private Team away;
	private Date date;
	private Referee referee;
	private ArrayList<Event> events;
	private State active;
	private Arena played_in;
	private Timer timer;
	
	public Match(){
		events = new ArrayList<Event>();
		active = new Creating(this);
		timer = new Timer();
	}
	
	public Timer getTimer(){
		return timer;
	}
	
	public void addEvent(Event e) {
		events.add(e);
	}
	
	public void writeToFile() {
		// TODO: odraditi upis u fajl
	}
	
	public void changeState(State state) {
		active = state;
	}
	
	public void startTime() {
		active.timeStarted();
	}
	
	public void pauseTime() {
		active.timePaused();
	}
	
	public Team getHome() {
		return home;
	}
	
	public Team getAway() {
		return away;
	}
	public void startMatch(){
		active.startMatch();
	}
	public void finishMatch(){
		active.finishMatch();
	}
	public void timeRanOut(){
		active.timeRanOut();
	}
	public void eventOccurred(Event event){
		active.eventOccurred(event);
	}

	public ArrayList<Event> getEvents() {
		return events;
	}
	
	
}
