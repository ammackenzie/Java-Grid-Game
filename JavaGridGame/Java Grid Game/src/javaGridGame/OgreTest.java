package javaGridGame;

import junit.framework.TestCase;

public class OgreTest extends TestCase{
	
	public void testOgreBehaviourChange() {
		
		Ogre testOgre = new Ogre();
		testOgre.makeGrumpy();
		boolean actual1 = testOgre.isGrumpy();
		boolean expected1 = true;
		
		testOgre.calmDown();
		boolean actual2 = testOgre.isGrumpy();
		boolean expected2 = false;
		assertTrue((actual1 == expected1) && (actual2 == expected2)); //test to see if behaviour is changed as expected
	}

} //end of class
