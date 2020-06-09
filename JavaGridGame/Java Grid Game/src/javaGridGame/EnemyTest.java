package javaGridGame;


import junit.framework.TestCase;

public class EnemyTest extends TestCase {

	public void testEnemyInitialisation() {
		//test enemyFactory correctly initialises all enemy types
		EnemyFactory factory = new EnemyFactory();
		boolean actual = true;
		
		boolean donkey = factory.getEnemy("donkey") instanceof Donkey;
		boolean parrot = factory.getEnemy("parrot") instanceof Parrot;
		boolean snake = factory.getEnemy("snake") instanceof Snake;
		
		assertTrue(actual == (donkey && parrot && snake));
		
	}
	
	//test individual string return methods in all Enemy types
	public void testDonkeyToStringMethods() {
		Donkey testDonkey = new Donkey();
		String actual = testDonkey.toFullString() + testDonkey.toInitial();
		String expected = "DonkeyD";
		
		assertTrue(actual.equals(expected));
	}
	
	public void testParrotToStringMethods() {
		Parrot testParrot = new Parrot();
		String actual = testParrot.toFullString() + testParrot.toInitial();
		String expected = "ParrotP";
		
		assertTrue(actual.equals(expected));
	}
	
	public void testSnakeToStringMethods() {
		Snake testSnake = new Snake();
		String actual = testSnake.toFullString() + testSnake.toInitial();
		String expected = "SnakeS";
		
		assertTrue(actual.equals(expected));
	}
	
	

}//end of class
