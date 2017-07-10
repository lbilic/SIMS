package model;

import java.util.ArrayList;

import model.events.Event;

public class Statistics {
	public static Stat getStats(ArrayList<Event> events) {
		return null;
	}
	
	public static Stat getStatsHome(ArrayList<Event> events) {
		Stat retVal = new Stat();
		for(Event e : events) {
			System.out.println(e.getClass()); // msm da moze ovako da se dobije koja je statistika u pitanju
		}
		return null;
	}
	
	public static Stat getStatsAway(ArrayList<Event> events) {
		return null;
	}
}
