package view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class InserWindowController implements Initializable {

	@FXML Button ok_button;
	@FXML Button cancel_button;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ok_button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				MainController.getInstance().startMatch();
			}
			
		});
		
		cancel_button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				MainController.getInstance().cancelMatch();
			}
			
		});
	}

}
