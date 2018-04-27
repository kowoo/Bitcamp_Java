package 강사님이_작성한_것_일대다채팅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver implements Runnable {
	private Socket socket;
	
	public Receiver(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		//키보드로부터 입력을 받아서 소켓에 메시지 전달
		BufferedReader reader = null;
		String msg = null;
		
		//데이터를 소켓으로부터 읽어오기 위해서 스트림을 얻어옴
		
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {				
				msg = reader.readLine();
				System.out.println(msg);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("상대방이 연결을 종료했습니다.");
			//e.printStackTrace();
		} finally {
			
		}
		
	}
}
