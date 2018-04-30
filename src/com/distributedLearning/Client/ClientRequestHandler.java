package com.distributedLearning.Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientRequestHandler implements Runnable {

	Socket clientSocket;
	public ClientRequestHandler(Socket socket) {
		this.clientSocket = socket;
	}
	
	@Override
	public void run() {
		DataInputStream in=null;
		try {
			in = new DataInputStream(clientSocket.getInputStream()); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();	
		}
		try {
			String line;
			for(;;) {
				line = in.readUTF();
				if(line==null) {
					break;
				}else {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
