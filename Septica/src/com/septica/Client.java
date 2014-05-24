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
			{
				if(t.equals("playerCard"))
				{
					x.update(split[k],0);
				}
				if(t.equals("play")||t.equals("continue"))
				{
					x.update("nimic",1);
				}
			}
			else
			{
				if(t.equals("cardDown"))
				{
					String[] tokens=split[1].split("[:]");
					if(x.getId()=="cardDownTop")
					{
						if(tokens[0].equals("-2")||tokens[0].equals("2"))
						{
							x.update(tokens[1], 3);
						}
					}							
					
					if(x.getId()=="cardDownLeft")
					{
						if(tokens[0].equals("-3")||tokens[0].equals("1"))
						{
							x.update(tokens[1], 3);
						}
					}						
					
					if(x.getId()=="cardDownRight")
					{
						if(tokens[0].equals("3")||tokens[0].equals("-1"))
						{
							x.update(tokens[1], 3);
						}
					}
						
					
					if(x.getId()=="cardDownCurrent"&&tokens[0].equals("0"))
					{
						x.update(tokens[1], 3);
					}
					
				}
			}
			
			
				
			/*if(x.getId().equals("cardDownTop"))
			{
				String[] tokens=split[k].split("[:]");
				if(t.equals("cardDown)"))
				{
					x.update(code, 3);
				}
				else
				{
					x.update("nimic",2);
				}
			}
			
			if(x.getId().equals("cardDownLeft"))
			{
				if(t.equals("cardDown)"))
				{
					x.update(code, 3);
				}
				else
				{
					x.update("nimic",2);
				}
			}
			
			if(x.getId().equals("cardDownRight"))
			{
				if(t.equals("cardDown)"))
				{
					x.update(code, 3);
				}
				else
				{
					x.update("nimic",2);
				}
			}
			
			if(x.getId().equals("cardDownCurrent"))
			{
				if(t.equals("cardDown)"))
				{
					x.update(code, 3);
				}
				else
				{
					x.update("nimic",2);
				}
			}
			*/
				
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
			break;
		case "play":
			notifyAllO("play", mesaj);
			break;
		case "continue":
			System.out.println(splited[0]);
			notifyAllO("continue", mesaj);
			break;
		case "cardDown":
			System.out.println(splited[0]);
			notifyAllO("cardDown", mesaj);
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
