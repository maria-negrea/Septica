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
	
	private char stringToSymbol( String symbol ) {
		char s;
		switch(symbol) {
			case "IR":
				s = 0;
				break;
			case "IN":
				s = 1;
				break;
			case "R":
				s = 2;
				break;
			case "T":
				s = 3;
				break;
			default:
				s = 0;
				break;
		}
		return s;
	}
	
	public Card( String newSymbol, Integer newValue ) {
		symbol = stringToSymbol(newSymbol);
		value = newValue;
	}
	
	public Card(String card) {
		String[] str = card.split("-");
		value = Integer.parseInt(str[0]);
		symbol = stringToSymbol(str[1]);
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
