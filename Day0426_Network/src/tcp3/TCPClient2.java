package tcp3;

import java.io.IOException;
import java.net.Socket;

public class TCPClient2 {
	public static void main(String[] args) {
		//소켓부터 만들어내야 한다, 요청을 받고 수락한 뒤에
		//sender, receiver 하나씩 실행
		
		try {
			//요청을 받고 나서 소켓을 얻어오기 위해 변수 선언.
			Socket socket = new Socket("192.168.0.55", 5000);
			
			//요청 수락을 위해 서버소켓 생성
//			ServerSocket serverSocket = new ServerSocket(5000);
//			socket = serverSocket.accept(); // 요청 수락.
			
			Thread sender = new Thread(new Sender(socket));
			Thread receiver = new Thread(new Receiver(socket));
			
			sender.start();
			receiver.start();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
