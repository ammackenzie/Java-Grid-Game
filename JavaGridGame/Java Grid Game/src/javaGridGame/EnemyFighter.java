package javaGridGame;

import java.io.Serializable;

public class EnemyFighter implements FightBehaviour, Serializable {

	public int fightPower = -1; //value of Enemy fight power
	@Override
	public int fight() {
		return this.fightPower;
	}

}
