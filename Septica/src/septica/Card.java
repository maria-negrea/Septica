package septica;

public class Card {
	private char symbol;
	private Integer value;
	
	public Card() {
		symbol = 0;
		value = 0;
	}
	
	
	public Card( char newSymbol, Integer newValue ) {
		symbol = newSymbol;
		value = newValue;
	}


	public char getSymbol() {
		return symbol;
	}


	public void setSymbol( char symbol ) {
		this.symbol = symbol;
	}


	public Integer getValue() {
		return value;
	}


	public void setValue( int value ) {
		this.value = value;
		System.out.println("sssd");
	}
	
}
