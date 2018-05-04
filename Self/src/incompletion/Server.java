package incompletion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket;
		ServerManager manager = new ServerManager();
		
		//소켓 연결을 받는 부분.
		try {
			serverSocket = new ServerSocket(5555);
			while(true) {
				System.out.println("요청 대기 중");
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트에 연결 되었습니다.");
				manager.add(socket);				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
