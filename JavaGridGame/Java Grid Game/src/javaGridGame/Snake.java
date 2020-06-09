package javaGridGame;

import java.io.Serializable;

public class Snake extends Enemy implements Serializable  {

	@Override
	public String toInitial() {
		return "S";
	}

	@Override
	public String toFullString() {
		return "Snake";
	}

}
