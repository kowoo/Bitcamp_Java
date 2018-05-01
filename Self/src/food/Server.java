package food;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//0426_tcp3 참고
public class Server {
	//소켓 연결을 반복해서 받기 (계-속)
		public static void main(String[] args) {
			ServerSocket serverSocket;
			ServerManager manager = new ServerManager();
			
			//소켓 연결을 받는 부분.
			try {
				serverSocket = new ServerSocket(5000);
				while(true) {
					System.out.println("요청 대기 중");
					Socket socket = serverSocket.accept();
					//서버 매니저에게 소켓을 넘겨줘야한다.
					manager.add(socket);
					
				}




			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
