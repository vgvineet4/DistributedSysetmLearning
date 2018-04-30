package com.distributedLearning.ServerMapping;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.distributedLearning.Client.ClientRequestHandler;
import com.distributedLearning.Utils.PropertyLoader;

public class Server {

	static PropertyLoader prop = new PropertyLoader();
	
	static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
	
	public static void main(String[] args) throws IOException {
	ServerSocket serSocket = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
	while(true) {
		Socket clientSocket = serSocket.accept();
		ClientRequestHandler clientHandler = new ClientRequestHandler(clientSocket);
		threadPool.execute(clientHandler);
	}
	}
}
