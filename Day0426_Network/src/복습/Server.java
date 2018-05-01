package 복습;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket;
		ServerManager manager = new ServerManager();

		try {
			serverSocket = new ServerSocket(5000);
			while(true) {
				System.out.println("요청 대기 중");
				Socket socket = serverSocket.accept();
				manager.add(socket);
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
}
