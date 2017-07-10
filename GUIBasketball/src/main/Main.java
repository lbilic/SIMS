package main;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.controller.ViewController;

public class Main extends Application {
	Scene scene;

	@Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/openingWindow.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);
        scene.getStylesheets().add("view/resources/style.css");

        stage.setScene(scene);
        stage.show();
        
        MainController.getInstance().setOpeningStage(stage);
    }

    public static void main(String[] args) {
    	launch(args);
    }

}
