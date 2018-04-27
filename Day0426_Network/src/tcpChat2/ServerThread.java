package tcpChat2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread implements Runnable {
	List<Socket> socketList = new ArrayList<Socket>();
	Socket socket1 = null;
	Socket socket2 = null;

	public ServerThread(Socket socket1, Socket socket2) {
		this.socket1 = socket1;
		this.socket2 = socket2;
	}

	public ServerThread(Socket socket) {
		socketList.add(socket);
	}

	public void run() {
		//두 개의 클라이언트로부터 메시지를 받으면 다른 클라이언트에게 전달하는 역할.
		//메시지 송수신을 위한 소켓 2개 필요함!
		//클라이언트로 부터 들어오는 메시지를 다른 메시지로 전달하는 작업이 필요함.
		BufferedReader reader;
		BufferedWriter writer;

		try {

			for(Socket socket: socketList) {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				//소켓 1로부터 들어오는 메시지를 읽는 반복문
				while(true) {				
					String msg = reader.readLine();
					// 소켓 2로 메시지를 내보냄
					writer.write(msg);
					writer.newLine();
					writer.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
