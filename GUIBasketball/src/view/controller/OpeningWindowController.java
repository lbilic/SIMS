package view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class OpeningWindowController implements Initializable {
	@FXML Button new_match_button;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		new_match_button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				MainController.getInstance().newMatch();
			}
			
		});
	}
	
	
}
