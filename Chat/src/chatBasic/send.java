package chatBasic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class send implements Runnable{
	private Socket socket;
	
	public send(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		BufferedWriter writer = null;
		Scanner scan = new Scanner(System.in);
		String msg = null;
		try {
			writer =  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				msg = scan.nextLine();
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	
	
	
}
