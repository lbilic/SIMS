package main;

import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private Group container;
    private RadialMenu radialMenu;

	@Override
	public void start(final Stage primaryStage) throws Exception {
		container = new Group();
		final Scene scene = new Scene(container);
		scene.setFill(Color.WHITE);
		//primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setWidth(450);
		primaryStage.setHeight(480);
		primaryStage.centerOnScreen();
		primaryStage.setTitle("Radial Menu Demo");
		primaryStage.show();

		final double itemInnerRadius = 60;
		final double itemRadius = 135;
		final double centerClosedRadius = 38;
		final double centerOpenedRadius = 50;
		final double subItemInnerRadius = 137;
		final double subItemRadius = 210;

		//final String[] menus = new String[] {"FAUL", "TURNOVER", "STEAL",
		//		"ASSIST", "REBOUND", "SHOT"};
		
		final String[] menus = new String[] {"STEAL", "ASSIST","SHOT", "REBOUND", 
				"TURNOVER", "FAUL"};
		
		final String[][] subMenus = {{},{},{"1 POINT", "2 POINT", "3 POINT"}, {"OFFENSIVE", "DEFENSIVE"},{},{}};

		radialMenu = new RadialMenu(menus, itemInnerRadius, itemRadius,
			centerClosedRadius, centerOpenedRadius, subMenus, subItemInnerRadius, subItemRadius);

		radialMenu.setTranslateX(200);
		radialMenu.setTranslateY(200);
		container.getChildren().addAll(radialMenu);
			
		
		for (Object o : radialMenu.items){
			((RadialMenuItem) o).setOnMousePressed(new EventHandler<MouseEvent>(){
				@Override
				public void handle(final MouseEvent e){
					List<Text> lista = null;
					try{
					lista = radialMenu.itemToTexts.get((RadialMenuItem)e.getSource());
					
					for (Text t : lista){
						System.out.println(t);
					}
					
					}catch(Exception ex){
						
					}
				}
			});
		}
		
		for (Object o : radialMenu.subItems){
			((RadialMenuItem) o).setOnMousePressed(new EventHandler<MouseEvent>(){
				@Override
				public void handle(final MouseEvent e){
					List<Text> lista = null;
					try{
					lista = radialMenu.itemToTexts.get((RadialMenuItem)e.getSource());
					
					for (Text t : lista){
						System.out.println(t);
					}
					
					}catch(Exception ex){
						
					}
				}
			});
		}
		
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

		    @Override
		    public void handle(final MouseEvent event) {
			if (event.isSecondaryButtonDown()) {
			    radialMenu.setTranslateX(event.getX());
			    radialMenu.setTranslateY(event.getY());
			}
		    }
		});
		
	}

}
