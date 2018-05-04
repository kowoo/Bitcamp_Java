package multi;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SL extends JFrame {
	private JTextField tfName;
	private JTextField tfGrade;
	private JTextField tfClass;
	private JTextField tfNumber;
	private JList list;
	private JButton btOpen;
	private JButton btModify;
	private JButton btDel;
	private JButton btSave;
	
	public SL() {
		this.setTitle("미정");
		this.setSize(400, 301);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbName = new JLabel("이름");
		lbName.setBounds(198, 10, 57, 15);
		panel.add(lbName);
		
		JLabel lbGrade = new JLabel("학년");
		lbGrade.setBounds(198, 50, 57, 15);
		panel.add(lbGrade);
		
		JLabel lbClass = new JLabel("반");
		lbClass.setBounds(198, 90, 57, 15);
		panel.add(lbClass);
		
		JLabel lbNumber = new JLabel("번호");
		lbNumber.setBounds(198, 130, 57, 15);
		panel.add(lbNumber);
		
		tfName = new JTextField();
		tfName.setBounds(240, 8, 116, 21);
		panel.add(tfName);
		
		tfGrade = new JTextField();
		tfGrade.setBounds(240, 47, 116, 21);
		panel.add(tfGrade);
		
		tfClass = new JTextField();
		tfClass.setBounds(240, 87, 116, 21);
		panel.add(tfClass);
		
		tfNumber = new JTextField();
		tfNumber.setBounds(240, 127, 116, 21);
		panel.add(tfNumber);
		
		//리스트와 버튼들
		
		list = new JList();
		list.setBounds(12, 10, 174, 233);
		panel.add(list);
		
		btOpen = new JButton("조회");
		btOpen.setBounds(198, 170, 63, 23);
		panel.add(btOpen);
		
		btModify = new JButton("수정");
		btModify.setBounds(309, 170, 63, 23);
		panel.add(btModify);
		
		btDel = new JButton("삭제");
		btDel.setBounds(198, 220, 63, 23);
		panel.add(btDel);
		
		btSave = new JButton("저장");
		btSave.setBounds(309, 220, 63, 23);
		panel.add(btSave);
		
		this.setVisible(true);
	}
}
