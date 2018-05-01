package guiChat2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//소켓 연결을 반복해서 받기 (계-속)
	public static void main(String[] args) {
		ServerSocket serverSocket;
		ServerManager manager = new ServerManager();
		
		//소켓 연결을 받는 부분.
		try {
			serverSocket = new ServerSocket(8000);
			while(true) {
				System.out.println("요청 대기 중");
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트에 연결 되었습니다.");
				//서버 매니저에게 소켓을 넘겨줘야한다.
				manager.add(socket);
				
			}




		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
