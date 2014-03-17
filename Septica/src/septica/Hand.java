package septica;

public class Hand {
	private Integer value;
	private Integer score;
	private Integer index;
	
	public Hand( Integer newValue, Integer newScore, Integer newIndex ) {
		value = newValue;
		score = newScore;
		index = newIndex;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
