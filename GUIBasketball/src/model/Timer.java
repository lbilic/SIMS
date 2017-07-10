package model;

import controller.TimerController;

public class Timer {

	private float time;
	private TimerController controller;
	
	public Timer() {
		time = 0;
		controller = new TimerController(this);
	}
	
	public void start() {
		controller.start();
	}
	
	public void pause() {
		controller.pause();
	}
	
	public void updateTime() {
		time += 0.1;
	}
	
	public int getTime() {
		return (int)time;
	}
}
