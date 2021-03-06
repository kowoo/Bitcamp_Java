package food;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		//private String name;
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				while(true) {
					String btn = null;
					String action = null;

					Protocol p = (Protocol)in.readObject();

					//읽어온 객체가 어드민이 보낸 것이면 어드민이 가지는 기능을 실행.
					//게스트면 게스트의 기능만 실행

					String type = p.getType();

					Map<String, Object> data = p.getData();
					action = (String)data.get("btn");

					if(type.equals("#show")) {
						//#show면 조회
						action = (String)data.get("#show");
						out.writeObject(p);
						out.flush();
					} else if(type.equals("#commentAdd")) {
						//#commentAdd면 덧글달기
						for(Socket s: socketList) {
							if(s==socket) {
								continue;
							}
							out.writeObject(action);
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