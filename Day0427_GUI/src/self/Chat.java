package self;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chat extends JFrame {
	private JTextField chatField;
	private JTextField sendField;
	private JTextField nameChangeField;
	ServerManager Maga;
	
	public Chat() {
		
		while(true) {
		
		//패널!
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//채팅 내용이 보이는 필드
		chatField = new JTextField();
		chatField.setBounds(12, 10, 410, 180);
		panel.add(chatField);
		chatField.setColumns(30);
		
		//보낼 내용을 적는 필드
		sendField = new JTextField();
		sendField.setBounds(12, 229, 290, 21);
		panel.add(sendField);
		sendField.setColumns(10);
		
		//이름 변경을 위한 필드
		nameChangeField = new JTextField();
		nameChangeField.setBounds(22, 198, 171, 21);
		panel.add(nameChangeField);
		nameChangeField.setColumns(16);
				
		JButton btnSend = new JButton("보내기");
		btnSend.setBounds(314, 229, 108, 23);
		panel.add(btnSend);		
		
		JButton btnNewname = new JButton("이름 변경");
		btnNewname.setBounds(205, 196, 97, 23);
		panel.add(btnNewname);
		
		JButton btnExit = new JButton("종료하기");
		btnExit.setBounds(325, 200, 97, 23);
		panel.add(btnExit);
		break;
		}
		
	}
}
