package org.mochito.mochito_core;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;



public class DiceTest {

	Dice theDice;

	@Test
	public void rollReturnsAValue() {
		theDice = new Dice(new Random());
		for (int i = 0; i < 100; i++) {
			int result = theDice.roll();
			assertTrue(result >= 1);
			assertTrue(result <= 6);
		}
	}

	@Test(expected = RuntimeException.class)
	public void identifyBadValuesGreaterThanNumberOfFaces() {
		Random random = mock(Random.class);
		when(random.nextInt(6)).thenReturn(60);
		 	theDice = new Dice(random);
		 	theDice.roll();
	}

	@Test(expected = RuntimeException.class)
	public void identifyBadValuesLesserThanOne() {
		Random random = mock(Random.class);
		when(random.nextInt(6)).thenReturn(-60);
		theDice = new Dice(random);
		theDice.roll();
	}
}