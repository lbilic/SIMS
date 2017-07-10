package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Coach;
import model.Match;
import model.Player;
import model.Team;
import model.Timer;
import model.Town;
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
	private Stage openingStage;
	private Stage inputStage;

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
	
	public void setOpeningStage(Stage openingStage){
		this.openingStage = openingStage;
	}
	
	public void newMatch(){
		openingStage.hide();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/insertWindow.fxml"));
        Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add("view/resources/style.css");
	        inputStage = new Stage();
	        inputStage.setScene(scene);
	        inputStage.show();
	        
	        match = new Match();
	        
		} catch (IOException e) {
			openingStage.show();
		}
        
        
	}
	
	public void cancelMatch(){
		inputStage.close();
		openingStage.show();
	}
	
	public void startMatch(){
		match.startMatch();
	}
	
	public void startMatchView(){
		inputStage.close();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainWindow.fxml"));
        Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
	        scene.getStylesheets().add("view/resources/style.css");
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	public void generateMatchInfo() {
		Team home = new Team();
		Team away = new Team();
		home.setName("Crvena Zvezda");
		
		home.addPlayer(new Player("Milos Milankovic", 1));
		home.addPlayer(new Player("Nikola Jankovic", 2));
		home.addPlayer(new Player("Nemanja Ursulesku", 3));
		home.addPlayer(new Player("Vlade Divac", 4));
		home.addPlayer(new Player("Nikola Majkic", 5));
		home.addPlayer(new Player("Antonio Bezinski", 6));
		home.addPlayer(new Player("Mario Kalas", 7));
		home.addPlayer(new Player("Jovan Nikolic", 8));
		home.addPlayer(new Player("Zeljko Petrovic", 9));
		home.addPlayer(new Player("Marko Strmina", 10));
		home.addPlayer(new Player("Stevan Doslo", 11));
		home.addPlayer(new Player("Petar Jovanovic", 12));
		home.setCoach(new Coach("Nikola Jovic"));
		home.setHome_town(new Town("Beograd"));
		home.setColor("#ffffff");
		ArrayList<String> homeNames = new ArrayList<String>();
		for(Player p : home.getPlayers())
			homeNames.add(p.getName());
		
		away.setName("Vojvodina");
		away.addPlayer(new Player("Zeljko Milankovic", 1));
		away.addPlayer(new Player("Iman Jan", 2));
		away.addPlayer(new Player("Janos Juhas", 3));
		away.addPlayer(new Player("Istvan Petrov", 4));
		away.addPlayer(new Player("Djordje Brstina", 5));
		away.addPlayer(new Player("Marko Riban", 6));
		away.addPlayer(new Player("Darko Jovan", 7));
		away.addPlayer(new Player("Luka Milosevic", 8));
		away.addPlayer(new Player("Milan Stankovic", 9));
		away.addPlayer(new Player("Rade Doroslovacki", 10));
		away.addPlayer(new Player("Nemanja Bjelica", 11));
		away.addPlayer(new Player("Ivan Bjelis", 12));
		away.setCoach(new Coach("Jovan Jankov"));
		away.setHome_town(new Town("Novi Sad"));
		away.setColor("#000000");
		ArrayList<String> awayNames = new ArrayList<String>();
		for(Player p : away.getPlayers())
			awayNames.add(p.getName());
		
		view.setHomeTeam(home.getName());
		view.setHomeTeamColor(Color.web(home.getColor()));
		ArrayList<String> petorka = new ArrayList<String>();
		for(int i = 1; i <= 5; i++)
			petorka.add(String.valueOf(i));
		view.setHomeTeamOnCourt(petorka);
		view.setHomeTeamPlayers(homeNames);
		
		view.setAwayTeam(away.getName());
		view.setAwayTeamColor(Color.web(away.getColor()));
		view.setAwayTeamOnCourt(petorka);
		view.setAwayTeamPlayers(awayNames);
		
		match.setHome(home);
		match.setAway(away);
		}

}
