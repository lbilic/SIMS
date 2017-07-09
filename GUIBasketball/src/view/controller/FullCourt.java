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
	@FXML RadialMenu player1_h;
	@FXML RadialMenu player2_h;
	@FXML RadialMenu player3_h;
	@FXML RadialMenu player4_h;
	@FXML RadialMenu player5_h;
	
	@FXML RadialMenu player1_a;
	@FXML RadialMenu player2_a;
	@FXML RadialMenu player3_a;
	@FXML RadialMenu player4_a;
	@FXML RadialMenu player5_a;
	
	List<RadialMenu> players_on_court_home;
	List<RadialMenu> players_on_court_away;
	
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
            
            players_on_court_away = new ArrayList<RadialMenu>();
            players_on_court_away.add(player1_a);
            players_on_court_away.add(player2_a);
            players_on_court_away.add(player3_a);
            players_on_court_away.add(player4_a);
            players_on_court_away.add(player5_a);
            
            players_on_court_home = new ArrayList<RadialMenu>();
            players_on_court_home.add(player1_h);
            players_on_court_home.add(player2_h);
            players_on_court_home.add(player3_h);
            players_on_court_home.add(player4_h);
            players_on_court_home.add(player5_h);
            
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
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
