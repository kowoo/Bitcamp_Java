package prototype2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ServerManager {
	private List<Socket> socketList;
	private Vector<Store> storeList;
	private Vector<Store> tmp;

	public ServerManager() {
		socketList = new ArrayList<Socket>();
		storeList = new Vector<Store>();
		storeList.add(new Store("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		storeList.add(new Store("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		storeList.add(new Store("램스칸", "일반", "02-585-7870", "11:30~3:00", "6000", "4"));
	}
	public void add(Socket socket) {
		socketList.add(socket);
		new ServerThread(socket).start();
	}
	public Vector<Store> refresh() {
		return storeList;
	}

	class ServerThread extends Thread {
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		@SuppressWarnings("unchecked")
		public void run() {
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				while(true) {
					String name = null;
					String start = null;
					String outMsg = null;

					Protocol p = (Protocol)in.readObject();
					System.out.println("잘되니?");
					//읽어온 메시지가 닉네임 변경이면 닉변.
					//전송이면 이전과 같이 동작(모든 소켓에 메시지 전달).

					//문자열 0~3번까지 읽어옴
					//String type = msg.substring(0, 3); 

					//근데 그냥 토크나이저 쓰자. 왜냐하면 위의 섭스트링은 글자를 없애주질 못해서 ##01같은걸 다시 지우고 해야함.
					String type = p.getType();
					Map<String, Object> data = p.getData();
					System.out.println("응 잘돼");
					if(type.equals("#1#")) {
						//#보내주십쇼이면 시작값을 준다.
						//start = (String)data.get("start");
						out.writeObject(storeList);
						System.out.println("응 잘돼2");
					} else if(type.equals("#sendEatery#")) {
						//#sendList#면 리스트를 업데이트한다!
						Store etmp = (Store)data.get("eatery");
						//tmp = new Vector<Eatery>();
						storeList.add(etmp);	
						System.out.println("업데이트 완료");
						out.writeObject(storeList);
					} else if(type.equals("#deleteEatery#")) {
						Store etmp = (Store)data.get("del");
						for(int i=0; i<storeList.size(); i++) {
							if(etmp.getName().equals(storeList.get(i).getName())) {
								storeList.remove(i);
							}
						}
						out.writeObject(storeList);
					} else if(type.equals("#modifyEatery#")) {
						Store etmp = (Store)data.get("modify");
						for(int i=0; i<storeList.size(); i++) {
							if(etmp.getName().equals(storeList.get(i).getName())) {
								storeList.set(i, etmp);
							}
						}
						out.writeObject(storeList);
					}

					for(Store e: storeList) {
						System.out.println(e);
					}

					out.reset();
					System.out.println("응 끝");




					//					name = (String)reader.readLine();
					//					System.out.println(name);
					//					if(name.equals("1")) {
					//						out.writeObject(storeList);
					//						System.out.println("시작값");
					//					} else {
					//						System.out.println("추가1");
					//						Eatery mov = new Eatery(name);
					//						storeList.add(mov);
					//						System.out.println("추가2");
					//						out.writeObject(storeList);
					//						out.reset();
					//						System.out.println(storeList.size());
					//						System.out.println("추가성공");
					//						int i=0;
					//						for(Eatery m: storeList) {						
					//							System.out.println(i+":"+m);
					//							i++;
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
