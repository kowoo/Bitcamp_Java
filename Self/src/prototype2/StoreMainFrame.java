package prototype2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StoreMainFrame extends JFrame{
	private static final long serialVersionUID = 1283403456965972738L;
	//private static final String FILE_NAME = "food.dat";
	private JTextField tfName;
	private JTextField tfNum;
	private JTextField tfPrice;
	private JTextField tfScore;
	private JList<Store> jList;
	private JButton btnOpen;
	private JButton btnDelete;
	private JButton btnModify;
	private JButton btnAdd;

	private StoreDao dao;
	private Vector<Store> sList;

	public StoreMainFrame() {
		this.setTitle("꿀맛");
		this.setSize(463, 373);


		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		jList = new JList<Store>(sList);
		jList.setFont(new Font("돋움", Font.PLAIN, 12));
		jList.setBounds(12, 42, 162, 231);
		panel.add(jList);
//		jList.addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				Store store = jList.getSelectedValue();
//				tfNum.setText(store.getNum()+"");
//				tfName.setText(store.getName());
//				tfPrice.setText(store.getPrice()+"");
//				tfScore.setText(store.getScore()+"");			
//			}
//		});

		tfNum = new JTextField();
		tfNum.setFont(new Font("돋움", Font.PLAIN, 12));
		tfNum.setBounds(275, 40, 116, 21);
		panel.add(tfNum);

		tfName = new JTextField();
		tfName.setFont(new Font("돋움", Font.PLAIN, 12));
		tfName.setBounds(275, 120, 116, 21);
		panel.add(tfName);

		tfPrice = new JTextField();
		tfPrice.setFont(new Font("돋움", Font.PLAIN, 12));
		tfPrice.setBounds(275, 200, 116, 21);
		panel.add(tfPrice);

		tfScore = new JTextField();
		tfScore.setFont(new Font("돋움", Font.PLAIN, 12));
		tfScore.setBounds(334, 246, 57, 21);
		panel.add(tfScore);

		btnOpen = new JButton("조회");
		btnOpen.setFont(new Font("돋움", Font.PLAIN, 11));
		btnOpen.setBounds(12, 287, 57, 23);
		panel.add(btnOpen);
		btnOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = jList.getSelectedIndex();
				Store tmp = dao.selectOne(num+1);
				System.out.println(num);
				System.out.println(tmp);
				tfNum.setText(tmp.getNum()+"");
				tfName.setText(tmp.getName());
				tfPrice.setText(tmp.getPrice()+"");
				tfScore.setText(tmp.getScore()+"");
			}
		});

		btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("돋움", Font.PLAIN, 11));
		btnDelete.setBounds(117, 287, 57, 23);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = jList.getSelectedIndex();
				dao.deleteStore(num+1);
				setDefaultData();
			}
		});
		
		btnModify = new JButton("수정");
		btnModify.setFont(new Font("돋움", Font.PLAIN, 11));
		btnModify.setBounds(265, 287, 57, 23);
		panel.add(btnModify);
		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Store store = new Store();
				store.setNum(Integer.parseInt(tfNum.getText()));
				store.setName(tfName.getText());
				store.setPrice(Integer.parseInt(tfPrice.getText()));
				store.setScore(Integer.parseInt(tfScore.getText()));
				dao.updateStore(store);
				setDefaultData();
			}
		});

		btnAdd = new JButton("추가");
		btnAdd.setFont(new Font("돋움", Font.PLAIN, 11));
		btnAdd.setBounds(334, 287, 57, 23);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Store store = new Store();
				store.setNum(Integer.parseInt(tfNum.getText()));
				store.setName(tfName.getText());
				store.setPrice(Integer.parseInt(tfPrice.getText()));
				store.setScore(Integer.parseInt(tfScore.getText()));
				dao.insertStore(store);
				setDefaultData();
			}
		});

		JLabel lblStoreList = new JLabel("목록");
		lblStoreList.setBounds(12, 25, 57, 15);
		panel.add(lblStoreList);

		JLabel lblNum = new JLabel("번호");
		lblNum.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNum.setBounds(206, 43, 57, 15);
		panel.add(lblNum);
		
		JLabel lblName = new JLabel("가게 이름");
		lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblName.setBounds(206, 123, 57, 15);
		panel.add(lblName);
		
		JLabel lblPrice = new JLabel("가격대");
		lblPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblPrice.setBounds(206, 203, 57, 15);
		panel.add(lblPrice);
		
		JLabel lblScore = new JLabel("평점");
		lblScore.setBounds(265, 249, 57, 15);
		panel.add(lblScore);
		
		setDefaultData();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		StoreMainFrame storeL = new StoreMainFrame();
	}

	public void setDefaultData() {
		dao = new StoreDao();
		//dao.selectAll();
		sList = new Vector<Store>(dao.selectAll());
		for(Store s: sList) {
			System.out.println(s);
		}
		jList.setListData(sList);
	}

}
