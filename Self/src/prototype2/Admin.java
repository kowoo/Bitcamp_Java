package prototype2;

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
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin extends JFrame {
	private static final long serialVersionUID = 1283403456965972738L;
	//private static final String FILE_NAME = "food.dat";
	private Vector<Store> fList;
	private Vector<Store> tmp;
	private JTextField tfName;
	private JTextField tfType;
	private JTextField tfTeleNumber;
	private JTextField tfOpenClosed;
	private JTextField tfPrice;
	private JTextField tfScore;
	private JList<Store> jFList;
	private JButton btnCheck;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnModify;
	
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public Admin() {
		connect();
		this.setTitle("꿀맛");
		this.setSize(936, 373);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMovieList = new JLabel("목록");
		lblMovieList.setBounds(12, 25, 57, 15);
		panel.add(lblMovieList);

		jFList = new JList<Store>(fList);
		jFList.setFont(new Font("돋움", Font.PLAIN, 12));
		jFList.setBounds(12, 42, 162, 231);
		panel.add(jFList);

		JLabel lblName = new JLabel("가게 이름");
		lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblName.setBounds(206, 43, 57, 15);
		panel.add(lblName);

		tfName = new JTextField();
		tfName.setFont(new Font("돋움", Font.PLAIN, 12));
		tfName.setBounds(275, 40, 116, 21);
		panel.add(tfName);

		JLabel lblType = new JLabel("분류");
		lblType.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblType.setBounds(206, 83, 57, 15);
		panel.add(lblType);

		tfType = new JTextField();
		tfType.setFont(new Font("돋움", Font.PLAIN, 12));
		tfType.setBounds(275, 80, 116, 21);
		panel.add(tfType);

		JLabel lblTeleNumber = new JLabel("전화번호");
		lblTeleNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblTeleNumber.setBounds(206, 123, 57, 15);
		panel.add(lblTeleNumber);

		tfTeleNumber = new JTextField();
		tfTeleNumber.setFont(new Font("돋움", Font.PLAIN, 12));
		tfTeleNumber.setBounds(275, 120, 116, 21);
		panel.add(tfTeleNumber);

		JLabel lblOpenClosed = new JLabel("영업시간");
		lblOpenClosed.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblOpenClosed.setBounds(206, 163, 57, 15);
		panel.add(lblOpenClosed);

		tfOpenClosed = new JTextField();
		tfOpenClosed.setFont(new Font("돋움", Font.PLAIN, 12));
		tfOpenClosed.setBounds(275, 160, 116, 21);
		panel.add(tfOpenClosed);

		JLabel lblPrice = new JLabel("가격대");
		lblPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblPrice.setBounds(206, 203, 57, 15);
		panel.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setFont(new Font("돋움", Font.PLAIN, 12));
		tfPrice.setBounds(275, 200, 116, 21);
		panel.add(tfPrice);

		JLabel lblScore = new JLabel("평점");
		lblScore.setBounds(265, 249, 57, 15);
		panel.add(lblScore);

		tfScore = new JTextField();
		tfScore.setFont(new Font("돋움", Font.PLAIN, 12));
		tfScore.setBounds(334, 246, 57, 21);
		panel.add(tfScore);

		btnCheck = new JButton("조회");
		btnCheck.setFont(new Font("돋움", Font.PLAIN, 11));
		btnCheck.setBounds(12, 287, 57, 23);
		panel.add(btnCheck);		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=jFList.getSelectedIndex();
				Store selectE = new Store();
				selectE = select(num);
				tfName.setText(selectE.getName());
				tfType.setText(selectE.getType());
				tfTeleNumber.setText(selectE.getTeleNumber());
				tfOpenClosed.setText(selectE.getOpenClosed());
				tfPrice.setText(selectE.getPrice()+"");
				tfScore.setText(selectE.getScore()+"");	
			}
		});
		btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("돋움", Font.PLAIN, 11));
		btnDelete.setBounds(81, 287, 57, 23);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = jFList.getSelectedIndex();
				Store eat2 = new Store();
				eat2 = fList.get(num);
				delete(eat2);
			}
		});
		btnAdd = new JButton("추가");
		btnAdd.setFont(new Font("돋움", Font.PLAIN, 11));
		btnAdd.setBounds(206, 287, 75, 23);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String type = tfType.getText();
				String teleNumber = tfTeleNumber.getText();
				String openClosed = tfOpenClosed.getText();
				String price = tfPrice.getText();
				String score = tfScore.getText();
				Store eat = new Store(name,type,teleNumber,openClosed,price,score);
				sendEatery(eat);
			}
		});
		btnModify = new JButton("수정");
		btnModify.setFont(new Font("돋움", Font.PLAIN, 11));
		btnModify.setBounds(329, 287, 62, 23);
		panel.add(btnModify);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String type = tfType.getText();
				String teleNumber = tfTeleNumber.getText();
				String openClosed = tfOpenClosed.getText();
				String price = tfPrice.getText();
				String score = tfScore.getText();
				Store eat = new Store(name,type,teleNumber,openClosed,price,score);
				modify(eat);
			}	
		});		
		this.setVisible(true);
	}
	
	public void connect() {	
		try {
			socket = new Socket("192.168.0.55",5555);
			out = new ObjectOutputStream(socket.getOutputStream());
			
			Thread receiver = new Thread(new Receiver(socket));
			receiver.start();
			String start = "ㄱ";
			
			Protocol p = new Protocol();
			p.setType("#1#");
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("start", start);
			p.setData(data);
			out.writeObject(p);
			out.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		public Store select(int num) {
			return fList.get(num);
		}
		
		public void sendEatery(Store eat) {
			try {
				Protocol p = new Protocol();
				p.setType("#sendEatery#");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("eatery", eat);
				p.setData(data);
				out.writeObject(p);
				out.reset();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		public void delete(Store eat) {
			try {
				Protocol p = new Protocol();
				p.setType("#deleteEatery#");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("del", eat);
				p.setData(data);
				out.writeObject(p);
				out.reset();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		public void modify(Store eat) {
			try {
				Protocol p = new Protocol();
				p.setType("#modifyEatery#");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("modify", eat);
				p.setData(data);
				out.writeObject(p);
				out.reset();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	class Receiver implements Runnable {
		
		public Receiver(Socket soc) {
			socket = soc;
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void run() {
			in = null;
			String msg = null;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				DefaultListModel model;
				Vector<Store> tmp;
				while(true) {
					try {
						model = new DefaultListModel();
						tmp = new Vector<Store>();
						tmp = (Vector<Store>) in.readObject();
						if(tmp.size()==0) {
							System.out.println("데이터가 없습니다");
						} else {	
							for(int i=0; i<tmp.size(); i++) {
								model.addElement(tmp.get(i).getName());
								jFList.setModel(model);
							}
							fList=tmp;
						}
						for(Store e: tmp) {
							System.out.println(e);
						}
										
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} 
				}
			
			} catch (IOException e) {
				System.out.println("상대방이 연결을 종료했습니다.");
			}
			
		}
	}

	public static void main(String[] args) {
		Admin foodd = new Admin();
	}

	public class Comment {
		private String comment;
		public Comment() {
			comment=null;
		}
		public Comment(String string) {
			comment=null;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		@Override
		public String toString() {
			return "Comment [comment=" + comment + "]";
		}

	}
}
