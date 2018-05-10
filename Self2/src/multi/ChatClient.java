package multi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements KeyListener {
	private JTextField tfSend;
	private JTextField tfNick;
	private JButton btnSend;
	private JButton btnNick;
	private JButton btnSave;
	private Socket socket;
	private ObjectOutputStream out;
	private String nick = "이름없음";
	
	public ChatClient(String nick) {
		this.nick = nick;
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 240, 360);
		panel.add(scrollPane);
		
		JTextArea ta = new JTextArea();
		scrollPane.setViewportView(ta);
		
		tfSend = new JTextField();
		tfSend.setBounds(12, 380, 240, 53);
		panel.add(tfSend);
		tfSend.setColumns(10);
		
		tfNick = new JTextField();
		tfNick.setBounds(306, 299, 116, 21);
		panel.add(tfNick);
		tfNick.setColumns(10);
		
		btnSend = new JButton("보내기");
		btnSend.setBounds(262, 380, 73, 53);
		panel.add(btnSend);
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		
		btnSave = new JButton("저장");
		btnSave.setBounds(355, 380, 67, 53);
		panel.add(btnSave);
		
		btnNick = new JButton("닉네임 변경");
		btnNick.setBounds(325, 330, 97, 23);
		panel.add(btnNick);
	}

	
	public void CHatClient() {
		this.setTitle("Chaaaaaaaaat");
		this.setSize(600, 600);
		this.setVisible(true);
		
		
	}
	
	public connect() {
		
	}
	
	public void send() {
		String msg = tfSend.getText();
		
		
	}
}
