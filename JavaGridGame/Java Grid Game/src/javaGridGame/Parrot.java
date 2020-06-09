package javaGridGame;

import java.io.Serializable;

public class Parrot extends Enemy implements Serializable  {

	@Override
	public String toInitial() {
		return "P";
	}

	@Override
	public String toFullString() {
		return "Parrot";
	}

}
