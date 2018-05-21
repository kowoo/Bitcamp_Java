package chatBasic;

import java.io.IOException;
import java.net.Socket;

public class client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.55",7777);
			Thread sender = new Thread(new send(socket));
			Thread receiver = new Thread(new receive(socket));
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
