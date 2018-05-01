package guiChat3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServerManager {
	//소켓 리스트 저장
	//소켓이 들어오면 쓰레드 생성
	//쓰레드는 전달 받은 소켓으로 부터 메시지를 받는다. 이후 전달받은 메시지를 리스트의 모든 소켓에 보낸다. (자신 제외)
	private List<Socket> socketList;	

	public ServerManager() {
		socketList = new ArrayList<Socket>();
	}

	public void add(Socket socket) {
		socketList.add(socket);

		//쓰레드 생성 및 실행.

		//		Thread t1 = new ServerThread(socket);
		//		t1.start(); //전달 받은 소켓을 이용해 바로 쓰레드를 생성하고 실행한다.

		//위와 아래는 같은 결과

		new ServerThread(socket).start();
	}

	//쓰레드가 리스트를 계속 사용해야 하기 때문에 멤버클래스로 선언한다.
	class ServerThread extends Thread {
		//특정 소켓으로 부터 메시지를 받아서 리스트의 모든 소켓에 전달하는 녀석이다.
		//클라이언트당 닉네임은 하나씩 존재한다. 그러므로 Thread의 멤버 변수로 nick를 가진다.
		private String nick = "이름없음";
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}		
		public void run() {
			ObjectInputStream in = null;
			try {
				//BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				in = new ObjectInputStream(socket.getInputStream());
				//소켓으로부터 메시지를 읽어오는 부분
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
						//01##이면 닉변!
						outMsg = (String)data.get("nick");
						nick = outMsg;
						
					} else if(type.equals("#02")) {
						//02##이면 채팅~
						for(Socket s: socketList) {
							if(s==socket) {
								continue;
							}
							BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
							writer.write(nick+": "+outMsg);
							writer.newLine();
							writer.flush();
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
