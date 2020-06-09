package javaGridGame;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;


public class Game implements Serializable {
	private int swampSize = 4; //default is standard size of 4
	public Swamp newSwamp = new Swamp(getSwampSize()); //set to use default swamp size
	Ogre theOgre = new Ogre();
	private int enemyTypes = 3; //total number of types of enemy
	private boolean ogreLives = true;

	//for use in GUI
	private String notification = "";
	private String mood = "";
	private int turnCount = 0;
	private boolean error = false;

	public Game() {
		setOgreStart(); //on initialisation set random start for Ogre
	}

	public void nextTurn() {
		if(this.ogreLives && !error) { //check is Ogre is alive and no resize error has been triggered
			this.turnCount++; //increment turn count
			this.notification = ""; //reset notification
			try {
				moveAll(); //move all active Creatures
			} catch(IllegalArgumentException e) { //can occur if user reduced swamp size too drastically between turns
				this.notification = "Error, you cut the Ogre out of his Swamp! Select New Game"; //alert user to error
				System.out.println(e.toString());
				setError(true);
			}
			enemySpawnCheck(); //trigger for enemy spawn
			this.theOgre.notifyObservers(); //update all observers
			fightLogic(); //check for fight trigger and resolve
		}	
		//else do nothing
	}

	//***Ogre specific methods***
	public void setOgreStart() {
		Random rand = new Random();
		LinkedList<Square> allSquares = new LinkedList<Square>();
		//save all available squares in swamp in a LinkedList
		for(Row tempRow : this.newSwamp.getTheSwamp()) {
			for(Square tempSquare : tempRow.getTheRow()) {
				allSquares.add(tempSquare);
			}
		}
		allSquares.removeFirst();//remove top left (0,0) square as an option

		//get a random num based on size of linkedList
		int[] chosenMove = allSquares.get(rand.nextInt(allSquares.size())).getCoordinates(); 

		this.theOgre.setLocation(chosenMove);//set Ogre location based on random choice
		setMood("Passive..."); //default starting mood
	}

	public void switchMood() { //change Ogre mood
		if(this.theOgre.isGrumpy()) {
			this.theOgre.calmDown();
			setMood("Passive...");
		} else {
			this.theOgre.makeGrumpy();
			setMood("Grumpy!");
		}
	}
	//***end of Ogre specififc methods***

	//***Fight logic methods***
	public void fightLogic() {
		if(fightTime()) {
			if(resolveFight()) {
				//Ogre has won
				ogreWon();
			} else{
				//Ogre has died
				this.ogreLives = false;
				ogreDied();
			};
		}
	}

	public boolean fightTime() {
		boolean output = false;
		for(Enemy temp : this.theOgre.getEnemies()) {
			if(Arrays.equals(temp.getLocation(), temp.getOgreLocation())){
				output = true;
			} 
		}
		return output;
	}

	public boolean resolveFight() {
		int result = 0;
		result += this.theOgre.performFight(); //get current Ogre fight strength
		for(Enemy temp : this.theOgre.getEnemies()) {
			if(Arrays.equals(temp.getLocation(), temp.getOgreLocation())){
				result += temp.performFight(); //substract enemy fight strength
			} 
		}
		if(result > 0) {
			//Ogre wins
			return true;
		} else {
			//Ogre loses
			return false;
		}
	}

	public void ogreDied() {
		String output = "The ogre was killed at location ";
		output += coordinatesToString(this.theOgre.getLocation());
		output += " by " + enemiesAtLocation() + "on turn " + getTurnCount();
		this.notification = output;
	}

	public void ogreWon() {
		String output = "The ogre killed " + enemiesAtLocation();
		output += "at location " + coordinatesToString(this.theOgre.getLocation()) + " on turn " + getTurnCount();
		this.notification = output;
		removeDefeatedEnemies();
	}

	public void removeDefeatedEnemies() {
		//removes defeated enemies from list of observers post successful fight
		ArrayList<Enemy> toRemove = new ArrayList<Enemy>(); 
		for(Enemy temp : this.theOgre.getEnemies()) {
			if(Arrays.equals(temp.getLocation(), temp.getOgreLocation())) {
				toRemove.add(temp); //add to a collection first in case of multiple (if ogre is grumpy)
			}
		}
		this.theOgre.getEnemies().removeAll(toRemove); //remove from list of observers
	}
	//***end of Fight logic methods***


	//***Enemy spawn methods***
	public void enemySpawnCheck() {
		if(newSpawn()) { //one in three chance
			setUpEnemy(pickNewEnemy()); //logic to initialise and establish a new Enemy in game
		}
	}

	public boolean newSpawn() {
		int trigger = 2; //one in three chance result will be 2
		int chanceToSpawnInt = 3;
		boolean output = false;
		Random rand = new Random();
		if(rand.nextInt(chanceToSpawnInt) == trigger) { 
			output = true;
		}
		return output;
	}

	public Enemy pickNewEnemy() {
		//uses factory pattern to generate and return a new enemy
		EnemyFactory factory = new EnemyFactory();
		Random rand = new Random();
		int choice = rand.nextInt(this.enemyTypes);
		if(choice == 0) { 
			return factory.getEnemy("donkey");
		}
		if(choice == 1) {
			return factory.getEnemy("parrot");
		}
		if(choice == 2) {
			return factory.getEnemy("snake");
		}

		return null;
	}

