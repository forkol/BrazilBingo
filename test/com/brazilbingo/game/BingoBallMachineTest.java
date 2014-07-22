package com.brazilbingo.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class BingoBallMachineTest {

//	@Test
//	public void testBingoBallMachine() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetBall() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsEmpty() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void verifyCompleteList()
	{
		BingoBallMachine aMachine = new BingoBallMachine();
		int i = 1;
		int sum = 0;
		int bingoMachineSum = 0;
		
		while (!aMachine.isEmpty())
		{
			bingoMachineSum += aMachine.getBall();
			sum = sum + i;
			i++;
			
		}
		
		assertTrue(sum == bingoMachineSum);
		
	}

}
