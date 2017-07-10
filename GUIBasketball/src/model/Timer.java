package model;
import java.util.*;

import controller.MainController;

public class Timer {
	
	private java.util.Timer timer;
	private int time;
	private boolean ticking;
	
	public Timer() {
		time = 0;
		ticking = true;
	}
	
	public void start() {
		ticking = true;
	}
	
	public void pause() {
		ticking = false;
	}
	
	public void updateTime() {
		if(ticking)
			time++;
	}
	
	public int getTime() {
		return time;
	}
}
