package septica;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List <Card> hand;
	private Integer score;
	private String name;
	
	public Player( String newName ) {
		hand = new ArrayList <Card> ();
		name = newName;
		score = 0;
	}
	
	public Integer getScore() {
		return score;
	}

	public void setScore( Integer score ) {
		this.score = score;
	}
	
	public void addToScore( Integer score ) {
		this.score += score;
	}
	
	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Integer numberOfCards() {
		return hand.size();
	}
	
	public void drawCard( Card c ) {
		hand.add(c);
	}
	
	public void playCard( Card c ) {
		hand.remove(c);
	}
	
	public boolean findCard( Integer value ) {
		for ( Card c : hand )
			if ( c.getValue() == value )
				return true;
		return false;
	}
}
