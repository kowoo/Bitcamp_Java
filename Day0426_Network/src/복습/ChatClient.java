package 복습;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("192.168.0.55", 5000);
			
			Thread sender = new Thread(new Sender(socket));
			Thread receiver = new Thread(new Receiver(socket));
			
			sender.start();
			receiver.start();
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
