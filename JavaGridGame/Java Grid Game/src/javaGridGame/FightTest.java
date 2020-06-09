package javaGridGame;

import junit.framework.TestCase;

public class FightTest extends TestCase {
	
	public void testOgreFightReturn() {
		Ogre testOgre = new Ogre();
		int actual1 = testOgre.performFight();
		int expected1 = 2;
		
		testOgre.makeGrumpy();
		
		int actual2 = testOgre.performFight();
		int expected2 = 3;
		assertTrue((actual1 == expected1) && (actual2 == expected2)); //test both Ogre moods return expected fight power
	}
	
	public void testEnemeyFightReturn() {
		int expected = -1;
		
		Donkey testDonkey = new Donkey();
		int actual1 = testDonkey.performFight();
		
		
		Parrot testParrot = new Parrot();
		int actual2 = testParrot.performFight();
		
		Snake testSnake = new Snake();
		int actual3 = testSnake.performFight();
		
		assertTrue((actual1 == expected) && (actual2 == expected) && (actual3 == expected)); //test all Enemy types return expected fight power
		
	}

}//end of class
