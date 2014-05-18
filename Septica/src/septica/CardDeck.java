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
		for (int i= 0; i < 32; )
		{
			Integer index = randomGenerator.nextInt( cards.size() );
			if (cards.get(index) != null)
			{
				Card c = cards.get(index);
				cards.set(index, null);
				newDeck.add(c);
				i++;
			}
		}
		 
		cards = newDeck;
	}
	
	public void deal( Player p ) {
		Card c = cards.get( cards.size() - 1 );
		cards.remove( cards.size() - 1 );
		p.drawCard(c);
	}
	
	public Integer cut( Player p ) {
		Card c;
		Integer count = 0;
		do
		{
			c = cards.get( cards.size() - 1 );
			cards.remove( cards.size() - 1 );
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
