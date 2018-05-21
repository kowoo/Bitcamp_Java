package login;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Server {
	private List<Socket> socketList; 
	private Socket socket;
	private ObjectOutputStream out;
	private MembersDao dao;
	private List<ObjectOutputStream> outS;
	
	public static void main(String[] args) {
		Server server = new Server();
	}
	
	public Server() {
		try {
			socketList = new ArrayList<Socket>();
			ServerSocket sSocket = new ServerSocket(8000);
			while(true) {
				System.out.println("연결 대기 중");
				Socket socket = sSocket.accept();
				System.out.println("연결 완료");
				socketList.add(socket);
				System.out.println("소켓 추가 완료");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//차후 가입 시 개별 중복 버튼을 만든다면 필요한 메서드.
//	public int idCheck(String id) {
//		Members identify = dao.selectOne(id);
//		if(identify.getId().equals(id)) {
//			System.out.println("아이디 중복");
//			return 0;
//		} else {
//			return 1;
//		}
//	}
	
	//닉네임 변경시 사용하는 메서드
	public int checkNick(String nick) {
		Members identify = dao.checkNick(nick);
		if(identify.getNick().equals(nick)) {
			System.out.println("닉네임 중복");
			return 0;
		} else {
			return 1;
		}
	}
	//회원가입시 사용하는 메서드
	public int signUp(Members tmp) {
		Members identify = dao.selectOne(tmp.getId());
		Members nickName = dao.selectOne(tmp.getNick());
		if(identify.getId().equals(tmp.getId())) {
			System.out.println("가입실패! 아이디 존재");
				return 0;
		} else {
			System.out.println("아이디 중복 없음!");
			if(nickName.getNick().equals(tmp.getNick())) {
				System.out.println("가입실패! 닉네임 중복");
				return 0;
			} else {
				dao.insertMember(tmp);
				System.out.println("가입 성공!");
				return 1;
			}
		}
	}
	//로그인시 사용하는 메서드
	public int login(String id, String pw) {
		Members identify = dao.selectOne(id);
		int result;
		if(identify.getId().equals(id)) {
			System.out.println("아이디 존재");
			if(identify.getPw().equals(pw)) {
				System.out.println("로그인 성공");
				result=0;
			} else {
				System.out.println("비밀번호 오류");
				result=2;
			}
		} else {
			System.out.println("아이디 오류");
			result=1;
		}
		return result;
	}

	public void Connection() {
//		try { 얘는 소켓을 받아오도록 해야함.
//			socket = new Socket("192.168.0.55",8000);
//			out = new ObjectOutputStream(socket.getOutputStream());
//			Thread receiver = new Thread(new Receiver(socket));
//			receiver.start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	class Receiver implements Runnable {
		ObjectInputStream in;
		Socket soc;
		public Receiver(Socket socket) {
			soc = socket;
		}
		public void run() {
			in=null;
			Protocol p=null;
			try {
				in = new ObjectInputStream(soc.getInputStream());
				out = new ObjectOutputStream(soc.getOutputStream());
				outS.add(out);
				while(true) {
					p = (Protocol) in.readObject();
					String type = p.getType();
					Map<String, Object> data = p.getData();
					//회원가입
					if(type.equals("#000")) {
						
					}			
					//로그인
					if(type.equals("#001")) {
						System.out.println("아이디, 비번 받음");
						Members member = (Members)data.get("login");
						String loginId = member.getId();
						String loginpw = member.getPw();
						int loginValue = login(loginId, loginpw);
						BufferedWriter log = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
						log.write(loginValue);
						log.newLine();
						log.flush();
					}
					//닉변
					if(type.equals("#002")) {
						
					}
					//채팅
					if(type.equals("#003")) {
						String a = (String) data.get("str");
						for(int i=0; i<outS.size(); i++) {
							if(outS.get(i)==out) {
								continue;
							}
							outS.get(i).writeObject(p);
							outS.get(i).flush();
							outS.get(i).reset();
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
