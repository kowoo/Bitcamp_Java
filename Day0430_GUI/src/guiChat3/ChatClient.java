package guiChat3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements KeyListener{
	/******화면을 구성하는 멤버 변수******/
	private JButton btnSend; //채팅 내용을 보내는 버튼
	private JTextArea textArea; //채팅 내용이 출력되는 화면
	private JTextField textField; //채팅 내용을 입력하는 필드
	private JTextField textFieldIp; //접속을 원하는 ip를 입력하는 필드
	private JLabel Jlbl1; //ip입력 창을 알려주는 라벨
	private JButton btnConnect; //입력한 ip에 접속하는 버튼
	private JLabel lalNickName;
	private JButton btnNickName;
	private JTextField tfNick;

	/******채팅을 구성하는 멤버 변수******/
	private Socket socket; //서버로 메시지 전송을 위한 소켓
	private ObjectOutputStream out;
	private String nick = "이름없음";

	public ChatClient() {
		this.setTitle("채팅");
		this.setSize(400, 457);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 186, 341);
		panel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		textField = new JTextField();
		textField.setBounds(22, 366, 228, 23);
		panel.add(textField);
		textField.addKeyListener(this);
		
		textFieldIp = new JTextField();
		textFieldIp.setBounds(210, 255, 162, 21);
		panel.add(textFieldIp);
		textFieldIp.setText("192.168.0.55"); //입력이 귀찮으니 기본 설정
		//textFieldIp.addKeyListener(this);

		btnSend = new JButton("전송");
		btnSend.setBounds(275, 365, 97, 23);
		panel.add(btnSend);
		
		//채팅 보내기
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();		
			}		
		});


		Jlbl1 = new JLabel("서버 아이피");
		Jlbl1.setBounds(213, 224, 102, 21);
		panel.add(Jlbl1);

		btnConnect = new JButton("접속");
		btnConnect.setBounds(210, 286, 162, 23);
		panel.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 서버로 연결
				makeConnection(); //접속버튼을 누를 때 연결시켜주면 된다.
			}
		});
		
		tfNick = new JTextField();
		tfNick.setBounds(210, 164, 162, 21);
		panel.add(tfNick);
		
		lalNickName = new JLabel("닉네임");
		lalNickName.setBounds(210, 133, 57, 21);
		panel.add(lalNickName);
		
		btnNickName = new JButton("저장");
		btnNickName.setBounds(275, 195, 97, 23);
		panel.add(btnNickName);
		
		btnNickName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//버튼이 눌리면 nick 을 변경
				//sendNick();
			}
		});

		this.setVisible(true);
	}//생성자 end
	
	public void sendNick() {
		try {
			String msg = tfNick.getText();

			Protocol p = new Protocol();
			p.setType("#01");
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("nick", msg);
			p.setData(data);
			out.writeObject(p);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void sendMessage() {
		try {
			String msg = textField.getText();
			
			//문자열이 아닌 객체쓰기: ObjectStream이 필요하다.
			//writer.write("02##"+msg);
//			writer.newLine();
//			writer.flush();
			Protocol p = new Protocol();
			p.setType("#02");
			//p에다가 데이터를 넣기 위해서 Map이 필요하다
			Map<String, Object> data = new HashMap<String, Object>();
			//채팅 메시지 넣어주기
			data.put("msg", msg);
			//전송할 프로토콜 객체에 데이터 세팅
			p.setData(data);
			out.writeObject(p);
			//보내고 나서 해야할 일: 내가 작성한 내용을 textArea(채팅 내용)에 보내고 저장하기
//			textArea.append("나: " + msg + "\n");
//			textField.setText(""); //채팅내용을 보냈으니 필드를 비워준다. 안그러면 ㅋㅋ를 보내고 난 뒤에도 입력창에 ㅋㅋ가 남아있게 되는 셈

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}
	
	private void makeConnection() {
		//서버로 연결하기: ip(textField에서 가져오기), port (port는 고정, 예를 들어 8000)
		InetAddress ip = null;
		
		//ip를 입력받는 textFieldIp에서 ip를 가져온다!
		try {
			ip = InetAddress.getByName(textFieldIp.getText());
			socket = new Socket(ip, 8000);
			//소켓 얻어왔으니 데이터 전송을 위해서 스트림 얻어오기
			
			out = new ObjectOutputStream(socket.getOutputStream());
			Thread receiver = new Thread(new Receiver(socket));
			receiver.start();
	
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			sendMessage();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//Sender Thread가 필요없는 이유: 보내기가 버튼 이벤트로 처리되기 때문이다.
	//하지만 Receiver Thread는 화면을 보여주는 것과 동시에 서버로부터 메시지를 받아야하므로 필요함!

	class Receiver implements Runnable {
		
		public Receiver(Socket soc) {
			socket = soc;
		}
		
		public void run() {
			BufferedReader reader = null;
			String msg = null;
			
			//데이터를 소켓으로부터 읽어오기 위해서 스트림을 얻어옴
			
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true) {				
					msg = reader.readLine();
					textArea.append(msg+"\n");
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("상대방이 연결을 종료했습니다.");
				//e.printStackTrace();
			}
			
		}
	}
	
	
	
}
