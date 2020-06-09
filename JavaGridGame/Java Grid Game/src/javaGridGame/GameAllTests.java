package javaGridGame;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GameAllTests extends TestCase{
	
	//full test suite class
	
	public static Test suite() {
		TestSuite suite = new TestSuite(GameAllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(SwampTest.class);
		suite.addTestSuite(EnemyTest.class); //also contains test for Factory pattern implementation
		suite.addTestSuite(OgreTest.class); //also tests use of strategy pattern
		suite.addTestSuite(FightTest.class); //also tests use of strategy pattern
		suite.addTestSuite(ObserverTest.class);
		suite.addTestSuite(MovementTest.class);
		//$JUnit-END$
		return suite;
	}//end of test suite

}//end of class
