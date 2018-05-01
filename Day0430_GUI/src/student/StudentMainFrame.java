package student;

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
import javax.swing.SwingConstants;

public class StudentMainFrame extends JFrame {

	//학생 리스트를 보여주고 선택하여 기본 정보를 보여주는 화면
	//데이터: 학생리스트 (실제 학생 정보를 가지고 있는 리스트 객체)
	private Vector<Student> sList;
	
	private static final long serialVersionUID = 3639397401352739935L;
	private JTextField tfName;
	private JTextField tfTotal;
	private JTextField tfAverage;
	private JButton btnDetail;
	private JButton btnSelect;
	private JList<Student> studentJList; //화면에 뿌려줄 때 List가 아니라 Vector를 이용한다.
	
	public StudentMainFrame() {
		this.setTitle("학생관리");
		this.setSize(379, 332);
		
		//기본 데이터 생성 및 sList에 데이터 넣기
		setDefaultData();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//학생 목록을 화면에 보여줄 컴포넌트
		studentJList = new JList<Student>(sList);
		studentJList.setFont(new Font("돋움", Font.PLAIN, 12));
		studentJList.setBounds(12, 10, 141, 273);
		//기본 선택값 주기. 이렇게하면 첫번째 녀석이 선택된채로 실행된다
		studentJList.setSelectedIndex(0);
		panel.add(studentJList);
		
		btnDetail = new JButton("상세보기");
		btnDetail.setFont(new Font("돋움", Font.PLAIN, 12));
		btnDetail.setBounds(165, 222, 91, 31);
		panel.add(btnDetail);
		
		btnSelect = new JButton("점수보기");
		btnSelect.setFont(new Font("돋움", Font.PLAIN, 12));
		btnSelect.setBounds(259, 222, 91, 31);
		panel.add(btnSelect);
		
		btnSelect.addActionListener(new ActionListener() {
						@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student student = studentJList.getSelectedValue();
				tfName.setText(student.getName());
				tfTotal.setText(student.getTotal()+"");
				tfAverage.setText(student.getAverage()+"");
			}
		});
		
		tfName = new JTextField();
		tfName.setFont(new Font("돋움", Font.PLAIN, 12));
		tfName.setBounds(234, 70, 116, 21);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfTotal = new JTextField();
		tfTotal.setFont(new Font("돋움", Font.PLAIN, 12));
		tfTotal.setBounds(234, 120, 116, 21);
		panel.add(tfTotal);
		tfTotal.setColumns(10);
		
		tfAverage = new JTextField();
		tfAverage.setFont(new Font("돋움", Font.PLAIN, 12));
		tfAverage.setBounds(234, 170, 116, 21);
		panel.add(tfAverage);
		tfAverage.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setFont(new Font("돋움", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(165, 73, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("총점");
		lblNewLabel_1.setFont(new Font("돋움", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(165, 123, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("평균");
		lblNewLabel_2.setFont(new Font("돋움", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(165, 173, 57, 15);
		panel.add(lblNewLabel_2);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		StudentMainFrame mainFrame = new StudentMainFrame();
	}
	
	//임의의 데이터를 만들어주는 메서드 작성
	
	public void setDefaultData() {
		sList = new Vector<Student>();
		sList.add(new Student("재규어",3,100,100,100));
		sList.add(new Student("강아지",3,90,100,90));
		sList.add(new Student("고양이",3,100,90,100));
		sList.add(new Student("햄스터",3,80,99,85));
		sList.add(new Student("다람쥐",3,10,12,100));
	}
	
}
