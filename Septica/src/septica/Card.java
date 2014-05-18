package septica;

import java.util.Map;

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
	
	public Card( String newSymbol, Integer newValue ) {
		switch(newSymbol) {
			case "IR":
				symbol = 0;
				break;
			case "IN":
				symbol = 1;
				break;
			case "R":
				symbol = 2;
				break;
			case "T":
				symbol = 3;
				break;
			default:
				symbol = 0;
				break;
		}
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
	}
	
	public String toString() {
		String str = new String();
		str += value.toString();
		switch (symbol) {
			case 0:
				str += "IR";
				break;
			case 1:
				str += "IN";
				break;
			case 2:
				str += "R";
				break;
			case 3:
				str += "T";
				break;
		}
		return str;
	}
}
