package com.septica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JTextArea;

import septica.*;

public class Server implements Runnable {

	private static Server instance;
	ServerSocket s;
	Socket socketClient;
	ObserverO sstO;
	public JTextArea whereToDisplay;
	public List<ServerSocketThread> sockets;
	public List<ObserverO> observers;
	public static Hashtable<String, String> users;
	public String usersForClients;
	public Game currentGame;
	private boolean continueHand;
	private int firstPlayer;

	void notifyAllO(String t) {
		if (observers != null)
			for (ObserverO x : observers)
				x.update(t);
	}

	public void setSSTO(ObserverO o) {
		sstO = o;
	}

	void addObserver(ObserverO toAdd) {
		observers.add(toAdd);
	}

	void removeObserver(ObserverO toRemove) {
		observers.remove(toRemove);
	}

	/*
	 * private Server(ObserverO o) { sockets = new
	 * ArrayList<ServerSocketThread>(); users = new Hashtable<String,String>();
	 * try { readUsers("fis.txt"); } catch (IOException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } this.makeString();
	 * observers = new ArrayList<ObserverO>(); observers.add(o); setSSTO(o); try
	 * { s = new ServerSocket(7235); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * public synchronized static Server getInstance(ObserverO o) {
	 * if(instance==null) instance=new Server(o); return instance; }
	 */

	public Server() {

		sockets = new ArrayList<ServerSocketThread>();
		users = new Hashtable<String, String>();

		this.makeString();

		try {
			s = new ServerSocket(7235);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		System.out.println("Connection accepted: " + s.toString());

		Integer count = 0;
		currentGame = new Game();
		continueHand = false;
		firstPlayer = 0;

		while (!s.isClosed() && count < 4) {
			try {
				System.out.println(s.isClosed());
				socketClient = (!s.isClosed()) ? s.accept() : null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ServerSocketThread t;
			if (socketClient != null) {
				t = new ServerSocketThread(socketClient, this);
				t.setMyId(count);

				currentGame.addPlayer(count);

				count++;

				System.out.println("client:" + t.toString());
				sockets.add(t);
				t.start();
			}
		}

	}

	public void close() throws IOException {

		for (ServerSocketThread t : sockets) {
			t.send("close");
			t.socket.close();
		}
		s.close();
	}

	public void SendTo(String mesaj, Integer id) {
		if (sockets != null) {
			for (ServerSocketThread t : sockets) {
				if (t.getMyId() == id) {
					t.send(mesaj);
				}
			}
		}

	}

	public static void writeUsers(String s) throws FileNotFoundException,
			UnsupportedEncodingException {

		PrintWriter writer = new PrintWriter(s, "UTF-8");
		Set<Entry<String, String>> set = users.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			writer.println(entry.getKey() + " " + entry.getValue());
		}

		writer.close();

	}

	public void makeString() {
		Set<Entry<String, String>> set = users.entrySet();
		Iterator it = set.iterator();
		StringBuilder q = new StringBuilder();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			q.append(entry.getKey() + " ");
		}
		usersForClients = q.toString();

	}

	public static void readUsers(String s) throws IOException {
		String line = null;
		String[] split;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(s));

			while ((line = reader.readLine()) != null) {
				split = line.split(" ");
				users.put(split[0], split[1]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SendToEverybody(String k) {

		if (sockets != null) {
			for (ServerSocketThread t : sockets) {
				t.send(k);
			}
		}
	}

	public void playGame() {
		currentGame.startGame();
		
		while (!currentGame.endOfGame()) {
			
			for (Integer i = 0; i < 4; i++) {
				SendTo("currentCards " + currentGame.getCurrentHand(i), i);
			}

			List<String> cards = new ArrayList<>();
			int currentPlayer = firstPlayer;
			for (int it = 0; it < 4; it++) {
				ServerSocketThread sst = sockets.get(currentPlayer);
				SendTo("play", currentPlayer);
				
				boolean whilee = true;
				String card;
				do {
					card = sst.getPlayedCard();
					if (card != null) {
						cards.add(card);
						whilee = false;
					}
					
					try {
						sst.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (whilee);
				

				for (Integer i = 0; i < 4; i++) {
					SendTo("cardDown " + (i - currentPlayer) + ":" + card, i);
				}

				currentPlayer++;
				currentPlayer %= 4;
			}

			boolean canContinueHand = currentGame.playHand(
					cards.toArray(new String[cards.size()]), continueHand);
			continueHand = false;
			
			if (canContinueHand == true) {
				SendTo("continue", firstPlayer);

				ServerSocketThread sst = sockets.get(firstPlayer);
				continueHand = sst.getContinue();
				
				if (continueHand == false) {
					currentGame.winHand();
					firstPlayer = currentGame.getFirstPlayer();
				}
				
				try {
					sst.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				currentGame.winHand();
				firstPlayer = currentGame.getFirstPlayer();
			}
		}

		for (Integer i = 0; i < 4; i++) {
			SendTo(currentGame.getCurrentStatus(i), i);
		}
	}

}
