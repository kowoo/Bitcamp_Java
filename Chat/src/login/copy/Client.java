package login.copy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		System.out.println("커넥션");
		Connection();
		System.out.println("커넥션완료");
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
			socket = new Socket("192.168.0.55",8000);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			Thread receiver = new Thread(new Receiver(socket));
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
			BufferedReader in=null;
			String msg = null;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true) {
					msg = in.readLine();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
