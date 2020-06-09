package javaGridGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import junit.framework.TestCase;

public class MovementTest extends TestCase {
	
	private int[] testLocation = new int[2];
	
	public void testGetAvailableSquares() {
		//a single test method that relies on all Movement Behaviour methods working as expected - considered comprehensive
		
		int[] testLocation = {0,0}; //chose example that requires populateImpossibleSquares to work as expected
		setLocation(testLocation);
		Swamp testSwamp = new Swamp(4);
		
		//manually add expected coordinates to an arraylist
		ArrayList<int[]> expected = new ArrayList<int[]>();
		
		expected.add(new int[] {0,1});
		expected.add(new int[] {1,0});
		expected.add(new int[] {1,1});
		
		ArrayList<int[]> actual = getAvailableSquares(testSwamp);
		
		//compare each entry
		boolean output = true;
		for(int x = 0; x < actual.size(); x++) {
			if(Arrays.equals(actual.get(x), expected.get(x))){
				//do nothing and output remains true
			} else {
				output = false; //one mismatch creates false output
			}
		}
		
		//check actual contains all expected elements and is of the same size
		assertTrue(actual.size() == expected.size() && output); 
	}//end of testGetAvailableSquares
	
	
	
	//full methods from Creature class to use during test
	
	public ArrayList<int[]> getAvailableSquares(Swamp board) {
		ArrayList<int[]> possibleMoves = populateAvailableSquares();
		ArrayList<int[]> impossibleMoves = populateImpossibleSquares(possibleMoves, board);
		
		possibleMoves.removeAll(impossibleMoves);
		return possibleMoves;
	}


	public void move(Swamp board) {
		Random rand = new Random();
		int[] chosenMove = getAvailableSquares(board).get(rand.nextInt(getAvailableSquares(board).size())); //MAYBE SIMPLIFY THIS TO ONE INSTANCE OF GAS METHOD = VARIABLE
		setLocation(chosenMove);
	}


	public ArrayList<int[]> populateAvailableSquares() {
		ArrayList<int[]> output = new ArrayList<int[]>();
		for(int x = (getLocation()[0] -1); x <= (getLocation()[0] + 1); x++) {
			for(int y = (getLocation()[1] - 1); y <= (getLocation()[1] + 1); y++) {
				int[] temp = {x , y};
				output.add(temp);
			}
		}
		
		return output;
	}


	public ArrayList<int[]> populateImpossibleSquares(ArrayList<int[]> input, Swamp board) {
		ArrayList<int[]> output = new ArrayList<int[]>();
		for(int[] temp : input) {
			if(temp[0] < 0 || temp[0] > (board.getSize() - 1)) { //if first coordinate in location is less than 0 or outwith size of swamp
				output.add(temp);
			}
			if(temp[1] < 0 || temp[1] > (board.getSize() - 1)) { //if second coordinate in location is less than 0 or outwith size of swamp
				output.add(temp);
			}
			if(Arrays.equals(temp, getLocation())) { //remove current location as option
				output.add(temp);
			}
		}
		return output;
	}

	
	public void setLocation(int[] input) {
		this.testLocation = input;
	}
	
	public int[] getLocation() {
		return this.testLocation;
	}
	//end of populated movement behaviour methods
	
}//end of class
