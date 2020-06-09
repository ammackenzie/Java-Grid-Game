package javaGridGame;

import java.util.Arrays;

import junit.framework.TestCase;

public class ObserverTest extends TestCase {

	//test add and remove observer methods
	public void testAddObserver() {
		Ogre testOgre = new Ogre();
		
		int actual1 = testOgre.getEnemies().size(); //check size of observers list 
		int expected1 = 0;//should be 0 to start with
		
		Donkey testDonkey = new Donkey(); //create new enemy
		
		testOgre.addObserver(testDonkey); //add to list
		
		int actual2 = testOgre.getEnemies().size();
		int expected2 = 1; //sizwe should now be 1
		
		assertTrue((actual1 == expected1) && (actual2 == expected2)); //test before and after size
	}
	
	public void testRemoveObserver() {
		//create test Ogre and Enemy
		Ogre testOgre = new Ogre();	
		Donkey testDonkey = new Donkey();
		
		testOgre.addObserver(testDonkey);
		
		int actual1 = testOgre.getEnemies().size();
		int expected1 = 1;
		
		testOgre.removeObserver(testDonkey);
		
		int actual2 = testOgre.getEnemies().size();
		int expected2 = 0;
		
		assertTrue((actual1 == expected1) && (actual2 == expected2)); //same as above but before and after removing observer
	}
	
	public void testNotifyObserver() {
		Ogre testOgre = new Ogre();	
		Donkey testDonkey = new Donkey();
		
		testOgre.addObserver(testDonkey);
		
		int[] actual1 = testDonkey.getOgreLocation();
		int[] expected1 = new int[2]; //undefined int array of size 2 as declared in class
		
		int[] testLocation = {1,1};
		
		//set test location for Ogre
		testOgre.setLocation(testLocation);
		
		//update observers
		testOgre.notifyObservers();
		
		//check to see if observer received update
		int[] actual2 = testDonkey.getOgreLocation();
		int[] expected2 = testLocation;
		
		assertTrue((Arrays.equals(actual1, expected1)) && (Arrays.equals(actual2, expected2)));
	}//end of tests
	
}//end of class
