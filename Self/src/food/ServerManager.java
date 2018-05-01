package food;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
		private String name;
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}		
		public void run() {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				//추가기능: 이름 입력받기
				BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				writer1.write("이름을 입력하세요");
				writer1.newLine();
				writer1.flush();
				
				String name = reader.readLine();

				while(true) {
					String msg = null;

					//문자열을 읽어왔으니 리스트가 가지고 있는 모든 소켓에 전달하면 된다.
					msg = reader.readLine();
					for(Socket s: socketList) {
						if(s==socket) {
							continue;
						}

						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

						writer.write(name+" : "+msg);
						writer.newLine();
						writer.flush();
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
