package septica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {
	private List <Card> cards;
	
	public CardDeck() {
		cards = new ArrayList <Card> ();
		for ( char s = 0; s < 4; s++ )
			for ( Integer i = 7; i < 15; i ++ )
			{
				Card c = new Card(s, i);
				cards.add(c);
			}
	}
	
	public Integer size() {
		return cards.size();
	}
	
	public void shuffle() {
		ArrayList <Card> newDeck = new ArrayList <Card> ();
		
		Random randomGenerator = new Random();
		while ( cards.size() != 0 )
		{
			Integer index = randomGenerator.nextInt( cards.size() );
			Card c = cards.get(index);
			cards.remove(index);
			newDeck.add(c);
		}
		 
		cards = newDeck;
	}
	
	public void deal( Player p ) {
		Card c = cards.get( cards.size() );
		cards.remove( cards.size() );
		p.drawCard(c);
	}
	
	public Integer cut( Player p ) {
		Card c;
		Integer count = 0;
		do
		{
			c = cards.get( cards.size() );
			cards.remove( cards.size() );
			if ( c.getValue() == 7 ) {
				p.drawCard(c);
				count ++;
			}
			else
				cards.add(0, c);
		}while ( c.getValue() == 7 || c.getValue() == 11 );
		return count;
	} 
}
