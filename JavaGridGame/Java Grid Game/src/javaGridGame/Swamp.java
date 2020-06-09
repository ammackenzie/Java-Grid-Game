package javaGridGame;

import java.io.Serializable;
import java.util.LinkedList;

public class Swamp implements Serializable {
	private LinkedList<Row> theSwamp = new LinkedList<Row>();
	
	public Swamp() {}
	
	public Swamp(int input) {
		int rows = input;
		int columns = input;
		for(int loop = 0; loop < rows; loop++){
			Row newRow = new Row(loop, columns); //takes single input int and turns it into a row and column count for Row class to pass to Square class
			this.theSwamp.add(newRow);
		}
	}//end of constructor
	
	public LinkedList<Row> getTheSwamp() {
		return this.theSwamp;
	}
	
	public int getSize() {
		return this.theSwamp.getFirst().getTheRow().size(); //return size of one row in swamp
	}
	
}//end of class
