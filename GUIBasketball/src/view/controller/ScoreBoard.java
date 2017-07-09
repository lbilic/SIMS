package view.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScoreBoard extends VBox {
	
	@FXML Label home_team;
	@FXML Label away_team;
	@FXML Label result;
	@FXML Button time_button;
	@FXML Label time;

	public ScoreBoard() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/scoreBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
