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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainWindow.fxml"));
        Parent root = loader.load();
        MainController mc = MainController.getInstance();
        scene = new Scene(root);
        scene.getStylesheets().add("view/resources/style.css");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
    	launch(args);
    }

}
