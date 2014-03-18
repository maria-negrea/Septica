package septica;

public class Server {

	private static Server instance;
	
	private Server()
	{
		
	}
	
	public synchronized static Server getInstance()
	{
		if(instance==null)
			instance=new Server();
		return instance;
	}
}
