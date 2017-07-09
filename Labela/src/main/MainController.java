package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {
	
	@FXML MainPanel panela;
	@FXML Controller home;
	@FXML Controller away;
	@FXML BorderPane statistics;
	@FXML CheckBox statisticCheckBox;
	@FXML Label statusBar;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		statisticCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, 
					Boolean oldValue, Boolean newValue) {
				statistics.setVisible(!newValue);
				statistics.setManaged(!newValue);
			}
		});
		
	}
	
}
