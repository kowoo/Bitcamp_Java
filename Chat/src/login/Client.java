package login;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame{
	private JTextField tfID;
	private JTextField pwField;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Socket socket;
	private JButton btLogin;
	private JButton btSignUp;
	
	public Client() {
		this.setTitle("채팅 로그인");
		this.setSize(400, 400);
		Connection();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbID = new JLabel("아이디");
		lbID.setBounds(42, 104, 57, 15);
		panel.add(lbID);
		
		JLabel lbPW = new JLabel("비밀번호");
		lbPW.setBounds(42, 200, 57, 15);
		panel.add(lbPW);
		
		tfID = new JTextField();
		tfID.setBounds(125, 101, 170, 21);
		panel.add(tfID);
		
		pwField = new JTextField();
		pwField.setBounds(125, 197, 170, 23);
		panel.add(pwField);
		this.setVisible(true);
		
		btLogin = new JButton("로그인");
		btLogin.setBounds(42, 262, 97, 23);
		panel.add(btLogin);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		btSignUp = new JButton("회원가입");
		btSignUp.setBounds(242, 262, 97, 23);
		panel.add(btSignUp);
		this.setVisible(true);
	}
	
	public void Connection() {
		try {
			System.out.println("커넥션 접근1");
			socket = new Socket("192.168.0.55",8000);
			out = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("커넥션 접근2");
			System.out.println("커넥션 접근3");
			Thread receiver = new Thread(new Receiver(socket));
			System.out.println("리시버 작동");
			receiver.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
	}
	
	public void login() {
		try {
			Protocol p = new Protocol();
			Members member = new Members(tfID.getText(),pwField.getText());
			p.setType("#001");
			Map<String,Object> login = new HashMap<String,Object>();
			login.put("login", member);
			p.setData(login);
			out.writeObject(p);
			out.flush();
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
			System.out.println("리시버 시작");
			BufferedReader in2=null;
			String msg = null;
			try {
				System.out.println("당연히!");
				in2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("여기까지 들어옴");
				in = new ObjectInputStream(socket.getInputStream());
				System.out.println("오브젝트인 성공");
				while(true) {
					msg = in2.readLine();
					
					if(msg=="1") {
						LoginError log= new LoginError();
						log.idError();
					} else if (msg=="2") {
						LoginError log= new LoginError();
						log.pwError();
					} else {
						ChatFrame frame = new ChatFrame();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class ChatFrame extends JFrame implements KeyListener {
		private JTextField tfMsg;
		private JTextField tfNick;
		private JButton btSend;
		private JButton btNick;
		private Protocol p;
		private JTextArea taChat;
		
		private Socket socket;
		private ObjectOutputStream out;
		private String nick = "이름없음";
		
		public ChatFrame() {
			this.setTitle("채티이잉");
			this.setSize(388, 469);
			Connection();
			
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 247, 332);
			panel.add(scrollPane);
			
			taChat = new JTextArea();
			scrollPane.setViewportView(taChat);
			
			tfMsg = new JTextField();
			tfMsg.setBounds(12, 380, 247, 21);
			panel.add(tfMsg);
			tfMsg.addKeyListener(this);
			
			tfNick = new JTextField();
			tfNick.setBounds(271, 294, 96, 21);
			panel.add(tfNick);
			
			JLabel lbNick = new JLabel("닉네임");
			lbNick.setBounds(271, 269, 57, 15);
			panel.add(lbNick);
			
			btNick = new JButton("변경");
			btNick.setBounds(270, 325, 97, 23);
			panel.add(btNick);
			btNick.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nickChange();
				}
			});
			btSend = new JButton("전송");
			btSend.setBounds(270, 379, 97, 23);
			panel.add(btSend);
			btSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					send();
				}
			});
			this.setVisible(true);
		}
		
		public void Connection() {
			try {
				socket = new Socket("192.168.0.55",8000);
				out = new ObjectOutputStream(socket.getOutputStream());
				Thread receiver = new Thread(new Receiver(socket));
				receiver.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void nickChange( ) {
			try {
				String msg = tfNick.getText();
				Protocol p = new Protocol();
				p.setType("#01");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("nick", msg);
				p.setData(data);
				out.writeObject(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void send() {
			try {
				String msg = tfMsg.getText();
				Protocol p = new Protocol();
				p.setType("#02");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("msg", msg);
				p.setData(data);
				out.writeObject(p);
				
				taChat.append("나 : "+msg+"\n");
				tfMsg.setText("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				send();
			}
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class LoginError extends JFrame {
		private static final long serialVersionUID = 7673110584248066757L;
		private JTextArea text;
		public LoginError() {
			this.setTitle("에러");
			this.setSize(192, 150);
			
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			text = new JTextArea();
			text.setFont(new Font("Monospaced", Font.PLAIN, 16));
			text.setBackground(SystemColor.control);
			text.setBounds(33, 30, 117, 38);
			panel.add(text);
			this.setVisible(true);
		}
		
		public void idError() {
			text.setText("아이디 오류");
		}
		
		public void pwError() {
			text.setText("비밀번호 오류");
		}
	}

}
