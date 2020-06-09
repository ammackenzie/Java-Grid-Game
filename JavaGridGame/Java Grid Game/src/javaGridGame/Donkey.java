package javaGridGame;

import java.io.Serializable;

public class Donkey extends Enemy implements Serializable  {

	@Override
	public String toInitial() {
		return "D";
	}

	@Override
	public String toFullString() {
		return "Donkey";
	}

}
