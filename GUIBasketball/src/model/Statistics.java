package model;

import java.util.ArrayList;

import model.events.Assist;
import model.events.DefensiveRebound;
import model.events.Event;
import model.events.Foul;
import model.events.OffensiveRebound;
import model.events.OnePtShot;
import model.events.Rebound;
import model.events.Shot;
import model.events.Steal;
import model.events.ThreePtShot;
import model.events.Turnover;
import model.events.TwoPtShot;

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
	
	public static Stat getStats(ArrayList<Event> events, Player player) {
		Stat retVal = new Stat();
		retVal.setPoints(0);
		retVal.setFga(0);
		retVal.setFgm(0);
		for(Event e : events) {
			if (e.getContributor() == player){
				if (e instanceof OnePtShot){
					retVal.setFta(retVal.getFta() + 1);
					if (((Shot)e).made){
						retVal.setPoints(retVal.getPoints() + 1);
						retVal.setFtm(retVal.getFtm() + 1);
					}
				}
				else if (e instanceof TwoPtShot){
					retVal.setFga(retVal.getFga() + 1);
					if (((Shot)e).made){
						retVal.setPoints(retVal.getPoints() + 2);
						retVal.setFgm(retVal.getFgm() + 1);
					}
				}
				else if (e instanceof ThreePtShot){
					retVal.setFga(retVal.getFga() + 1);
					if (((Shot)e).made){
						retVal.setPoints(retVal.getPoints() + 3);
						retVal.setFgm(retVal.getFgm() + 1);
					}
				}
				if (e instanceof Assist) {
					retVal.setAssists(retVal.getAssists() + 1);
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
		}
		retVal.setRebounds(retVal.getDefensive_rebounds() + retVal.getOffensive_rebounds());
		retVal.setFg_percentage(100 * retVal.getFgm()/retVal.getFga());
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
