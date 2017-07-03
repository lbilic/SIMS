package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;

public class MainController implements Initializable {
	@FXML MainPanel panela;
	@FXML Controller home;
	@FXML Controller away;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		home.getStylesheets().add("root2");
		panela.button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent e) {
				
			}
		});
		
	}
	
}
