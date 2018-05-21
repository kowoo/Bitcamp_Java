package lastChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class Server {
	private ServerSocket ssocket;
	private List<Socket> socketList;
	private List<ObjectOutputStream> outS;
	private MemberDao dao;
	
	public Server() {
		try {
			ssocket = new ServerSocket(8000);
			
			while(true) {
				Socket socket = ssocket.accept();
				socketList.add(socket);
				new ServerThread(socket);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class ServerThread extends Thread {
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
		
					Protocol p = (Protocol)in.readObject();
					String type = p.getType();
					
					Map<String, Object> data = p.getData();
					outMsg = (String)data.get("msg");
					
					if(type.equals("#001")) {
						//001##이면 로그인
						Member mem = (Member)data.get("login");
						Member check = dao.selectOne(mem.getId());
						
						if(mem.getId() == check.getId()) {
							System.out.println("아이디 있음!");
							if(mem.getPw() == check.getPw()) {
								System.out.println("비번 일치!");
								//로그인을 실행시키기 위한 프토로콜을 보냄
							} else {
								System.out.println("비번 불일치");
								//로그인 실패 창 로딩을 위한 프토로콜을 보냄
							}
						} else {
							System.out.println("아이디 없음!");
							//로그인 실패 창 로딩을 위한 프토로콜을 보냄
						}
						
					} 
//					else if(type.equals("#02")) {
//						//02##이면 채팅~
//						for(Socket s: socketList) {
//							if(s==socket) {
//								continue;
//							}
//							BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//							writer.write(nick+": "+outMsg);
//							writer.newLine();
//							writer.flush();
//						}
//					}
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
