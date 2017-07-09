package view.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Fauls extends AnchorPane {
	
	@FXML Player igrac1;
	@FXML Player igrac2;
	@FXML Player igrac3;
	@FXML Player igrac4;
	@FXML Player igrac5;
	@FXML Player igrac6;
	@FXML Player igrac7;
	@FXML Player igrac8;
	@FXML Player igrac9;
	@FXML Player igrac10;
	@FXML Player igrac11;
	@FXML Player igrac12;
	
	private ArrayList<Player> players;
	
	public Fauls() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/fauls.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            players = new ArrayList<Player>();
            
            players.add(igrac1);
            players.add(igrac2);
            players.add(igrac3);
            players.add(igrac4);
            players.add(igrac5);
            players.add(igrac6);
            players.add(igrac7);
            players.add(igrac8);
            players.add(igrac9);
            players.add(igrac10);
            players.add(igrac11);
            players.add(igrac12);
            //igrac1.getStyleClass().add("root2");
            //igrac2.getStyleClass().add("root2");
            //igrac3.getStyleClass().add("root2");
            //igrac4.getStyleClass().add("root2");
            //igrac5.getStyleClass().add("root2");
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
	public Player getPlayer(int index){
		return players.get(index);
	}
}
