package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Match;
import model.Running;

public class lbilic1 {

	@Test
	public void testChangeState() {
		Match m = new Match();
		m.changeState(new Running(m));
		assertEquals(m.getState(), "class model.Running");
	}

}
