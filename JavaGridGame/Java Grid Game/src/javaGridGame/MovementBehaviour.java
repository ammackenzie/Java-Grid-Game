package javaGridGame;

import java.io.Serializable;
import java.util.ArrayList;


public interface MovementBehaviour extends Serializable  {
	//Movement behaviour interface methods - implemented by Creature class
	
	public ArrayList<int[]> getAvailableSquares(Swamp board);
	
	public ArrayList<int[]> populateAvailableSquares();
	
	public ArrayList<int[]> populateImpossibleSquares(ArrayList<int[]> input, Swamp board);
	
	public void move(Swamp board); 
	
	public int[] getLocation();
	
	public void setLocation(int[] input);
}
