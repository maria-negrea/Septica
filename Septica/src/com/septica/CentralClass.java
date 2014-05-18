package com.septica;

public class CentralClass {
	public static void main(String [] args) {
		Server server = new Server();
		
		server.run();
		server.playGame();
	}
}
