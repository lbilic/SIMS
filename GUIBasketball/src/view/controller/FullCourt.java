package view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import view.controller.radialMenu.RadialMenu;

public class FullCourt extends StackPane {
	@FXML Court court;
	@FXML RadialMenu player1;
	@FXML RadialMenu player2;
	@FXML RadialMenu player3;
	@FXML RadialMenu player4;
	@FXML RadialMenu player5;
	
	List<RadialMenu> players_on_court;
	
	public FullCourt() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/fullCourt.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();

            court.getStyleClass().add("teren");
            court.canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            	
            	changePane();
            });
            
            players_on_court = new ArrayList<RadialMenu>();
            players_on_court.add(player1);
            players_on_court.add(player2);
            players_on_court.add(player3);
            players_on_court.add(player4);
            players_on_court.add(player5);
            
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
	@FXML
	public void changePane(){
		
		changeTop();
	}
	
	private void changeTop() {
        ObservableList<Node> childs = this.getChildren();
 
        if (childs.size() > 1) {
            //
            Node topNode = childs.get(childs.size()-1);
            topNode.toBack();
        }
    }
}
