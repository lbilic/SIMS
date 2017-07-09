package view.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import view.controller.radialMenu.RadialMenu;
import view.controller.radialMenu.RadialMenuItem;

public class ViewController implements Initializable {

	@FXML Fauls fauls_home;
	@FXML Fauls fauls_away;
	
	@FXML CheckBox check_box_statistics;
	@FXML Label statusBar;
	@FXML BorderPane statistics;
	
	@FXML FullCourt full_court;
	@FXML ScoreBoard scoreBoard;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//Ovako setujes broj na dugmetu
		//imas i getPlayersNumber koja ti vraca String koji broj igrac nosi
		//full_court.players_on_court ti je arrayList dugmadi na terenu
		full_court.players_on_court.get(0).setPlayersNumber("1");
		
		
		//Ovde prosledi poruku o eventu kad ga napravis da se vidi sta je poslednje uneto
		setStatusBar("Igrac1 je napravio faul.");
		
		//Ovako faule prikazujes
		// 1.index je koji je redni broj igraca
		// 2.index koji je faul po redu
		// ako skupi 5 zoves faulOut();
		fauls_home.getPlayer(0).faul(0);
		fauls_home.getPlayer(2).faulOut();
		
		//Ovako radis sa semaforom
		setHomeTeam("Los Angeles Lakers");
		setAwayTeam("Boston Celtics");
		setResult("48 : 39");
		setTime("9 : 12");
		
		// Kada budes slao imena sortiraj ih po brojevima
		// i onda indexiraj igrace po tome posto ne mozes da nadjes igraca po imenu ni po broju posle
		// samo po rednom broju u listi igraca
		ArrayList<String> names = new ArrayList<String>();
		names.add("Balenovic M.");
		names.add("Bilic L.");
		
		setHomeTeamPlayers(names);
		
		full_court.court.canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			
			int column = (int) e.getX();
        	int row = (int) e.getY();
			
			if (((MouseEvent) e).getButton().equals(MouseButton.SECONDARY)){
				System.out.println(column + " " + row + " promasio");
			}else {
	        	System.out.println(column + " " + row + " dao");
			}
	    });
		
		scoreBoard.time_button.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event){
				if (scoreBoard.time_button.getText().equals("PLAY")){
					//Ovo je neka tvoja funkcija
					//Controller.timeStarted();
					scoreBoard.time_button.setText("PAUSE");
				}else{
					// Ovo je neka tvoja funkcija
					//Controller.timePaused();
					scoreBoard.time_button.setText("PLAY");
				}
			}
		});
		
		check_box_statistics.selectedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, 
					Boolean oldValue, Boolean newValue) {
				statistics.setVisible(newValue);
				statistics.setManaged(newValue);
			}
		});
		
		
		for (RadialMenu item : full_court.players_on_court){
			for (Object o : (item).subItems){
				((RadialMenuItem) o).setOnMousePressed(new EventHandler<MouseEvent>(){
					@Override
					public void handle(final MouseEvent e){
						
						//Ovde stavis da ti zove metodu u controlleru
						// posaljes mu (RadialMenuItem)o.text; - to je radnja
						// 		item.centerText().getPlayersNumber(); - broj na dresu
						System.out.println(((RadialMenuItem)o).text);

						System.out.println("Player No: " + item.getPlayersNumber());
						
						if (((RadialMenuItem)o).text.contains("SHOT"))
							full_court.changePane();
					}
				});
			}
			for (RadialMenuItem o : item.items){
				o.setOnMousePressed(new EventHandler<MouseEvent>(){
					@Override
					public void handle(final MouseEvent e){

						System.out.println(((RadialMenuItem)o).text);
						System.out.println("Player No: " + item.getPlayersNumber());
					}
				});
			}
		}
	}
	
	public void setStatusBar(String message){
		statusBar.setText(message);
	}
	
	public void setHomeTeam(String teamName){
		scoreBoard.home_team.setText(teamName);
	}
	
	public void setAwayTeam(String teamName){
		scoreBoard.away_team.setText(teamName);
	}
	
	public void setResult(String result){
		scoreBoard.result.setText(result);
	}
	public void setTime(String time){
		scoreBoard.time.setText(time);
	}
	
	public void setHomeTeamPlayers(ArrayList<String> names){
		for (int i = 0; i < names.size(); i++){
			fauls_home.getPlayer(i).setText(names.get(i));
		}
	}
	public void setAwayTeamPlayers(ArrayList<String> names){
		for (int i = 0; i < names.size(); i++){
			fauls_away.getPlayer(i).setText(names.get(i));
		}
	}
}
