package javaGridGame;

import java.io.Serializable;

public class OgreGrumpy implements FightBehaviour, Serializable {

	public int fightPower = 3;
	@Override
	public int fight() {
		// TODO Auto-generated method stub
		return this.fightPower;
	}

}
