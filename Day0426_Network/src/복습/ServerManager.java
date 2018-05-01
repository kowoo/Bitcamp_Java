package 복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerManager {
	private List<Socket> socketList;
	
	public ServerManager() {
		socketList = new ArrayList<Socket>();
	}
	
	public void add(Socket socket) {
		socketList.add(socket);
	
		new ServerThread(socket).start();
		
	
	
	}
	
	class ServerThread extends Thread {
		private String name;
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				writer.write("이름 입력해");
				writer.newLine();
				writer.flush();
				
				String name = reader.readLine();
				
				while(true) {
					String msg = null;
					msg = reader.readLine();
					for(Socket s: socketList) {
						if(s==socket) {
							continue;
						}
					
					BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
					writer2.write(name+" : "+msg);
					writer2.newLine();
					writer2.flush();
					}
					
				}
			
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
