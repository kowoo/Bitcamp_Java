package chatFrame;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {
	private List<Socket> socketList;
	public Manager() {
		socketList = new ArrayList<Socket>();
	}
	public void add(Socket socket) {
		socketList.add(socket);
		new ServerThread(socket).start();
	}
	
	class ServerThread extends Thread {
		private String nick = "이름없음";
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			ObjectInputStream in=null;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				
				while(true) {
					String msg = null;
					Protocol p = (Protocol)in.readObject();
					String type = p.getType();
					Map<String, Object> data = p.getData();
					msg = (String) data.get("msg");
					if(type.equals("#01")) {
						nick = (String)data.get("nick");
					}
					if(type.equals("#02")) {
						for(Socket s: socketList) {
							if(s==socket) {
								continue;
							}
							BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
							out.write(nick+" : "+msg);
							out.newLine();
							out.flush();
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
