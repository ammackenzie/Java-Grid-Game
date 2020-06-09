package javaGridGame;

import java.io.Serializable;
import java.util.LinkedList;

public class Row implements Serializable {
	private LinkedList<Square> theRow = new LinkedList<Square>();
	
	public Row(int rowCount, int columns) {
		for(int loop = 0; loop < columns; loop++) {
			Square newSquare = new Square(rowCount, loop); //passes down row and column count for squares to intialise correct coordinates
			this.theRow.add(newSquare);
		}
	}//end of constructor
	
	public LinkedList<Square> getTheRow() {
		return this.theRow;
	}
	
}//end of class
