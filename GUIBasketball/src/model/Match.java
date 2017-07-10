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
		active.exit();
		active = state;
		active.entry();
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
	
	public String getState() {
		return active.getClass().toString();
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Referee getReferee() {
		return referee;
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	public State getActive() {
		return active;
	}

	public void setActive(State active) {
		this.active = active;
	}

	public Arena getPlayed_in() {
		return played_in;
	}

	public void setPlayed_in(Arena played_in) {
		this.played_in = played_in;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	
}
