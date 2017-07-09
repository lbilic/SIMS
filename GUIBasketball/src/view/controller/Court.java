package view.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class Court extends AnchorPane {
	
	@FXML Canvas canvas;
	
	public Court() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/court.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            initialize();
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
	private void initialize(){
			
			canvas.widthProperty().bind(this.widthProperty());
	    	canvas.heightProperty().bind(this.heightProperty());
	}
}
