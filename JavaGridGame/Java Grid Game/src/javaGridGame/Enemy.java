package javaGridGame;

import java.io.Serializable;

public abstract class Enemy extends Creature implements Observer, Serializable {
	final int[] STARTINGLOCATION = {0,0};
	private int[] ogreLocation = new int[2]; //holds note of Ogre location as part of Observer pattern
	
	public Enemy() {
		this.fightBehaviour = new EnemyFighter();
		setLocation(this.STARTINGLOCATION); //set to intance of EnemyFighter on initialisation 
	}

	@Override
	public void update(int[] newLocation) { // part of observer pattern
		this.ogreLocation = newLocation;
	}
	
	public int[] getOgreLocation() {
		return this.ogreLocation;
	}
	
	//force implementation of representative methods in all Enemy types
	public abstract String toInitial();
	
	public abstract String toFullString();

}//end of class
