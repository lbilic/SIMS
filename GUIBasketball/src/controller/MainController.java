package controller;

import model.*;
import view.controller.ViewController;

public class MainController {
	private ViewController view;
	private static MainController instance = null;
	private Match match;
	private String tempTeam, tempNumber, tempAction;
	
	
	private MainController() {
		match = new Match();
	}
	
	public void setViewController(ViewController _vc) {
		view = _vc;
	}
	
	public static MainController getInstance() { 
		if (instance == null)
			instance = new MainController();
		return instance;
	}

	public void shotOccured(String team, String playersNumber, String action) {
		tempTeam = team;
		tempNumber = playersNumber;
		tempAction = action;
	}
	
	public void eventOccured(String team, String playersNumber, String action) {
		switch(action) {
		case "DEFENSIVEFOUL": match.addEvent(new DefensiveFoul(match.getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "OFFENSIVEFOUL": match.addEvent(new OffensiveFoul(match.getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "DEFENSIVEREBOUND": match.addEvent(new DefensiveRebound(match.getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "OFFENSIVEREBOUND": match.addEvent(new OffensiveRebound(match.getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "STEAL": match.addEvent(new Steal(match.getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "ASSIST": match.addEvent(new Assist(match.getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "TURNOVER": match.addEvent(new Turnover(match.getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "BLOCK": match.addEvent(new Block(match.getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		}
		System.out.println(team + playersNumber + action);
	}
	
	public void eventOccured(String scored, int x, int y) {
		switch(tempAction) {
		case "1 POINTSHOT": match.addEvent(new OnePtShot(match.getPlayer(tempTeam, Integer.parseInt(tempNumber)), scored, x, y));
			break;
		case "2 POINTSHOT": match.addEvent(new TwoPtShot(match.getPlayer(tempTeam, Integer.parseInt(tempNumber)), scored, x, y));
			break;
		case "3 POINTSHOT": match.addEvent(new ThreePtShot(match.getPlayer(tempTeam, Integer.parseInt(tempNumber)), scored, x, y));
			break;
		}
		System.out.println(tempTeam + tempNumber + "scored" + x + y);
	}
	
}