	public void setUpEnemy(Enemy input) { 
		this.theOgre.addObserver(input); //add to list of observers
	}
	//***end of Enemy spawn methods***


	//**Core next turn and board state representation methods***
	public void moveAll() {
		for(Enemy temp : this.theOgre.getEnemies()) {
			temp.move(this.newSwamp); //move registered observers
		} 
		this.theOgre.move(this.newSwamp);; //move Ogre next
	}

	public String boardToString() {
		String output = "";
		output += columnCountToString();
		int counter = 0;
		for(Row tempRow : this.newSwamp.getTheSwamp()) {
			output += " " + counter + " ";
			for(Square tempSquare : tempRow.getTheRow()) {
				output += returnState(tempSquare);
				output += " "; //spacing for alignment
			}
			output += "\n\n";
			counter++;
		}
		return output; //returns full string representation of board state
	}

	public String columnCountToString() {
		String output = "";
		for(int x = 0; x < newSwamp.getSize(); x++) {
			output += "      " + x + "";
		}
		output += "\n";
		return output; //used to number columns in string board state
	}

	public String returnState(Square input) {
		String output = "";
		if(checkIfSquareOccupied(input)) {
			if(ogreHere(input)) {
				output += " (0) "; //symbol for Ogre - Ogre overrides other chars at same square
			} else {
				output += enemyToString(input);
			}
		} else {
			output += "  \uD83D\uDD33  "; //unicode character for board square
		}
		return output; //returns string representation os a single square
	}

	public String coordinatesToString(int[] input) {
		String output = "";
		output += input[0] + ",";
		output += input[1];
		return output;  //return string representation of coordinates
	}

	public Enemy findCreature(Square input) { //only triggered if sole enemy occupies input square
		Enemy output = null;
		int[] tempLocation= input.getCoordinates();

		for(Enemy temp : this.theOgre.getEnemies()) {
			if(Arrays.equals(temp.getLocation(), tempLocation)) {
				output = temp;
			}
		}
		return output; //returns the enemy type
	}

	public boolean ogreHere(Square input) {
		if(Arrays.equals(input.getCoordinates(), this.theOgre.getLocation())){
			return true;
		} else {
			return false;
		} //simple method returns boolean determining if Ogre is in input square
	}

	public String enemyToString(Square input) {
		int soleOccupier = 1;
		String output = "";
		if(numOfOccupiers(input) == soleOccupier) {
			Enemy tempEnemy = findCreature(input);
			output += "  " + tempEnemy.toInitial() + "  ";
		} else {
			output += "  M  "; //symbol for multiple
		}
		return output; //return character representation of Enemy/s
	}

	public String enemiesAtLocation() {
		String output = "";
		for(Enemy temp : this.theOgre.getEnemies()) {
			if(Arrays.equals(temp.getLocation(), temp.getOgreLocation())){
				output +=  temp.toFullString() + " ";
			} 
		}
		return output; //returns full string representation of enemy/s at Ogre's location
	}

	public boolean checkIfSquareOccupied(Square input) { 
		//check if an enemy or an Ogre is here
		boolean result = false;
		for(Enemy temp : this.theOgre.getEnemies()) {
			if((Arrays.equals(temp.getLocation(), input.getCoordinates()))){
				result = true; //enemy in square
			} 
		}
		if((Arrays.equals(this.theOgre.getLocation(), input.getCoordinates()))){
			result = true; //ogre in square
		} 
		return result;
	}

	public int numOfOccupiers(Square input) {
		int result = 0;
		for(Enemy temp : this.theOgre.getEnemies()) {
			if(Arrays.equals(temp.getLocation(), input.getCoordinates())){
				result++;
			} 
		}
		return result;
	}
	//***End of core methods***


	public void resetGame() {
		//reset all variables to create fresh game state
		ArrayList<Enemy> toRemove = new ArrayList<Enemy>();
		for(Enemy temp : this.theOgre.getEnemies()) {
			toRemove.add(temp);
		}
		this.theOgre.getEnemies().removeAll(toRemove);

		this.ogreLives = true;
		setTurnCount(0);
		this.notification = "";
		setSwampSize(4);
		this.newSwamp = new Swamp(getSwampSize());
		setError(false);
		setOgreStart(); //reset a new random start for Ogre
	}


	//***Getters and setters***
	public void resizeSwamp() {
		this.newSwamp = new Swamp(getSwampSize());
	}

	public String getMood() {
		return this.mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public void setTurnCount(int count) {
		this.turnCount = count;
	}

	public int getTurnCount() {
		return this.turnCount;
	}

	public int getSwampSize() {
		return this.swampSize;
	}

	public void setSwampSize(int swampSize) {
		this.swampSize = swampSize;
	}

	public void incrementSwampSize() {
		this.swampSize++;
		resizeSwamp();
	}

	public void decrementSwampSize() {
		if(getSwampSize() < 3) { //minimum size to function is 2;
			//do nothing
		} else {
			this.swampSize--;
			resizeSwamp();
		}
	}
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getNotification() {
		return this.notification;
	}
	//***end of Getters and Setters***


}//end of class
