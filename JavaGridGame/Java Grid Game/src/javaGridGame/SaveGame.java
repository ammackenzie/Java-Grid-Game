package javaGridGame;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.TreeMap;


public class SaveGame {
	
	public Game savedGame = new Game();
	
	public Game loadedGame = new Game();
	
	private final String FILE_NAME = "gameSaveData.ser";
	
	
	public void serialize() {
		try{
			FileOutputStream out = new FileOutputStream(this.FILE_NAME);
			ObjectOutputStream objOut = new ObjectOutputStream(out);


			objOut.writeObject(this.savedGame);
			objOut.close();

		} catch(IOException e) {
			e.printStackTrace();
		}
	} //serialises current savedGame instance

	public void deserialize() {
		try {
			FileInputStream in = new FileInputStream(this.FILE_NAME);
			ObjectInputStream objIn = new ObjectInputStream(in);

			this.loadedGame = (Game) objIn.readObject();

			objIn.close();

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}  catch(IOException e) {
			e.printStackTrace();
		}
	}//loads current stored game into loadedGame variable

}//end of class
