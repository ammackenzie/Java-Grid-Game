package javaGridGame;

public class EnemyFactory {
	
	public Enemy getEnemy(String selection) { //factory for centralisation of Enemy production
		if(selection == null) {
			return null;
		}
		
        if("Donkey".equalsIgnoreCase(selection)){
            return new Donkey();
        } else if("Parrot".equalsIgnoreCase(selection)){
            return new Parrot();
        } else if("Snake".equalsIgnoreCase(selection)){
            return new Snake();
        } //return object instance based on string input
        
        return null;
	}

}
