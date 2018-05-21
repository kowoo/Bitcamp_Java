package chatBasic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String[] args) {
		ServerSocket serverSocket;
		manager man = new manager();
		try {
			serverSocket = new ServerSocket(7777);
			while(true) {
				//socket = new Socket();
				Socket socket = serverSocket.accept();
				man.add(socket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
