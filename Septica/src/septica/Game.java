package septica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {
	private CardDeck deck;
	private List <Player> players; 
	private Hand currentHand;
	
	public Game() {
		deck = new CardDeck();
		players = new ArrayList <Player>();
	}
	
	public void addPlayer( String name ) {
		Player p = new Player(name);
		players.add(p);
	}
	
	public void startGame() {
		deck.shuffle();
		Integer count = deck.cut( players.get(0) );
		
		for ( Integer i = 0; i < count; i ++ ) {
			Iterator <Player> it = players.iterator();
			it.next();
			while ( it.hasNext() )
				deck.deal( it.next() );
		}
				
		for ( ; count < 4; count ++ )
			dealCards();
	}
	
	public void dealCards() {
		if ( deck.size() > 0 )
			for ( Player p : players )
				deck.deal(p);
	}
	
	public boolean playHand( Card[] c, boolean continueHand ) {
		if ( continueHand == false )
			currentHand = new Hand( c[0].getValue(), 0, 0 );
		
		Integer value = currentHand.getValue();
		Integer score = currentHand.getScore();
		
		if ( value == 10 || value == 11 )
			score ++;
		
		Integer index = 0;
		players.get(0).playCard(c[0]);
		
		for ( Integer i = 1; i < c.length; i++ ) {
			Integer cardValue =  c[i].getValue();
			if ( cardValue == value || cardValue == 7 ) 
				index = i;
			if ( cardValue == 10 || cardValue == 11 )
				score ++;
			players.get(i).playCard(c[i]);
		}
		
		currentHand.setScore(score);
		currentHand.setIndex(index);
		
		return canContinue( players.get(0), value );
	}
	
	public boolean canContinue( Player p, Integer value ) {
		return p.findCard(value);
	}
		
	public void winHand() {
		Integer score = currentHand.getScore();
		Integer index = currentHand.getIndex();
		
		while ( index > 0 ) {
			players.add( players.remove(0) );
			index --;
		}
		
		players.get(0).addToScore(score);
		if ( players.size() == 4 )
			players.get(2).addToScore(score);
		
		for ( Integer i = players.get(0).numberOfCards(); i < 4; i++ )
			dealCards();
	}
	
	public boolean endOfGame() {
		if ( players.get(0).numberOfCards() == 0 )
			return true;
		return false;
	}
}
