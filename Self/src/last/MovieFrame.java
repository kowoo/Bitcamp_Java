package last;

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
	private Vector<Movie> tmp;

	//연결 및 입출력을 위한 멤버 변수
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private BufferedWriter writer;

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
		tfTitle.setBounds(221, 20, 151, 21);
		panel.add(tfTitle);
		tfTitle.setColumns(10);

		//영화 목록에 적어놓은 영화를 추가하는 버튼
		btnAdd = new JButton("추가");
		btnAdd.setFont(new Font("돋움", Font.PLAIN, 12));
		btnAdd.setBounds(275, 51, 97, 23);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendList();
			}
		});
		
		btnLoad = new JButton("불러오기");
		btnLoad.setFont(new Font("돋움", Font.PLAIN, 12));
		btnLoad.setBounds(22, 311, 97, 23);
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
//			String movieName = tfTitle.getText(); //필드에 적힌 값을 가져옴
//			out.writeObject(movieName); //프로토콜을 전송
			writer.write(tfTitle.getText());
			writer.newLine();
			writer.flush();
			System.out.println("보내짐");
			tfTitle.setText("");
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void connect() {
		
		try {
			socket = new Socket("192.168.0.55",5555);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			out = new ObjectOutputStream(socket.getOutputStream());
			
			Thread receiver = new Thread(new Receiver(socket));
			receiver.start();
			writer.write("1");
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
			try {
				in = new ObjectInputStream(socket.getInputStream());
				DefaultListModel model;
				tmp = new Vector<Movie>();
				while(true) {				
					try {
						model = new DefaultListModel();
						tmp=(Vector<Movie>) in.readObject();
						Thread.sleep(3000);
						
						if(tmp.size()==0) {
							System.out.println("데이터가 없습니다");
						} else {	
							for(int i=0; i<tmp.size(); i++) {
								model.addElement(tmp.get(i));
								jML.setModel(model);
							}
						}
						
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
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
