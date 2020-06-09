package javaGridGame;

import java.util.Arrays;

import junit.framework.TestCase;


public class SwampTest extends TestCase{
	
	public void testSwampConstruction() {
		Swamp testSwamp = new Swamp(4);
		
		//test correct number of rows
		int actual = 0;
		for(Row temp : testSwamp.getTheSwamp()) {
			actual ++;
		}
		int expected = 4;
		assertTrue(actual == expected);
	}
	
	public void testSwampRowConstruction() {
		Swamp testSwamp = new Swamp(4);
		
		//test correct number of squares in each row
		int actual = 0;
		for(Square temp : testSwamp.getTheSwamp().getFirst().getTheRow()) {
			actual++;
		}
		int expected = 4;
		assertTrue(actual == expected);
	}
	
	public void testCoordinates() {
		//test that squares are initialised with correct coordinates
		Swamp testSwamp = new Swamp(4);
		//test first square
		int[] actual1 = testSwamp.getTheSwamp().getFirst().getTheRow().getFirst().getCoordinates();
		int[] expected1 = {0,0};
		
		//test last square
		int[] actual2 = testSwamp.getTheSwamp().getLast().getTheRow().getLast().getCoordinates();
		int[] expected2 = {3,3};
		
		assertTrue(Arrays.equals(actual1, expected1) && Arrays.equals(actual2, expected2));//check both coordinates are as expected
		
	}//end of tests
	
}//end of class
