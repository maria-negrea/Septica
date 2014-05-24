package designPatterns;

public interface ObserverSeptica {

	public void setId(String id);

	public String getId();

	void update(String mesaj, int state);

}
