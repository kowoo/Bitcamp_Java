package 복습;

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
		Scanner scan = new Scanner(System.in);
		String msg = null;
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				msg = scan.nextLine();
				if(msg.equals("quit")) {
					break;
				}
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}
			
		} catch (IOException e) {
			System.out.println("상대방이 연결을 종료했습니다.");
			//e.printStackTrace();
		} finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
}
