package javaGridGame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public abstract class Creature implements MovementBehaviour, Serializable  {

	protected FightBehaviour fightBehaviour;
	
	
	private int[] location = new int[2];


	public int performFight() {
		return(this.fightBehaviour.fight()); //activate fight behaviour instance
	}
	
	public FightBehaviour getFightBehaviour() {
		return this.fightBehaviour;
	}

	public void setFightBehaviour(FightBehaviour fightBehaviour) {
		this.fightBehaviour = fightBehaviour;
	}
	
	
	//start of MovementBehaviour methods
	@Override
	public void move(Swamp board) {
		Random rand = new Random();
		int[] chosenMove = getAvailableSquares(board).get(rand.nextInt(getAvailableSquares(board).size())); //get random square coordinate from list of suitable squares
		setLocation(chosenMove); //update location 
	}
	
	public ArrayList<int[]> getAvailableSquares(Swamp board) {
		ArrayList<int[]> possibleMoves = populateAvailableSquares(); //returns all mathmatically possible moves
		ArrayList<int[]> impossibleMoves = populateImpossibleSquares(possibleMoves, board); //returns all contextually impossible moves
		
		possibleMoves.removeAll(impossibleMoves); // result is all legal moves
		
		return possibleMoves;
	}

	@Override
	public ArrayList<int[]> populateAvailableSquares() {
		ArrayList<int[]> output = new ArrayList<int[]>();
		for(int x = (getLocation()[0] -1); x <= (getLocation()[0] + 1); x++) {
			for(int y = (getLocation()[1] - 1); y <= (getLocation()[1] + 1); y++) {
				int[] temp = {x , y};
				output.add(temp);
			}
		}
		return output; //returns list of all mathmatically possible moves ignoring context
	}

	@Override
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
	
	//end of MovementBehaviour methods
	
	@Override
	public int[] getLocation() {
		return this.location;
	}
	
	@Override
	public void setLocation(int[] input) {
		this.location = input;
	}


}//end of class
