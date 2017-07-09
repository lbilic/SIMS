package view.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Player extends HBox {
    @FXML private TextField textField;
    @FXML private Label lbl1;
    @FXML private Label lbl2;
    @FXML private Label lbl3;
    @FXML private Label lbl4;
    @FXML private Label lbl5;
    
    ArrayList<Label> labels = new ArrayList<Label>();
    int count = 0;

    public Player() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/player.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            
            textField.setFocusTraversable(false);
            
            labels.add(lbl1);
            labels.add(lbl2);
            labels.add(lbl3);
            labels.add(lbl4);
            labels.add(lbl5);
            
            //lbl1.getStyleClass().add("labelica");
            lbl2.getStyleClass().add("labelica");
            lbl3.getStyleClass().add("labelica");
            lbl4.getStyleClass().add("labelica");
            lbl5.getStyleClass().add("labelica");
            
            //lbl1.getStyleClass().add("root2");
            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public void faul(int index){
    	labels.get(index).setStyle("-fx-background-color: yellow; ");
    }
    
    public void faulOut(){
    	lbl1.setStyle("-fx-background-color: red;");
		lbl2.setStyle("-fx-background-color: red;");
		lbl3.setStyle("-fx-background-color: red;");
		lbl4.setStyle("-fx-background-color: red;");
		lbl5.setStyle("-fx-background-color: red;");
    }
    
    public void setText(String text){
    	textField.setText(text);
    }
    
    public String getText(){
    	return textField.getText();
    }
}
