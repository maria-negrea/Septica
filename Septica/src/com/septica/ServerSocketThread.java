package com.septica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class ServerSocketThread extends Thread {

	protected Socket socket;
	public String toReceive;
	public PrintWriter out;
	public BufferedReader in;
	public Server ser;
	public List<ObserverO> observers;
	public ObserverO oneO;
	public String MyName;
	public Integer MyId;
	public String PlayedCard;
	public boolean Continue;
	boolean running =true;
	
	public String getMyName() {
		return MyName;
	}

	public void setMyId(Integer myId) {
		MyId = myId;
	}
	
	public Integer getMyId() {
		return MyId;
	}
	
	public String getPlayedCard() {
		return PlayedCard;
	}
	
	public boolean getContinue() {
		return Continue;
	}
	
	public void setMyName(String myName) {
		MyName = myName;
	}

	void notifyAllO(String t) {
		if (t != null) {
			//oneO.update(t);
		}
	}

/*	void addObserver(ObserverO toAdd) {
		observers.add(toAdd);
	}

	void removeObserver(ObserverO toRemove) {
		observers.remove(toRemove);
	}
*/
	public ServerSocketThread(Socket cSocket, Server s) {
		observers = new ArrayList<ObserverO>();
		this.socket = cSocket;
		this.PlayedCard = null;
		ser = s;
		//oneO = sstO;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())), true);
			
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (IOException e) {
			return;
		}
	}

	public void send(String message) {
		// System.out.println(out);
		if (running) {
			out.println(message);
		this.notifyAllO("(out) notified " + message);
		}
	}

	public void run() {

		while (!socket.isClosed() && running) {

		//	this.PlayedCard = null;
			this.Continue = false;
			try {
				
				if ((toReceive = in.readLine()) != null) {
					System.out.println(toReceive);
					if (toReceive.equals("close")) {
						socket.close();
						running = false;
					}
					else if (toReceive.contains("chat")){
						this.notifyAllO("(in) notified " + toReceive);
					}
					else if (toReceive.equals("continue")) {
						this.Continue = true;
					}
					else if (toReceive.equals("end")) {
						this.Continue = false;
					}
					else {
						this.PlayedCard = toReceive;
						
						//PlayerCard sa fie un string care implementeaza OBserver interface
						//
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	
	public String makeMessage(String[] arr) {
		StringBuilder m = new StringBuilder();
		for (int i=2;i<arr.length;i++) {
			m.append(arr[i]);
			m.append(" ");
		}
		return m.toString();
	}


}