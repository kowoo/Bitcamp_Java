package food;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FoodFighter extends JFrame {
	private static final long serialVersionUID = 1283403456965972738L;
	
	//private static final String FILE_NAME = "food.dat";
	private Vector<Food> fList;
	private JTextField tfName;
	private JTextField tfType;
	private JTextField tfTeleNumber;
	private JTextField tfOpenClosed;
	private JTextField tfPrice;
	private JTextField tfScore;
	private JList<Food> jFlist;
	JButton btnCheck;
	JButton btnDelete;
	JButton btnAdd;	
	JButton btnModify;
	
	public FoodFighter() {
		this.setTitle("너무너무 맛있잖아..");
		this.setSize(439, 372);
		setDefaultData();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMovieList = new JLabel("목록");
		lblMovieList.setBounds(12, 25, 57, 15);
		panel.add(lblMovieList);
		
		jFlist = new JList<Food>(fList);
		jFlist.setFont(new Font("돋움", Font.PLAIN, 12));
		jFlist.setBounds(12, 42, 162, 231);
		panel.add(jFlist);
		
		JLabel lblName = new JLabel("가게 이름");
		lblName.setBounds(206, 43, 57, 15);
		panel.add(lblName);
		
		tfName = new JTextField();
		tfName.setFont(new Font("돋움", Font.PLAIN, 12));
		tfName.setBounds(275, 40, 116, 21);
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblType = new JLabel("분류");
		lblType.setBounds(206, 83, 57, 15);
		panel.add(lblType);
		
		tfType = new JTextField();
		tfType.setFont(new Font("돋움", Font.PLAIN, 12));
		tfType.setBounds(275, 80, 116, 21);
		panel.add(tfType);
		tfType.setColumns(10);
		
		JLabel lblTeleNumber = new JLabel("전화번호");
		lblTeleNumber.setBounds(206, 123, 57, 15);
		panel.add(lblTeleNumber);
		
		tfTeleNumber = new JTextField();
		tfTeleNumber.setFont(new Font("돋움", Font.PLAIN, 12));
		tfTeleNumber.setBounds(275, 120, 116, 21);
		panel.add(tfTeleNumber);
		tfTeleNumber.setColumns(10);
		
		JLabel lblOpenClosed = new JLabel("영업시간");
		lblOpenClosed.setBounds(206, 163, 57, 15);
		panel.add(lblOpenClosed);
		
		tfOpenClosed = new JTextField();
		tfOpenClosed.setFont(new Font("돋움", Font.PLAIN, 12));
		tfOpenClosed.setBounds(275, 160, 116, 21);
		panel.add(tfOpenClosed);
		tfOpenClosed.setColumns(10);
		
		JLabel lblPrice = new JLabel("가격대");
		lblPrice.setBounds(206, 203, 57, 15);
		panel.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("돋움", Font.PLAIN, 12));
		tfPrice.setBounds(275, 200, 116, 21);
		panel.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblScore = new JLabel("평점");
		lblScore.setBounds(265, 249, 57, 15);
		panel.add(lblScore);
		
		tfScore = new JTextField();
		tfScore.setFont(new Font("돋움", Font.PLAIN, 12));
		tfScore.setBounds(334, 246, 57, 21);
		panel.add(tfScore);
		tfScore.setColumns(10);
		
		btnCheck = new JButton("조회");
		btnCheck.setFont(new Font("돋움", Font.PLAIN, 11));
		btnCheck.setBounds(12, 287, 57, 23);
		panel.add(btnCheck);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food food = jFlist.getSelectedValue();
				tfName.setText(food.getName());
				tfType.setText(food.getType());
				tfTeleNumber.setText(food.getTeleNumber());
				tfOpenClosed.setText(food.getOpenClosed());
				tfPrice.setText(food.getPrice()+"");
				tfScore.setText(food.getScore()+"");
			}
		});
		
		btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("돋움", Font.PLAIN, 11));
		btnDelete.setBounds(81, 287, 57, 23);
		panel.add(btnDelete);
		
		btnAdd = new JButton("추가");
		btnAdd.setFont(new Font("돋움", Font.PLAIN, 11));
		btnAdd.setBounds(206, 287, 62, 23);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fList.add(new Food(tfName.getText(),tfType.getText(),
						tfTeleNumber.getText(),tfOpenClosed.getText(),
						tfPrice.getText(),tfScore.getText()));
			}
		});
		
		btnModify = new JButton("수정");
		btnModify.setFont(new Font("돋움", Font.PLAIN, 11));
		btnModify.setBounds(329, 287, 62, 23);
		panel.add(btnModify);
		

		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		FoodFighter foodd = new FoodFighter();
	}
	
	public void setDefaultData() {
		fList = new Vector<Food>();
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
	}
}
