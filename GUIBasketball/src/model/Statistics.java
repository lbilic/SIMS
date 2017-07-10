package model;

import java.util.ArrayList;

import model.events.Assist;
import model.events.DefensiveRebound;
import model.events.Event;
import model.events.Foul;
import model.events.OffensiveRebound;
import model.events.Rebound;
import model.events.Steal;
import model.events.Turnover;

public class Statistics {
	public static Stat getStats(ArrayList<Event> events) {
		Stat retVal = new Stat();
		for(Event e : events) {
			if (e instanceof Assist) {
				retVal.setAssists(retVal.getAssists() + 1);
			}
			else if (e instanceof Rebound) {
				retVal.setRebounds(retVal.getRebounds() + 1);
			}
			else if (e instanceof OffensiveRebound) {
				retVal.setOffensive_rebounds(retVal.getOffensive_rebounds() + 1);
			}
			else if (e instanceof DefensiveRebound) {
				retVal.setDefensive_rebounds(retVal.getDefensive_rebounds() + 1);
			}
			else if (e instanceof Steal) {
				retVal.setSteals(retVal.getSteals() + 1);
			}
			else if (e instanceof Turnover) {
				retVal.setTurnovers(retVal.getTurnovers() + 1);
			}
			else if (e instanceof Foul) {
				retVal.setFouls(retVal.getFouls() + 1);
			}
		}
		// TODO izracunati ostale statistike koristeci prikupljene statistike
		return retVal;
	}
	
	public static Stat getStatsHome(ArrayList<Event> events) {
		Stat retVal = new Stat();
		for(Event e : events) {
			//System.out.println(e.getClass()); // msm da moze ovako da se dobije koja je statistika u pitanju
			if (e instanceof Assist) {
				retVal.setAssists(retVal.getAssists() + 1);
			}
			else if (e instanceof Rebound) {
				retVal.setRebounds(retVal.getRebounds() + 1);
			}
			else if (e instanceof OffensiveRebound) {
				retVal.setOffensive_rebounds(retVal.getOffensive_rebounds() + 1);
			}
			else if (e instanceof DefensiveRebound) {
				retVal.setDefensive_rebounds(retVal.getDefensive_rebounds() + 1);
			}
			else if (e instanceof Steal) {
				retVal.setSteals(retVal.getSteals() + 1);
			}
			else if (e instanceof Turnover) {
				retVal.setTurnovers(retVal.getTurnovers() + 1);
			}
			else if (e instanceof Foul) {
				retVal.setFouls(retVal.getFouls() + 1);
			}
		}
		// TODO izracunati ostale statistike koristeci prikupljene statistike
		return retVal;
	}
	
	public static Stat getStatsAway(ArrayList<Event> events) {
		Stat retVal = new Stat();
		for(Event e : events) {
			//System.out.println(e.getClass()); // msm da moze ovako da se dobije koja je statistika u pitanju
			if (e instanceof Assist) {
				retVal.setAssists(retVal.getAssists() + 1);
			}
			else if (e instanceof Rebound) {
				retVal.setRebounds(retVal.getRebounds() + 1);
			}
			else if (e instanceof OffensiveRebound) {
				retVal.setOffensive_rebounds(retVal.getOffensive_rebounds() + 1);
			}
			else if (e instanceof DefensiveRebound) {
				retVal.setDefensive_rebounds(retVal.getDefensive_rebounds() + 1);
			}
			else if (e instanceof Steal) {
				retVal.setSteals(retVal.getSteals() + 1);
			}
			else if (e instanceof Turnover) {
				retVal.setTurnovers(retVal.getTurnovers() + 1);
			}
			else if (e instanceof Foul) {
				retVal.setFouls(retVal.getFouls() + 1);
			}
		}
		// TODO izracunati ostale statistike
		return retVal;
	}
}
