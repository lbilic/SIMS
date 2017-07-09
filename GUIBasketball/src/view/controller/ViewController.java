package view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import view.controller.radialMenu.RadialMenu;
import view.controller.radialMenu.RadialMenuItem;

public class ViewController implements Initializable {

	@FXML Fauls fauls_home;
	@FXML Fauls fauls_away;
	
	@FXML CheckBox check_box_statistics;
	@FXML BorderPane statistics;
	
	@FXML FullCourt full_court;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//Ovako setujes broj na dugmetu
		//imas i getPlayersNumber koja ti vraca String koji broj igrac nosi
		//full_court.players_on_court ti je arrayList dugmadi na terenu
		full_court.players_on_court.get(0).setPlayersNumber("1");
		
		//Ovako faule prikazujes
		// 1.index je koji je redni broj igraca
		// 2.index koji je faul po redu
		// ako skupi 5 zoves faulOut();
		fauls_home.getPlayer(0).faul(0);
		fauls_home.getPlayer(2).faulOut();
		
		check_box_statistics.selectedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, 
					Boolean oldValue, Boolean newValue) {
				statistics.setVisible(!newValue);
				statistics.setManaged(!newValue);
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
}
