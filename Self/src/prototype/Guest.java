package prototype;

import java.awt.BorderLayout;
import java.awt.Color;
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

import prototype.Admin.Receiver;

public class Guest extends JFrame {
	private static final long serialVersionUID = -940594805044462763L;
	
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
	private Vector<String> comen;
	private JList<String> jCommentList;
	private JLabel lblcomment;
	private JTextField tfComment;
	private JLabel lblAlert;
	private JButton btnCommentAdd;
	
	//연결 및 입출력을 위한 멤버 변수
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private BufferedWriter writer;
	DefaultListModel model;
	
	public Guest() {
		connect();
		comen = new Vector<String>();
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
		//tfOpenClosed.setColumns(10);
		
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
		
		//조회
		btnCheck = new JButton("조회");
		btnCheck.setFont(new Font("돋움", Font.PLAIN, 11));
		btnCheck.setBounds(12, 287, 57, 23);
		panel.add(btnCheck);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Store food = jFList.getSelectedValue();
				tfName.setText(food.getName());
				tfType.setText(food.getType());
				tfTeleNumber.setText(food.getTeleNumber());
				tfOpenClosed.setText(food.getOpenClosed());
				tfPrice.setText(food.getPrice()+"");
				tfScore.setText(food.getScore()+"");
			}
		});
		
		lblcomment = new JLabel("덧글");
		lblcomment.setBounds(505, 25, 57, 15);
		panel.add(lblcomment);
		
		jCommentList = new JList<String>(comen);
		jCommentList.setFont(new Font("돋움", Font.PLAIN, 12));
		jCommentList.setBounds(505, 42, 339, 195);
		panel.add(jCommentList);
		
		lblAlert = new JLabel("*작성한 덧글은 삭제가 불가능합니다.");
		lblAlert.setForeground(Color.RED);
		lblAlert.setFont(new Font("돋움", Font.PLAIN, 12));
		lblAlert.setBounds(505, 277, 264, 15);
		panel.add(lblAlert);
		
		tfComment = new JTextField();
		tfComment.setBounds(505, 246, 230, 21);
		panel.add(tfComment);
		
		btnCommentAdd = new JButton("작성하기");
		btnCommentAdd.setFont(new Font("돋움", Font.PLAIN, 12));
		btnCommentAdd.setBounds(747, 245, 97, 23);
		panel.add(btnCommentAdd);
		btnCommentAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comen.add(new String(tfComment.getText()));
				//(new Comment(tfComment.getText()));
				jCommentList.setListData(comen);
			}
		});
		
		this.setVisible(true);
	}
	
	public void connect() {	
		try {
			socket = new Socket("192.168.0.55",5555);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				Vector<Store> tmp;
				while(true) {				
					try {
						model = new DefaultListModel();
						tmp = new Vector<Store>();
						tmp = (Vector<Store>) in.readObject();
						//Thread.sleep(3000);
						if(tmp.size()==0) {
							System.out.println("데이터가 없습니다");
						} else {							
							for(int i=0; i<tmp.size(); i++) {
								model.addElement(tmp.get(i));
								jFList.setModel(model);
							}
						}
						for(Store e: tmp) {
							System.out.println(e);
						}
						
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
//					catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("상대방이 연결을 종료했습니다.");
				//e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		Guest gue = new Guest();
	}
	
}

