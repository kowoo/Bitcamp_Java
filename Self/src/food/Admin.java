package food;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Admin extends JFrame {
	private static final long serialVersionUID = 1283403456965972738L;

	//private static final String FILE_NAME = "food.dat";
	private Vector<Food> fList;
	private JTextField tfName;
	private JTextField tfType;
	private JTextField tfTeleNumber;
	private JTextField tfOpenClosed;
	private JTextField tfPrice;
	private JTextField tfScore;
	private JList<Food> jFList;
	private JButton btnCheck;
	private JButton btnDelete;
	private JButton btnAdd;	
	private JButton btnModify;

	private Vector<String> comen;
	private JList<String> jCommentList;
	private JLabel lblcomment;
	private JTextField tfComment;
	private JLabel lblAlert;
	private JButton btnCommentAdd;
	private JButton btnCommentDelete;

	public Admin() {
		fList = new Vector<Food>();
		comen = new Vector<String>();
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

		//삭제
		btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("돋움", Font.PLAIN, 11));
		btnDelete.setBounds(81, 287, 57, 23);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food food = jFList.getSelectedValue();
				fList.remove(food);
				jFList.setListData(fList);	
			}
		});

		//추가
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
				//Food food = new Food(name,type,teleNumber,openClosed,price,score);
				//fList.add(food);
				fList.add(new Food(name,type,teleNumber,openClosed,price,score));
				jFList.setListData(fList);
			}
		});

		//수정
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
				fList.set(jFList.getSelectedIndex(), new Food(name,type,teleNumber,openClosed,price,score));
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

		btnCommentDelete = new JButton("삭제");
		btnCommentDelete.setFont(new Font("돋움", Font.PLAIN, 12));
		btnCommentDelete.setBounds(747, 273, 97, 23);
		panel.add(btnCommentDelete);
		btnCommentDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String com = jCommentList.getSelectedValue();
				comen.remove(com);
				jCommentList.setListData(comen);
			}
		});




		this.setVisible(true);
	}


	public static void main(String[] args) {
		Admin foodd = new Admin();
	}

	public void setDefaultData() {
		//fList = new Vector<Food>();
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		fList.add(new Food("아빠곰 수제돈까스","분식, 일식","02-3478-9433","11:30~19:30","6000","5"));
		fList.add(new Food("모스버거","패스트푸드","02-522-0799","08:00~22:00","5000","3"));
		comen.add(new String("멍청이"));
		comen.add(new String("응 광고"));
		comen.add(new String("안물"));
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
