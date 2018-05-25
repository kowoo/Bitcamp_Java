package lastChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Server {
	private ServerSocket ssocket;
	private List<Socket> socketList;
	private List<ObjectOutputStream> outS;
	private MemberDao dao;
	
	public Server() {
		try {
			socketList = new ArrayList<Socket>();
			ssocket = new ServerSocket(8000);
			
			while(true) {
				System.out.println("여기는 ㄱㅊ");
				Socket socket = ssocket.accept();
				System.out.println("여기가 널?");
				socketList.add(socket);
				new ServerThread(socket).start();
				
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
					System.out.println("로그인 데이터 보낸거 받음");
					
					Map<String, Object> data = p.getData();
					outMsg = (String)data.get("msg");
					
					if(type.equals("#001")) {
						System.out.println("로그인 정보확인");
						Member mem = (Member)data.get("login");
						
						if(dao.selectOne(mem.getId())==null) {
							if(type.equals("#001")) {
								System.out.println("없는 아이디");
								p.setType("#003");
								out.writeObject(p);
							}
						if(type.equals("#000")) {
								//#000이면 가입
								Member mem2 = (Member)data.get("login");
								mem2.setNick("이름없음");
								dao.insert(mem2);
								System.out.println("가입완료");
							}
						//null이 아니라면
						} else {
							Member check = dao.selectOne(mem.getId());
							if(mem.getPw() == check.getPw()) {
								System.out.println("비번 일치!");
								p.setType("#001");
								out.writeObject(p);
							} else {
								System.out.println("비번 불일치");
								p.setType("#002");
								out.writeObject(p);
							}
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
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
	}
}
