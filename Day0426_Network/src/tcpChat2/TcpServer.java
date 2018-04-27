package tcpChat2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpServer {
	public static void main(String[] args) {
		List<Socket> socketList = new ArrayList<Socket>();
		//얘가 해야할일
		//두 개의 클라이언트로 부터 각각 메시지를 받으면 다른 클라이언트로 전달
		//연결 요청 수락  : ServerSocket	
		Socket socket1 = null;
		Socket socket2 = null;
			
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			//연결 수락의 결과로 socket이 생성됨 , 2개의 클라이언트로 부터 요청을 받음

			socket1 = serverSocket.accept();
			socket2 = serverSocket.accept();
			
			//클라이언트 1로부터 메시지를 받아서 2로 전달하는 쓰레드
			Thread client1 = new Thread(new ServerThread(socket1, socket2));
			Thread client2 = new Thread(new ServerThread(socket2, socket1));
			
			client1.start();
			client2.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			







	}
}
