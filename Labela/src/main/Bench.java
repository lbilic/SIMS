package main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class Bench extends VBox{

	
	public Bench() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bench.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            //initialize();
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
