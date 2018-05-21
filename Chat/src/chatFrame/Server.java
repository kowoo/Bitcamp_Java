package chatFrame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket;
		Manager mgr = new Manager();
		try {
			serverSocket = new ServerSocket(8000);
			while(true) {
				System.out.println("연결 대기");
				Socket socket = serverSocket.accept();
				System.out.println("연결 완료");
				mgr.add(socket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
