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

public class Client implements Runnable {

	public int id;
	InetAddress address;
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	String toReceive;
	List<ObserverO> observers;
	public boolean running = true;
	public int c;

	Client(int i) {
		id = i;

		observers = new ArrayList<ObserverO>();

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
		if (!code.equalsIgnoreCase("TOALL")) {
			for (ObserverO x : observers)
				if (x != null) {
					x.update(t);
				}
		} else {
			for (ObserverO x : observers) {
				System.out.println(i+" "+"IDENTITY:"+x.getIdentity());
				if ( (x != null) && (x.getIdentity().equalsIgnoreCase("TOALL"))) {
					x.update(t);
				}
				i++;
			}
		}
	}

	public void addObserver(ObserverO o) {
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
		case "ok":
			System.out.println(splited[0]);
			notifyAllO(mesaj.substring(3, mesaj.length()), "");
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
