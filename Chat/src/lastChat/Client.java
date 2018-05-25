package lastChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame {
	//연결을 위한 변수
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private JTextField tfID;
	private JTextField tfPW;
	private JButton btLogin;
	private JButton btSignUp;
	//얘가 로그인 프레임
	public Client() {
		System.out.println("커넥션 ㄱㄱ!");
		Connect();
		System.out.println("커넥션 못넘냐?");
		this.setTitle("비트 채팅");
		this.setSize(300, 233);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JLabel lbID = new JLabel("아이디");
		lbID.setBounds(9, 37, 57, 15);
		panel.add(lbID);
		JLabel lbPW = new JLabel("비밀번호");
		lbPW.setBounds(9, 93, 57, 15);
		panel.add(lbPW);
		
		btLogin = new JButton("로그인");
		btLogin.setBounds(22, 152, 97, 23);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인 프로토콜 설정.
				String type = "#001";
				Member loginMember = new Member(tfID.getText(),tfPW.getText());
				LoginFrameSend(type,loginMember);
				System.out.println("로그인센드로 ㄱ");
			}
		});
		panel.add(btLogin);
		
		btSignUp = new JButton("가입하기");
		btSignUp.setBounds(160, 152, 97, 23);
		btSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인 프로토콜 설정.
				String type = "#000";
				Member signMember = new Member(tfID.getText(),tfPW.getText());
				LoginFrameSend(type,signMember);
			}
		});
		panel.add(btSignUp);
		
		tfID = new JTextField();
		tfID.setBounds(78, 33, 180, 23);
		panel.add(tfID);
		tfPW = new JTextField();
		tfPW.setBounds(78, 90, 180, 21);
		panel.add(tfPW);
		this.setVisible(true);
	}
	
	public void Connect() {
		try {
			socket = new Socket("192.168.0.33",8000);
			out = new ObjectOutputStream(socket.getOutputStream());
			Thread receiver = new Thread(new Receiver(socket));
			receiver.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	class Receiver implements Runnable {
		public Receiver(Socket soc) {
			socket = soc;
		}
		public void run() {
			ObjectInputStream in=null;
			String msg = null;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				while(true) {
					//taChat.append(msg+"\n");
					
					
					Protocol p = (Protocol)in.readObject();
					String type = p.getType();
					Map<String, Object> data = p.getData();
					
					if(type.equals("#001")) {
						System.out.println("로그인 성공");
					}
					if (type.equals("#002")) {
						System.out.println("비번 불일치");
					}
					if (type.equals("#003")) {
						System.out.println("아이디 불일치");
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
	
	//로그인 창에서 쓰이는 센드
	public void LoginFrameSend(String t, Member mem) {
		Protocol p = new Protocol();
		String type = t;
		Map<String,Object> login = new HashMap<String,Object>();
		login.put("login", mem);
		p.setType(type);
		p.setData(login);
		System.out.println(p.getData());
		try {
			System.out.println("전송준비");
			out.writeObject(p);
			out.flush();
			System.out.println("전송완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Client client = new Client();
	}
}
