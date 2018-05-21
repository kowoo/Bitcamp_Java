package chatFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class ChatFrame extends JFrame implements KeyListener {
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
	

	public static void main(String[] args) {
		ChatFrame client = new ChatFrame();
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
					taChat.append(msg+"\n");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
