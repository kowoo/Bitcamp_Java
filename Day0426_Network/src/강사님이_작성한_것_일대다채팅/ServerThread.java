package 강사님이_작성한_것_일대다채팅;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread implements Runnable {
	Socket socket1 = null;
	Socket socket2 = null;

	public ServerThread(Socket socket1, Socket socket2) {
		this.socket1 = socket1;
		this.socket2 = socket2;
	}

	public void run() {
		//두 개의 클라이언트로부터 메시지를 받으면 다른 클라이언트에게 전달하는 역할.
		//메시지 송수신을 위한 소켓 2개 필요함!
		//클라이언트로 부터 들어오는 메시지를 다른 메시지로 전달하는 작업이 필요함.

		BufferedReader reader;
		BufferedWriter writer;


		try {
			reader = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));

			//소켓 1로부터 들어오는 메시지를 읽는 반복문
			while(true) {				
				String msg = reader.readLine();
				// 소켓 2로 메시지를 내보냄
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}




		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		/* 안되는 코드임.
		BufferedReader reader2 
		 = new BufferedReader(
			new InputStreamReader(socket1.getInputStream()));

		reader1.readLine();
		reader2.readLine();
		 */
	}
}
