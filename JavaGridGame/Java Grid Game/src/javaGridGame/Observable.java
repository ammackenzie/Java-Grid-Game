package javaGridGame;

import java.io.Serializable;

public interface Observable extends Serializable {
	//standard obervable methods
	public void addObserver(Enemy input);
	
	public void removeObserver(Enemy input);
	
	public void notifyObservers();

}//end of interface
