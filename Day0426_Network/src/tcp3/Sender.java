package tcp3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender implements Runnable {
	private Socket socket;
	
	public Sender(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		//소켓으로부터 메시지를 받아서 출력.
		Scanner scan = new Scanner(System.in);
		String msg = null;
		BufferedWriter writer = null;
		
		try {
			//출력하기 위해서 소켓으로부터 output스트림 얻어오기
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//메시지를 반복해서 보내야하므로 while
			while(true) {
				//키보드에서 메시지를 입력받음
				msg = scan.nextLine();
				if(msg.equals("quit")) {
					break;
				}
				//입력받은 문자열 writer스트림으로 내보내기
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}			
		} catch(IOException e) {
			System.out.println("상대방이 연결을 종료했습니다.");
			//e.printStackTrace();
		} finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
