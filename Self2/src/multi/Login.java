package multi;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements KeyListener{
	private JTextField tfID;
	private JTextField tfPW;
	private JButton btLogin;
	private JButton btnSignUp;
	private String nick = "이름없음";
	Connection connect;
	
	public Login() {
		this.setTitle("채팅 로그인");
		this.setSize(240, 265);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbID = new JLabel("아이디");
		lbID.setBounds(30, 48, 57, 15);
		panel.add(lbID);
		
		JLabel lbPW = new JLabel("비밀번호");
		lbPW.setBounds(30, 90, 57, 15);
		panel.add(lbPW);
		
		tfID = new JTextField();
		tfID.setBounds(96, 45, 116, 21);
		panel.add(tfID);
		tfID.setColumns(10);
		
		tfPW = new JTextField();
		tfPW.setBounds(96, 87, 116, 21);
		panel.add(tfPW);
		tfPW.setColumns(10);
		
		btLogin = new JButton("접속하기");
		btLogin.setBounds(12, 160, 89, 23);
		panel.add(btLogin);
		
		btnSignUp = new JButton("가입");
		btnSignUp.setBounds(115, 160, 97, 23);
		panel.add(btnSignUp);
		this.setVisible(true);
		
	}

	
	public void idCheck() {
		this.nick = tfID.getText();
		PreparedStatement pstmt = null;
		
		try {
			connect = ConnectionProvider.getConnection();
			String sql = "select * from chat where snum = ?";
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			if(nick.equals(pstmt.get)) {
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void start() {
		ChatClient con = new ChatClient(nick);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			idCheck();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Login login = new Login();
	}
	
}
