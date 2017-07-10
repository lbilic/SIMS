package model;

import controller.MainController;
import model.events.Event;

public class Creating extends State{
	Match match;
	
	public Creating(Match match){
		this.match = match;
	}

	@Override
	public void entry() {	}

	@Override
	public void exit() {	}

	@Override
	public void timePaused() {	}

	@Override
	public void timeStarted() {	
		//Ovo zovemo samo zato sto nemamo unosenje podataka od strane korisnika
		//nego su uneseni rucno
		match.changeState(new Running(match));
	}

	@Override
	public void startMatch() {	
		if (allDataInserted())
			match.changeState(new Running(match));
		else{
			MainController.getInstance().dataRequiredMessage();
		}
	}

	@Override
	public void finishMatch() {	}
	
	private boolean allDataInserted(){
		
		return true;
	}

	@Override
	public void timeRanOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventOccurred( Event event ) {
		match.addEvent(event);
	}
}
