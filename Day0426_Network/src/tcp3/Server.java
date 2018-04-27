package tcp3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		Socket socket1 = null;
		Socket socket2 = null;
		
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			socket1 = serverSocket.accept();
			socket2 = serverSocket.accept();
			
			Thread receiver1 = new Thread(new Receiver(socket1));
			Thread receiver2 = new Thread(new Receiver(socket2));
			Thread sender1 = new Thread(new Sender(socket1));
			Thread sender2 = new Thread(new Sender(socket2));
			
			receiver1.start();
			receiver2.start();
			sender1.start();
			sender2.start();
			
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		
		
	}
}
