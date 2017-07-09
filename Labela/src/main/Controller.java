package main;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Controller extends AnchorPane {
	
	@FXML Igrac igrac1;
	@FXML Igrac igrac2;
	@FXML Igrac igrac3;
	@FXML Igrac igrac4;
	@FXML Igrac igrac5;
	@FXML Igrac igrac6;
	@FXML Igrac igrac7;
	@FXML Igrac igrac8;
	@FXML Igrac igrac9;
	@FXML Igrac igrac10;
	@FXML Igrac igrac11;
	@FXML Igrac igrac12;
	
	int count = 0;
	
	ArrayList<Igrac> igraci = new ArrayList<Igrac>();
	
	public Controller() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("labela.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            
            igraci.add(igrac1);
            igraci.add(igrac2);
            igraci.add(igrac3);
            igraci.add(igrac4);
            igraci.add(igrac5);
            igraci.add(igrac6);
            igraci.add(igrac7);
            igraci.add(igrac8);
            igraci.add(igrac9);
            igraci.add(igrac10);
            igraci.add(igrac11);
            igraci.add(igrac12);
            //igrac1.getStyleClass().add("root2");
            //igrac2.getStyleClass().add("root2");
            //igrac3.getStyleClass().add("root2");
            //igrac4.getStyleClass().add("root2");
            //igrac5.getStyleClass().add("root2");
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
	public Igrac getIgrac(int index){
		return igraci.get(index);
	}
}
