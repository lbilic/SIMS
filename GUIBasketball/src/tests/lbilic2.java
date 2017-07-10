package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Match;
import model.Player;
import model.events.OnePtShot;

public class lbilic2 {

	@Test
	public void testAddEvent() throws InterruptedException {
		Match m = new Match();
		OnePtShot s = new OnePtShot(new Player("Pera", 23), "dao", 150, 150);
		assertEquals(m.getEvents().size(), 0);
		m.addEvent(s);
		assertEquals(m.getEvents().size(), 1);
		
	}

}
