package food2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Guest extends JFrame {
	private static final long serialVersionUID = -940594805044462763L;

	private Vector<Food> fList;
	private JTextField tfName;
	private JTextField tfType;
	private JTextField tfTeleNumber;
	private JTextField tfOpenClosed;
	private JTextField tfPrice;
	private JTextField tfScore;
	private JList<Food> jFList;
	private JButton btnCheck;

	///////////연결을 위한 변수/////////
	private Socket socket;
	private ObjectInputStream in;

	public Guest() {
		fList = new Vector<Food>();
		this.setTitle("너무너무 맛있잖아..");
		this.setSize(936, 373);
		setDefaultData();


		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblMovieList = new JLabel("목록");
		lblMovieList.setBounds(12, 25, 57, 15);
		panel.add(lblMovieList);

		jFList = new JList<Food>(fList);
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
				Food food = jFList.getSelectedValue();
				tfName.setText(food.getName());
				tfType.setText(food.getType());
				tfTeleNumber.setText(food.getTeleNumber());
				tfOpenClosed.setText(food.getOpenClosed());
				tfPrice.setText(food.getPrice()+"");
				tfScore.setText(food.getScore()+"");
			}
		});

		this.setVisible(true);
	}

	public static void main(String[] args) {
		Guest gue = new Guest();
	}


	public void setDefaultData() {
		//fList = new Vector<Food>();
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
	}

	public void connect() {

		try {
			socket = new Socket("192.168.0.55",5555);
			in = new ObjectInputStream(socket.getInputStream());
			Thread receiver = new Thread(new Receiver(socket));
			receiver.start();

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
			try {
				//소켓으로부터 메시지를 읽어오는 부분
				while(true) {
					String msg = null;
					in.readObject();
					//in.
				}

			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

