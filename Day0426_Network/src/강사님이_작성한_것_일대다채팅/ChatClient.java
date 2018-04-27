package 강사님이_작성한_것_일대다채팅;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	public static void main(String[] args) {
		//소켓부터 만들어 내야 한다 : 요청을 해서 
		//sender, recevier 하나씩 실행
		try {
			Socket socket
			 = new Socket("192.168.0.55", 5000);
			
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
