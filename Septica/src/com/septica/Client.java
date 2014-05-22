package com.septica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import designPatterns.ObserverSeptica;

public class Client implements Runnable {

	public int id;
	InetAddress address;
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	String toReceive;
	List<ObserverSeptica> observers;
	public boolean running = true;
	public int c;

	public Client(int i) {
		id = i;

		observers = new ArrayList<ObserverSeptica>();

		try {
			address = InetAddress.getByName(null);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			socket = new Socket(address, 7235);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(socket);
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void notifyAllO(String t, String code) {
		int i=1;
		String[] split = code.split(" ");
		int k = 1;
		for (ObserverSeptica x : observers) {
			if (x.getId().equals("playerCard"))
				x.update(split[k]);
			if(x.getId().equals("cardDown"));
				x.update(split[k]);
			k++;

		}

	}

	public void addObserver(ObserverSeptica o) {
		observers.add(o);
	}

	public void removeObserver(ObserverO o) {
		observers.remove(o);
	}

	public void send(String toSend) {
		
		out.println(toSend);
	
	}

	public void process(String mesaj) {
		String[] splited = mesaj.split(" ");
		switch (splited[0]) {
		case "currentCards":
			 notifyAllO("playerCard", mesaj);
			 System.out.println("process playerCard");
			break;
		case "nok":
			System.out.println(splited[0]);
			notifyAllO("nok", "");
			break;
		case "TOALL":
			System.out.println(splited[0]);
			notifyAllO(mesaj, "TOALL");
			break;
		default:
			notifyAllO(mesaj, "");
			break;
		}

	}

	@Override
	public void run() {

		while (running) {

			try {

				if ((toReceive = in.readLine()) != null) {
					System.out.println("client received:"
							+ toReceive.toString());
					if (toReceive.equalsIgnoreCase("close")) {
						Thread t = new Thread(this);
						running = false;
						socket.close();
						t.interrupt();
						System.out.println("Attention:Server Down");
					}
					else {
					process(toReceive.toString());
					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
