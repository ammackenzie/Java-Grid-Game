package javaGridGame;

import java.io.Serializable;

public interface Observer extends Serializable  {
	public void update(int[] newLocation);
}//end of interface
