package javaGridGame;

import java.io.Serializable;

public class OgrePassive implements FightBehaviour, Serializable {

	public int fightPower = 2;
	@Override
	public int fight() {
		return this.fightPower;
	}

}
