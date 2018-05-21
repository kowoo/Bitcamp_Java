package chatBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class receive implements Runnable {
	private Socket socket;
	
	public receive(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		BufferedReader reader;
		String msg;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				msg = reader.readLine();
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
