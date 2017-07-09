package model;

public class Timer {
	
	private int time;
	private boolean ticking;
	
	public Timer() {
		time = 0;
	}
	public void Pause() {
		ticking = false;
	}
	
	public void Resume() {
		ticking = true;
	}
}
