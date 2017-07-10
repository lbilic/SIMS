package controller;

import java.util.TimerTask;

import javafx.application.Platform;
import model.Timer;

public class TimerController {
	
	private java.util.Timer timer = new java.util.Timer();;
	private Timer t;
	
	public TimerController(Timer t){
		this.t = t;
	}
	
	public void start(){
		timer = new java.util.Timer();
	    timer.schedule(new TimerTask(){
	        public void run(){
	        	Platform.runLater(() ->{
	        		updateTime();
	        	});
	        }
	    },0,  100 );
	}
	
	public void pause(){
		timer.cancel();
	}
	
	private void updateTime(){
		t.updateTime();
		MainController.getInstance().updateTime(t);
	}
}
