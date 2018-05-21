package lastChat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JFrame {
	private JTextField tfID;
	private JTextField tfPW;
	private JButton btLogin;
	private JButton btSignUp; 
	public Client() {
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
		this.setVisible(true);
		
		btLogin = new JButton("로그인");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btLogin.setBounds(22, 152, 97, 23);
		panel.add(btLogin);
		
		btSignUp = new JButton("가입하기");
		btSignUp.setBounds(160, 152, 97, 23);
		panel.add(btSignUp);
		
		tfID = new JTextField();
		tfID.setBounds(78, 33, 180, 23);
		panel.add(tfID);
		tfID.setColumns(10);
		
		tfPW = new JTextField();
		tfPW.setBounds(78, 90, 180, 21);
		panel.add(tfPW);
		tfPW.setColumns(10);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Client client = new Client();
	}
}
