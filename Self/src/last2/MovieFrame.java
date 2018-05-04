package last2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MovieFrame extends JFrame {
	private Vector<Movie> mL;
	private JList<Movie> jML;
	private JTextField tfTitle;
	private JButton btnAdd;
	private JButton btnLoad;

	//연결 및 입출력을 위한 멤버 변수
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public MovieFrame() {
		connect();
		this.setTitle("영화");
		this.setSize(400, 400);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		jML = new JList<Movie>();
		jML.setFont(new Font("돋움", Font.PLAIN, 12));
		jML.setBounds(12, 10, 171, 285);
		panel.add(jML);


		tfTitle = new JTextField();
		tfTitle.setFont(new Font("돋움", Font.PLAIN, 12));
		tfTitle.setBounds(112, 312, 151, 21);
		panel.add(tfTitle);
		tfTitle.setColumns(10);

		//영화 목록에 적어놓은 영화를 추가하는 버튼
		btnAdd = new JButton("추가");
		btnAdd.setFont(new Font("돋움", Font.PLAIN, 12));
		btnAdd.setBounds(275, 311, 97, 23);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendList();
			}
		});
		
		btnLoad = new JButton("불러오기");
		btnLoad.setFont(new Font("돋움", Font.PLAIN, 12));
		btnLoad.setBounds(195, 7, 97, 23);
		panel.add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendList();
			}
		});

		this.setVisible(true);
	}

	public void sendList() {
		try {
			String movieName = tfTitle.getText(); //필드에 적힌 값을 가져옴
			Protocol p = new Protocol(); //프로토콜을 만듬.
			
			p.setType("#MTitle"); //프로토콜의 타입 설정.
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("title", movieName); //맵 객체에 키값으로 title, 무비네임 입력
			p.setData(data); //프로토콜에 맵 객체를 저장
			out.writeObject(p); //프로토콜을 전송
			out.flush();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void connect() {
		
		BufferedWriter writer;
		try {
			socket = new Socket("192.168.0.55",5555);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			out = new ObjectOutputStream(socket.getOutputStream());
			
			Thread receiver = new Thread(new Receiver(socket));
			receiver.start();
			writer.write(" ");
			writer.newLine();
			writer.flush();
			
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
			in = null;
			String msg = null;
			DefaultListModel model = new DefaultListModel();
			try {
				in = new ObjectInputStream(socket.getInputStream());
				while(true) {				
					try {
						System.out.println("1");
						mL=(Vector<Movie>) in.readObject();
						if(mL.size()==0) {
							System.out.println("데이터가 없습니다");
						} else {							
							System.out.println(mL.size());
							for(int i=0; i<mL.size(); i++) {
								model.addElement(mL.get(i));
								jML.setModel(model);
							}
						}
						//List<Movie> tmp = (Vector<Movie>) in.readObject();
						
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("상대방이 연결을 종료했습니다.");
				//e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		MovieFrame mob = new MovieFrame();
	}
}
