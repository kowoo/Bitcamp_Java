package last2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ServerManager {
	private List<Socket> socketList;
	private Vector<Movie> movieList;

	public ServerManager() {
		socketList = new ArrayList<Socket>();
		movieList = new Vector<Movie>();
		movieList.add(new Movie("없음1"));
		movieList.add(new Movie("없음2"));
		movieList.add(new Movie("없음3"));
	}
	public void add(Socket socket) {
		socketList.add(socket);
		new ServerThread(socket).start();
	}
	public Vector<Movie> refresh() {
		return movieList;
	}
	
	class ServerThread extends Thread {
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			BufferedReader reader;

			try {
				//in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true) {
					String msg = null;
					String outMsg = null;
					reader.readLine();
					System.out.println("받음");
					out.writeObject(movieList);
					System.out.println("보냄");
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}
	}
	
	
}
