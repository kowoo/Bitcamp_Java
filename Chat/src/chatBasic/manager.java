package chatBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class manager {
	private List<Socket> sList;

	public manager() {
		sList = new ArrayList<Socket>();
	}

	public void add(Socket socket) {
		sList.add(socket);
		new serverThread(socket).start();
	}

	class serverThread extends Thread {
		private Socket socket;

		public serverThread(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg=null;
				while(true) {
					msg = reader.readLine();
					for(Socket s: sList) {
						if(s==socket) {
							continue;
						}
						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						writer.write(msg);
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
