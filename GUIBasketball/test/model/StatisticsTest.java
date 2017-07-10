package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.events.Event;
import model.events.OnePtShot;
import model.events.ThreePtShot;
import model.events.TwoPtShot;

public class StatisticsTest {
	static ArrayList<Event> events;
	static Player p;
	static Player p2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p = new Player("Marko", 23);
		p2 = new Player("Marko", 23);
		events = new ArrayList<Event>();
		
		events.add(new TwoPtShot(p, "dao", 0,0,TeamEnum.HOME));
		events.add(new TwoPtShot(p, "nije dao", 0,0,TeamEnum.HOME));
		events.add(new ThreePtShot(p, "dao", 0,0,TeamEnum.HOME));
		events.add(new OnePtShot(p, "dao", 0,0,TeamEnum.HOME));
		events.add(new OnePtShot(p, "nije dao", 0,0,TeamEnum.HOME));
		events.add(new ThreePtShot(p2, "dao", 0,0,TeamEnum.AWAY));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		Stat s = Statistics.getStats(events, p);
		assertEquals(6, s.getPoints());
	}
	
	@Test
	public void test2() {
		Stat s = Statistics.getStats(events, p);
		assertEquals(100 * 2 / 3, s.getFg_percentage(), 0.0001);
	}

}
