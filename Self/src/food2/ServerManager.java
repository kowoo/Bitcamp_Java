package food2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
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
		private String name;
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
					String msg = null;
					String outMsg = null;

					//문자열을 읽어왔으니 리스트가 가지고 있는 모든 소켓에 전달하면 된다.
					Protocol p = (Protocol)in.readObject();
					
					//읽어온 메시지가 닉네임 변경이면 닉변.
					//전송이면 이전과 같이 동작(모든 소켓에 메시지 전달).
					
					//문자열 0~3번까지 읽어옴
					//String type = msg.substring(0, 3); 
					
					//근데 그냥 토크나이저 쓰자. 왜냐하면 위의 섭스트링은 글자를 없애주질 못해서 ##01같은걸 다시 지우고 해야함.
					String type = p.getType();
					
					Map<String, Object> data = p.getData();
					outMsg = (String)data.get("msg");
					
					if(type.equals("#01")) {
						outMsg = (String)data.get("nick");
						nick = outMsg;
						
					} else if(type.equals("#02")) {
						for(Socket s: socketList) {
							if(s==socket) {
								continue;
							}
							out.writeObject(nick+": "+outMsg);
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