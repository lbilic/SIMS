package controller;

import model.Match;
import model.Player;
import model.Timer;
import model.events.Assist;
import model.events.Block;
import model.events.DefensiveFoul;
import model.events.DefensiveRebound;
import model.events.OffensiveFoul;
import model.events.OffensiveRebound;
import model.events.OnePtShot;
import model.events.Steal;
import model.events.ThreePtShot;
import model.events.Turnover;
import model.events.TwoPtShot;
import view.controller.ViewController;

public class MainController {
	private ViewController view;
	private static MainController instance = null;
	private Match match;
	private String tempTeam, tempNumber, tempAction;

	private MainController() {
		match = new Match();
	}
	
	public void start() {
		match.startTime();
	}
	
	public void pause() {
		match.pauseTime();
	}
	
	public void updateTime(Timer t) {
		view.setTime(String.valueOf(t.getTime() / 60) + " : " + String.format("%02d", t.getTime() % 60));
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
	
	public Player getPlayer(String team, int playersNumber) {
		if(team.equalsIgnoreCase("home"))
			return match.getHome().getPlayer(playersNumber);
		else
			return match.getAway().getPlayer(playersNumber);
	}

	public void eventOccured(String team, String playersNumber, String action) {
		switch (action) {
		case "DEFENSIVEFOUL":
			match.eventOccurred(new DefensiveFoul(getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "OFFENSIVEFOUL":
			match.eventOccurred(new OffensiveFoul(getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "DEFENSIVEREBOUND":
			match.eventOccurred(new DefensiveRebound(getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "OFFENSIVEREBOUND":
			match.eventOccurred(new OffensiveRebound(getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "STEAL":
			match.eventOccurred(new Steal(getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "ASSIST":
			match.eventOccurred(new Assist(getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "TURNOVER":
			match.eventOccurred(new Turnover(getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		case "BLOCK":
			match.eventOccurred(new Block(getPlayer(team, Integer.parseInt(playersNumber))));
			break;
		}
		System.out.println(team + playersNumber + action);
	}

	public void eventOccured(String scored, int x, int y) {
		switch (tempAction) {
		case "1 POINTSHOT":
			match.eventOccurred(new OnePtShot(getPlayer(tempTeam, Integer.parseInt(tempNumber)), scored, x, y));
			break;
		case "2 POINTSHOT":
			match.eventOccurred(new TwoPtShot(getPlayer(tempTeam, Integer.parseInt(tempNumber)), scored, x, y));
			break;
		case "3 POINTSHOT":
			match.eventOccurred(new ThreePtShot(getPlayer(tempTeam, Integer.parseInt(tempNumber)), scored, x, y));
			break;
		}
		System.out.println(tempTeam + tempNumber + "scored" + x + y);
	}
	
	public void dataRequiredMessage(){
		System.out.println("No data inserted!");
	}

}
