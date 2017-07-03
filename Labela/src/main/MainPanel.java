package main;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class MainPanel extends StackPane {
	@FXML Court court;
	@FXML Button button;
	
	public MainPanel() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPanel.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();

            court.getStyleClass().add("teren");
            court.canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            	
            	changePane();
            });
            
            
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
