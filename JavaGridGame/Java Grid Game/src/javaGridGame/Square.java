package javaGridGame;

import java.io.Serializable;
import java.util.Arrays;

public class Square implements Serializable {

	private int[] coordinates = new int[2];
	
	public Square(int row, int column) {
		setCoordinates(row, column); //sets individual coordinates based on row and column count passed down from Row class
	}

	public void setCoordinates(int row, int column) {
		this.coordinates[0] = row;
		this.coordinates[1] = column;
	}
	
	public int[] getCoordinates() {
		return this.coordinates;
	}
	
}//end of class
