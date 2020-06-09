package javaGridGame;

import java.io.Serializable;
import java.util.ArrayList;

public class Ogre extends Creature implements Observable, Serializable {
	
	private boolean grumpy; //represents current mood

	private ArrayList<Enemy> enemies = new ArrayList<Enemy>(); 
	
	public Ogre() {
		calmDown(); //on initialisation sets grumpy to false and behaviour to passive
	}
	
	public boolean isGrumpy() {
		return this.grumpy;
	}

	public void setGrumpy(boolean grumpy) {
		this.grumpy = grumpy;
	}
	
	public void makeGrumpy() {
		setGrumpy(true);
		this.fightBehaviour = new OgreGrumpy();
	}
	
	public void calmDown() {
		setGrumpy(false);
		this.fightBehaviour = new OgrePassive();
	}

	//observer methods
	@Override
	public void addObserver(Enemy input) {
		enemies.add(input);
	}

	@Override
	public void notifyObservers() {
		for(Enemy temp : this.enemies) {
			temp.update(getLocation());
		}
		
	}
	
	@Override
	public void removeObserver(Enemy input) {
		this.enemies.remove(input);
		
	}
	
	public ArrayList<Enemy> getEnemies(){
		return this.enemies;
	}
}//end of class
