package login.copy;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;

public class LoginError extends JFrame {
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
	
	public static void main(String[] args) {
		LoginError err = new LoginError();
	}
	
	public void idError() {
		text.setText("아이디 오류");
	}
	
	public void pwError() {
		text.setText("비밀번호 오류");
	}
}
